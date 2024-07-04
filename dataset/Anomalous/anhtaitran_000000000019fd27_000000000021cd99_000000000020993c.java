import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Checking for duplicate values in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j] - 1]) {
                        duplicateRows++;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
            }

            // Checking for duplicate values in columns
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j] - 1]) {
                        duplicateCols++;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
            caseNumber++;
        }

        scanner.close();
    }
}