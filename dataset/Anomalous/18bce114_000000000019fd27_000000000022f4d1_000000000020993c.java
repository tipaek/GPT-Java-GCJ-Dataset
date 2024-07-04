import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[][] rowCheck = new int[n][n];
            int[][] colCheck = new int[n][n];

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Read the matrix and calculate the trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    rowCheck[matrix[row][col] - 1][row]++;
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int row = 0; row < n; row++) {
                for (int value = 0; value < n; value++) {
                    if (rowCheck[value][row] > 1) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    colCheck[matrix[row][col] - 1][col]++;
                }
            }

            for (int col = 0; col < n; col++) {
                for (int value = 0; value < n; value++) {
                    if (colCheck[value][col] > 1) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            System.out.println("case #" + (caseIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}