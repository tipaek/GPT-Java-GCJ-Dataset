import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int trace = scanner.nextInt();
            LatinSquare latinSquare = createLatinSquare(size, trace);
            if (latinSquare != null) {
                System.out.printf("Case #%d: POSSIBLE%n", t);
                System.out.println(latinSquare);
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t);
            }
        }
    }

    private static LatinSquare createLatinSquare(int size, int trace) {
        LatinSquare latinSquare = new LatinSquare(size);
        if (fillLatinSquare(latinSquare, trace, 0, 0)) {
            return latinSquare;
        }
        return null;
    }

    private static boolean fillLatinSquare(LatinSquare latinSquare, int trace, int row, int col) {
        if (row == latinSquare.size() || col == latinSquare.size()) {
            return latinSquare.calculateDiagonalSum() == trace;
        }

        Set<Integer> candidates = latinSquare.getCandidates(row, col);
        for (int candidate : candidates) {
            latinSquare.setValue(row, col, candidate);

            int nextRow = (col == latinSquare.size() - 1) ? row + 1 : row;
            int nextCol = (col == latinSquare.size() - 1) ? 0 : col + 1;
            if (fillLatinSquare(latinSquare, trace, nextRow, nextCol)) {
                return true;
            } else {
                latinSquare.removeValue(row, col);
            }
        }
        return false;
    }

    private static class LatinSquare {

        private final int[][] grid;
        private final List<Set<Integer>> rowValues;
        private final List<Set<Integer>> colValues;

        public LatinSquare(int size) {
            grid = new int[size][size];
            rowValues = initializeUniqueSets(size);
            colValues = initializeUniqueSets(size);
        }

        public int size() {
            return grid.length;
        }

        private static List<Set<Integer>> initializeUniqueSets(int size) {
            return IntStream.range(0, size)
                    .mapToObj(i -> IntStream.rangeClosed(1, size).boxed().collect(Collectors.toCollection(LinkedHashSet::new)))
                    .collect(Collectors.toList());
        }

        public void setValue(int row, int col, int value) {
            grid[row][col] = value;
            rowValues.get(row).remove(value);
            colValues.get(col).remove(value);
        }

        public void removeValue(int row, int col) {
            int value = grid[row][col];
            grid[row][col] = 0;
            rowValues.get(row).add(value);
            colValues.get(col).add(value);
        }

        public Set<Integer> getCandidates(int row, int col) {
            return rowValues.get(row).stream()
                    .filter(colValues.get(col)::contains)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        public int calculateDiagonalSum() {
            return IntStream.range(0, size()).map(i -> grid[i][i]).sum();
        }

        @Override
        public String toString() {
            return Arrays.stream(grid)
                    .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                    .collect(Collectors.joining("\n"));
        }
    }
}

class FastScanner {

    private final StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public int nextInt() {
        try {
            tokenizer.nextToken();
            return (int) tokenizer.nval;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}