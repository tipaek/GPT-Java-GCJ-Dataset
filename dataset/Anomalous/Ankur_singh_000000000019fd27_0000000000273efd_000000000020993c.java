import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int[][] transposedArr = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            // Transpose the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    transposedArr[i][j] = arr[j][i];
                }
            }
            
            // Calculate the sum of the main diagonal
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += arr[i][i];
            }
            
            // Sort rows of the original matrix
            for (int i = 0; i < n; i++) {
                Arrays.sort(arr[i]);
            }
            
            // Count rows with duplicates in the original matrix
            int duplicateRowCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] == arr[i][j + 1]) {
                        duplicateRowCount++;
                        break;
                    }
                }
            }
            
            // Sort rows of the transposed matrix
            for (int i = 0; i < n; i++) {
                Arrays.sort(transposedArr[i]);
            }
            
            // Count columns with duplicates in the original matrix
            int duplicateColumnCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (transposedArr[i][j] == transposedArr[i][j + 1]) {
                        duplicateColumnCount++;
                        break;
                    }
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", k, diagonalSum, duplicateRowCount, duplicateColumnCount);
        }
        
        sc.close();
    }
}