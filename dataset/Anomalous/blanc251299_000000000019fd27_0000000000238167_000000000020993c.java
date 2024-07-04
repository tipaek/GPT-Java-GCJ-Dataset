import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowCount = 0, colCount = 0;

            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Checking rows for duplicates
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowCount++;
                }
            }

            // Checking columns for duplicates
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(getColumn(matrix, j))) {
                    colCount++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (value > array.length || !set.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int n = matrix.length;
        int[] column = new int[n];
        for (int i = 0; i < n; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}