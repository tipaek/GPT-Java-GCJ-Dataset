import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int i = 0; i < tests; i++) {
            int[][] matrix = parseOne(scanner);
            Sol sol = solve(matrix, matrix[0].length);
            System.out.println(String.format("Case #%d: %d %d %d", i+1, sol.getTrace(), sol.getRowsWithDuplicates(), sol.getColsWithDuplicates()));
        }
    }

    private static int[][] parseOne(Scanner scanner) {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static Sol solve(int [][] input, int size) {
        int columnsWithDuplicates = 0;
        int rowsWithDuplicates = 0;
        int trace = 0;
        BitSet seenInRow = new BitSet(size);
        BitSet seenInCol = new BitSet(size);

        for (int row = 0; row < size; row++) {
            seenInRow.clear();
            seenInCol.clear();
            boolean columnHasDuplicate = false;
            boolean rowHasDuplicate = false;
            for (int col = 0; col < size; col++) {
                int rowVal = input[row][col];
                int colVal = input[col][row];

                if (row == col) {
                    trace += rowVal;
                }

                if (seenInRow.get(rowVal)) {
                    rowHasDuplicate = true;
                }
                seenInRow.set(rowVal);

                if (seenInCol.get(colVal)) {
                    columnHasDuplicate = true;
                }
                seenInCol.set(colVal);
            }
            if (rowHasDuplicate) {
                rowsWithDuplicates ++;
            }
            if (columnHasDuplicate) {
                columnsWithDuplicates ++;
            }
        }
        return new Sol(trace, rowsWithDuplicates, columnsWithDuplicates);
    }

    private static class Sol {
        private final long trace;
        private final long rowsWithDuplicates;
        private final long colsWithDuplicates;

        private Sol(long trace, long rowsWithDuplicates, long colsWithDuplicates) {
            this.trace = trace;
            this.rowsWithDuplicates = rowsWithDuplicates;
            this.colsWithDuplicates = colsWithDuplicates;
        }

        public long getTrace() {
            return trace;
        }

        public long getRowsWithDuplicates() {
            return rowsWithDuplicates;
        }

        public long getColsWithDuplicates() {
            return colsWithDuplicates;
        }
    }
}
