import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            testCases--;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            boolean[] rowFlags = new boolean[n];
            boolean[] colFlags = new boolean[n];

            // Calculate trace and row duplicates
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = Math.abs(matrix[i][j]);
                    if (i == j) {
                        trace += num;
                    }
                    int index = num - 1;
                    if (!rowFlags[i]) {
                        if (matrix[i][index] < 0) {
                            rowFlags[i] = true;
                            rowDuplicates++;
                        } else {
                            matrix[i][index] = -matrix[i][index];
                        }
                    }
                }
            }

            // Reset negative values to positive
            resetMatrix(matrix, n);

            // Calculate column duplicates
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = Math.abs(matrix[i][j]);
                    int index = num - 1;
                    if (!colFlags[j]) {
                        if (matrix[index][j] < 0) {
                            colFlags[j] = true;
                            colDuplicates++;
                        } else {
                            matrix[index][j] = -matrix[index][j];
                        }
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            caseNumber++;
        }
    }

    // Method to reset the matrix values to positive
    private static void resetMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    matrix[i][j] = -matrix[i][j];
                }
            }
        }
    }
}