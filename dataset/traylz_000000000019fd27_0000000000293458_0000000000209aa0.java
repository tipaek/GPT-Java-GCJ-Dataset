
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;

public class Solution {

    public static final String IMPOSSIBURU11 = "IMPOSSIBLE";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= numOfCases; i++) {
            String[] params = in.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int k = Integer.parseInt(params[1]);
            Optional<Matrix> solution = solve(n, k);
            System.out.println("Case #" + i + ": " + formatResult(solution));
        }
    }

    private static String formatResult(Optional<Matrix> solution) {
        if (!solution.isPresent()) {
            return IMPOSSIBURU11;
        }
        Matrix matrix = solution.get();
        return "POSSIBLE" + matrix.toString();
    }

    public static Optional<Matrix> solve(int size, int trace) {
        List<Integer> decomposition = decomposition(size, trace);
        if (decomposition.isEmpty()) {
            return Optional.empty();
        }
        Matrix matrix = new Matrix(size);
        Deque<ForkedMatrix> forks = new ArrayDeque<>();
        for (int i = 0; i < decomposition.size(); i++) {
            matrix.put(i, i, decomposition.get(i));
        }
        int attempt = 0;
        while (!matrix.isDeterministic()) {
            boolean cellDefined = false;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    cellDefined |= matrix.tryDeterminate(i, j);
                }
            }
            if (!cellDefined) {
                forks.push(new ForkedMatrix(matrix.copy(), attempt));
                Matrix.PickResult couldPick = matrix.pickAny(attempt);
                if (couldPick == Matrix.PickResult.INVARIANT_FAILURE) {
                    ForkedMatrix forkedMatrix = forks.pop();
                    attempt = forkedMatrix.attempt + 1;
                    matrix = forkedMatrix.matrix;
                } else if (couldPick == Matrix.PickResult.EXHAUSTED) {
                    forks.pop(); // dead branch
                    ForkedMatrix forkedMatrix = forks.pop();
                    attempt = forkedMatrix.attempt + 1;
                    matrix = forkedMatrix.matrix;
                }
            }
        }

        return Optional.of(matrix);
    }

    static class ForkedMatrix {
        final Matrix matrix;
        final int attempt;

        ForkedMatrix(Matrix matrix, int attempt) {
            this.matrix = matrix;
            this.attempt = attempt;
        }
    }

    public static List<Integer> decomposition(int size, int trace) {
        if (trace % size == 0) {
            return IntStream.range(0, size).mapToObj(i -> (trace/size) - 1).collect(toList());
        }
        int extra = trace - size;
        List<Integer> result = IntStream.range(0, size).mapToObj(i -> 0).collect(toList());
        if (trace == size) {
            return result;
        }
        for (int i = 0; i < size && extra != 0; i++) {
            if (extra < size) {
                result.set(i, extra);
                extra = 0;
            } else {
                extra -= (size - 1);
                result.set(i, size - 1);
            }
        }
        if (noSolution(size, result)) {
            result.set(size - 1, result.get(size - 1) + 1);
            result.set(0, result.get(0) - 1);
        }
        if (noSolution(size, result)) {
            return Collections.emptyList();
        }
        return result;
    }

    private static boolean noSolution(int size, List<Integer> result) {
        Map<Integer, Long> counts = result.stream().collect(Collectors.groupingBy(identity(), Collectors.counting()));
        return counts.values().stream().anyMatch(it -> it == size - 1);
    }
}

class Matrix {
    private final List<List<BitSet>> possibilities;
    public final int size;

    Matrix(int size) {
        possibilities = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ArrayList<BitSet> row = new ArrayList<>(size);
            possibilities.add(i, row);
            for (int j = 0; j < size; j++) {
                BitSet element = new BitSet(size);
                element.set(0, size);
                row.add(j, element);
            }
        }
        this.size = size;
    }


    public boolean put(int row, int column, Integer value) {
        BitSet bitSet = getPossibilities(row, column);
        bitSet.clear();
        bitSet.set(value);
        for (int i = 0; i < size; i++) {
            if (i != column) {
                BitSet other = getPossibilities(row, i);
                if (other.get(value)) {
                    other.clear(value);
                    if (other.isEmpty()) {
                        return false;
                    } else if (other.cardinality() == 1) {
                        put(row, i, other.nextSetBit(0));
                    }
                }
            }
        }
        for (int j = 0; j < size; j++) {
            if (j != row) {
                BitSet other = getPossibilities(j, column);
                if (other.get(value)) {
                    other.clear(value);
                    if (other.isEmpty()) {
                        return false;
                    } else if (other.cardinality() == 1) {
                        put(j, column, other.nextSetBit(0));
                    }
                }
            }
        }
        return true;

    }

    private BitSet getPossibilities(int row, int column) {
        return possibilities.get(row).get(column);
    }

    public boolean tryDeterminate(int row, int column) {
        BitSet possibilities = getPossibilities(row, column);
        if (possibilities.cardinality() == 1) {
            return false; // already determined
        }
        BitSet copy = new BitSet(size);
        copy.or(possibilities);
        for (int i = 0; i < size; i++) {
            if (i != column) {
                BitSet other = getPossibilities(row, i);
                copy.andNot(other);
            }
        }
        if (copy.cardinality() == 1) {
            put(row, column, copy.nextSetBit(0));
            return true;
        }
        for (int j = 0; j < size; j++) {
            if (j != row) {
                BitSet other = getPossibilities(j, column);
                copy.andNot(other);
            }
        }
        if (copy.cardinality() == 1) {
            put(row, column, copy.nextSetBit(0));
            return true;
        }
        return false;
    }

    enum PickResult {
        OK, EXHAUSTED, INVARIANT_FAILURE
    }

    public PickResult pickAny(int attempt) {
        int level = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                BitSet possibilities = getPossibilities(i, j);
                if (possibilities.cardinality() > 1) {
                    if (level == attempt) {
                        if (put(i, j, possibilities.nextSetBit(0))) {
                            return PickResult.OK;
                        } else {
                            return PickResult.INVARIANT_FAILURE;
                        }
                    } else {
                        level++;
                    }
                }
            }
        }
        return PickResult.EXHAUSTED;
    }

    public Matrix copy() {
        Matrix copy = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                BitSet copyPoss = copy.getPossibilities(i, j);
                copyPoss.clear();
                copyPoss.or(getPossibilities(i, j));
            }
        }
        return copy;
    }

    public boolean isDeterministic() {
        return possibilities.stream().flatMap(Collection::stream).allMatch(it -> it.cardinality() == 1);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            str.append("\n");
            final int row = i;
            String formattedRow = IntStream.range(0, this.size).mapToObj(j -> this.getAsStr(row, j)).collect(Collectors.joining(" "));
            str.append(formattedRow);
        }
        return str.toString();
    }

    private String getAsStr(int row, int column) {
        BitSet bitSet = getPossibilities(row, column);
        if (bitSet.cardinality() == 1) {
            return Integer.toString(bitSet.nextSetBit(0) + 1);
        } else {
            return bitSet.toString();
        }
    }
}
