import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Checking for duplicate values in each row
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        duplicateRows++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Checking for duplicate values in each column
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i]]) {
                        duplicateCols++;
                        break;
                    }
                    seen[matrix[j][i]] = true;
                }
            }

            // Printing the results for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
            caseNumber++;
        }

        scanner.close();
    }
}