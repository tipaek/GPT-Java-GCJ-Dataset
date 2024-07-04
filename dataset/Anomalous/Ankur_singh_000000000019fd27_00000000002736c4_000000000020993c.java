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
            
            // Sort rows of the original matrix and check for duplicates
            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                Arrays.sort(arr[i]);
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] == arr[i][j + 1]) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            // Sort rows of the transposed matrix and check for duplicates
            int colDuplicates = 0;
            for (int i = 0; i < n; i++) {
                Arrays.sort(transposedArr[i]);
                for (int j = 0; j < n - 1; j++) {
                    if (transposedArr[i][j] == transposedArr[i][j + 1]) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            // Print the result for the current test case
            System.out.println("Case #" + k + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
        
        sc.close();
    }
}