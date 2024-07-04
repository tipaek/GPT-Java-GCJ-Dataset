import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculating the sum of the main diagonal
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Checking for duplicate values in rows
            int duplicateRows = 0;
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

            // Checking for duplicate values in columns
            int duplicateColumns = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        duplicateColumns++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}