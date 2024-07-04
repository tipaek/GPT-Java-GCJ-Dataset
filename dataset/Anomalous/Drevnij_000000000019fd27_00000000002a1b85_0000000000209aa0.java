import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int targetSum = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Initialize the matrix with (i + j) % n + 1
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = (i + j) % n + 1;
                }
            }
            
            boolean possible = false;
            
            // Try to find a permutation of rows that gives the desired diagonal sum
            outerLoop:
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    swapRows(matrix, i, j);
                    int diagonalSum = calculateDiagonalSum(matrix);
                    if (diagonalSum == targetSum) {
                        possible = true;
                        break outerLoop;
                    }
                    swapRows(matrix, i, j); // Swap back if not matching
                }
            }
            
            if (possible) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                printMatrix(matrix);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
    
    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }
    
    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}