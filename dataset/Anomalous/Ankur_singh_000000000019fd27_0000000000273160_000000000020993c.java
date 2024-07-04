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
            
            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            // Transposing the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    transposedMatrix[i][j] = matrix[j][i];
                }
            }
            
            // Calculating the sum of the diagonal elements
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }
            
            // Counting rows with duplicate elements
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                Arrays.sort(matrix[i]);
                for (int j = 0; j < n - 1; j++) {
                    if (matrix[i][j] == matrix[i][j + 1]) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            
            // Counting columns with duplicate elements
            int duplicateColumns = 0;
            for (int i = 0; i < n; i++) {
                Arrays.sort(transposedMatrix[i]);
                for (int j = 0; j < n - 1; j++) {
                    if (transposedMatrix[i][j] == transposedMatrix[i][j + 1]) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            
            // Printing the result
            System.out.println("Case #" + k + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
        
        sc.close();
    }
}