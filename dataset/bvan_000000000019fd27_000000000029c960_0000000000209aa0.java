import java.io.*;
import java.util.*;
import java.util.stream.*;

// Backtracking
public class Solution {
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            int size = scanner.nextInt();
            int trace = scanner.nextInt();
            LatinSquare latinSquare = buildLatinSquare2(size, trace);
            if (latinSquare != null) {
                System.out.println(String.format("Case #%d: POSSIBLE", t));
                System.out.println(latinSquare);
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            }
        }
    }
    
    private static LatinSquare buildLatinSquare2(int size, int trace) {
        LatinSquare latinSquare = new LatinSquare(size);
        boolean success = build(latinSquare, trace, 0, 0);
        return success ? latinSquare : null;
    }

    private static boolean build(LatinSquare latinSquare, int trace, int i, int j) {
        if (i == latinSquare.size() || j == latinSquare.size()) {
            return latinSquare.getDiagonal() == trace;
        }

        Set<Integer> candidates = latinSquare.getCandidates(i, j);
        for (int candidate : candidates) {
            latinSquare.set(i, j, candidate);

            int nextI = (j == latinSquare.size() - 1) ? i + 1 : i;
            int nextJ = (j == latinSquare.size() - 1) ? 0 : j + 1;
            boolean success = build(latinSquare, trace, nextI, nextJ);

            if (success) {
                return true;
            } else {
                latinSquare.unset(i, j);
            }
        }
        return false;
    }

    private static class LatinSquare {

        private final int[][] matrix;
        private final List<Set<Integer>> rowUniques;
        private final List<Set<Integer>> colUniques;

        public LatinSquare(int size) {
            this.matrix = new int[size][size];
            this.rowUniques = generateUniques(size);
            this.colUniques = generateUniques(size);
        }

        public int size() {
            return matrix.length;
        }

        private static List<Set<Integer>> generateUniques(int size) {
            return IntStream.rangeClosed(1, size)
                    .mapToObj(i -> IntStream.rangeClosed(1, size).boxed()
                            .collect(Collectors.toCollection(LinkedHashSet::new)))
                    .collect(Collectors.toList());
        }

        public void set(int i, int j, int val) {
            matrix[i][j] = val;
            rowUniques.get(i).remove(val);
            colUniques.get(j).remove(val);
        }

        public void unset(int i, int j) {
            int val = matrix[i][j];
            matrix[i][j] = 0;
            rowUniques.get(i).add(val);
            colUniques.get(j).add(val);
        }

        public int get(int i, int j) {
            return matrix[i][j];
        }

        public Set<Integer> getCandidates(int i, int j) {
            return intersection(rowUniques.get(i), colUniques.get(j));
        }

        public int getDiagonal() {
            int sum = 0;
            for (int i = 0; i < size(); i++) {
                sum += matrix[i][i];
            }
            return sum;
        }

        private static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
            return set1.stream()
                    .filter(set2::contains)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        @Override
        public String toString() {
            return Stream.of(matrix)
                    .map(row -> IntStream.of(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                    .collect(Collectors.joining("\n"));
        }
    }
}

class FastScanner {

    private final StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public int nextInt()  {
        try {
            streamTokenizer.nextToken();
            return (int) streamTokenizer.nval;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

