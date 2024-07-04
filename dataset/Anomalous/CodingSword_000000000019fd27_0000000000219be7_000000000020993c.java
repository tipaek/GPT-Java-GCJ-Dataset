import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Count rows and columns with duplicates
            int rowsWithDuplicates = 0;
            int colsWithDuplicates = 0;

            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowsWithDuplicates++;
                }
            }

            for (int j = 0; j < n; j++) {
                if (hasDuplicates(getColumn(matrix, j))) {
                    colsWithDuplicates++;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", t, trace, rowsWithDuplicates, colsWithDuplicates);
        }

        scanner.close();
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}