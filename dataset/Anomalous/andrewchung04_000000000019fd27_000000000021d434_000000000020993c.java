import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate the sum of the main diagonal
            int diagonalSum = 0;
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
            }

            // Calculate the number of rows with repeated elements
            int repeatedRows = 0;
            for (int row = 0; row < n; row++) {
                HashSet<Integer> seen = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!seen.add(matrix[row][col])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Calculate the number of columns with repeated elements
            int repeatedCols = 0;
            for (int col = 0; col < n; col++) {
                HashSet<Integer> seen = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!seen.add(matrix[row][col])) {
                        repeatedCols++;
                        break;
                    }
                }
            }

            // Output the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", i + 1, diagonalSum, repeatedRows, repeatedCols);
        }
    }
}