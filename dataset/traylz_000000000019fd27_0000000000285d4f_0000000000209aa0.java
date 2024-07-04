
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;

public class Solution {

    public static final String IMPOSSIBURU11 = "IMPOSSIBLE";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= numOfCases; i++) {
            String[] params = in.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int k = Integer.parseInt(params[1]);
            String solution = solve(n, k);
            System.out.println("Case #" + i + ":" + solution);
        }
    }


    public static String solve(int size, int trace) {
        List<Integer> decomposition = decomposition(size, trace);
        if (decomposition.isEmpty()) {
            return IMPOSSIBURU11;
        }
        Matrix matrix = new Matrix(size);
        for (int i = 0; i < decomposition.size(); i++) {
            matrix.put(i, i, decomposition.get(i));
        }
        while (!matrix.isDeterministic()) {
            boolean cellDefined = false;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    cellDefined |= matrix.tryDeterminate(i, j);
                }
            }
            if (!cellDefined) {
                matrix.pickAny();
            }
        }
        return formatResult(matrix);
    }

    private static String formatResult(Matrix matrix) {
        StringBuilder str = new StringBuilder("POSSIBLE\n");
        for (int i = 0; i < matrix.size; i++) {
            final int row = i;
            String formattedRow = IntStream.range(0, matrix.size).mapToObj(j -> matrix.get(row, j) + 1).map(Object::toString).collect(Collectors.joining(" "));
            str.append(formattedRow);
            str.append("\n");
        }
        return str.toString();
    }

    public static List<Integer> decomposition(int size, int trace) {
        int extra = trace - size;
        List<Integer> result = IntStream.range(0, size).mapToObj(i -> 0).collect(Collectors.toList());
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


    public void put(int row, int column, Integer value) {
        BitSet bitSet = getPossibilities(row, column);
        bitSet.clear();
        bitSet.set(value);
        for (int i = 0; i < size; i++) {
            if (i != column) {
                BitSet other = getPossibilities(row, i);
                other.clear(value);
                if (other.isEmpty()) {
                    throw new IllegalStateException("WUUT");
                }
            }
        }
        for (int j = 0; j < size; j++) {
            if (j != row) {
                BitSet other = getPossibilities(j, column);
                other.clear(value);
                if (other.isEmpty()) {
                    throw new IllegalStateException("WUUT");
                }
            }
        }

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
        for (int j = 0; j < size; j++) {
            if (j != column) {
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

    public void pickAny() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                BitSet possibilities = getPossibilities(i, j);
                if (possibilities.cardinality() > 1) {
                    put(i, j, possibilities.nextSetBit(0));
                }
            }
        }
    }


    public int get(int row, int column) {
        BitSet bitSet = getPossibilities(row, column);
        if (bitSet.cardinality() != 1) {
            throw new IllegalStateException("Cell state is not deterministic");
        }
        return bitSet.nextSetBit(0);
    }

    public boolean isDeterministic() {
        return possibilities.stream().flatMap(Collection::stream).allMatch(it -> it.cardinality() == 1);
    }
}
