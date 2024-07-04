import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int k = 1; k <= t; k++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[][] transposedMatrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Transpose the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    transposedMatrix[i][j] = matrix[j][i];
                }
            }

            // Calculate the sum of the diagonal elements
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Sort each row of the matrix
            for (int i = 0; i < n; i++) {
                Arrays.sort(matrix[i]);
            }

            // Count rows with duplicate elements in the original matrix
            int duplicateRowCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (matrix[i][j] == matrix[i][j + 1]) {
                        duplicateRowCount++;
                        break;
                    }
                }
            }

            // Sort each row of the transposed matrix
            for (int i = 0; i < n; i++) {
                Arrays.sort(transposedMatrix[i]);
            }

            // Count columns with duplicate elements (rows in the transposed matrix)
            int duplicateColumnCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (transposedMatrix[i][j] == transposedMatrix[i][j + 1]) {
                        duplicateColumnCount++;
                        break;
                    }
                }
            }

            // Print the results for the test case
            System.out.printf("Case #%d: %d %d %d%n", k, diagonalSum, duplicateRowCount, duplicateColumnCount);
        }
    }
}