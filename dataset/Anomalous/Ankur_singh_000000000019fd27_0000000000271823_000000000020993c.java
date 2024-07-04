import java.util.Scanner;
import java.util.Arrays;

class Main {
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
            
            // Calculate the sum of the diagonal elements
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += arr[i][i];
            }
            
            // Sort each row of the original matrix
            for (int i = 0; i < n; i++) {
                Arrays.sort(arr[i]);
            }
            
            // Count rows with duplicate elements in the original matrix
            int duplicateRowCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] == arr[i][j + 1]) {
                        duplicateRowCount++;
                        break;
                    }
                }
            }
            
            // Sort each row of the transposed matrix
            for (int i = 0; i < n; i++) {
                Arrays.sort(transposedArr[i]);
            }
            
            // Count columns with duplicate elements in the original matrix
            int duplicateColCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (transposedArr[i][j] == transposedArr[i][j + 1]) {
                        duplicateColCount++;
                        break;
                    }
                }
            }
            
            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", k, diagonalSum, duplicateRowCount, duplicateColCount);
        }
        
        sc.close();
    }
}