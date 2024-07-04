import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int[][] transposedMatrix = new int[n][n];
            
            // Read matrix input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
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
                Arrays.sort(matrix[i]);
            }
            
            // Count rows with duplicate elements in the original matrix
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (matrix[i][j] == matrix[i][j + 1]) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            
            // Sort the transposed matrix rows
            for (int i = 0; i < n; i++) {
                Arrays.sort(transposedMatrix[i]);
            }
            
            // Count columns with duplicate elements in the transposed matrix
            int duplicateColumns = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (transposedMatrix[i][j] == transposedMatrix[i][j + 1]) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            
            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", k, diagonalSum, duplicateRows, duplicateColumns);
        }
        
        sc.close();
    }
}