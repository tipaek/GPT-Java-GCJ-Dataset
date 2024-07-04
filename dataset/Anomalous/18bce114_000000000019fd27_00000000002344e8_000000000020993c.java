import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[][] rowCounts = new int[n][n];
            int[][] colCounts = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read the matrix and calculate trace and row counts
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowCounts[matrix[i][j] - 1][i]++;
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }

                // Check for row duplicates
                for (int j = 0; j < n; j++) {
                    if (rowCounts[j][i] > 1) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Calculate column counts
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    colCounts[matrix[i][j] - 1][j]++;
                }

                // Check for column duplicates
                for (int i = 0; i < n; i++) {
                    if (colCounts[i][j] > 1) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            // Output the result for the current case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}