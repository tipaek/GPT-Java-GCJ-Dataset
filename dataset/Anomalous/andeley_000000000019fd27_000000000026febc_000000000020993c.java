import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int duplicateRows = 0;
            int duplicateCols = 0;
            int diagonalSum = 0;

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculating diagonal sum
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Checking for duplicate elements in rows
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

            // Checking for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        duplicateCols++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Outputting the result
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
            caseNumber++;
        }
    }
}