import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int xor = 0, rowMismatchCount = 0, colMismatchCount = 0, diagonalSum = 0;
            int[][] matrix = new int[n][n];
            
            for (int i = 1; i <= n; i++) {
                xor ^= i;
            }
            
            for (int i = 0; i < n; i++) {
                int rowXor = 0;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowXor ^= matrix[i][j];
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                if (rowXor != xor) {
                    rowMismatchCount++;
                }
            }
            
            for (int j = 0; j < n; j++) {
                int colXor = 0;
                for (int i = 0; i < n; i++) {
                    colXor ^= matrix[i][j];
                }
                if (colXor != xor) {
                    colMismatchCount++;
                }
            }
            
            System.out.println("Case #" + t + ": " + diagonalSum + " " + rowMismatchCount + " " + colMismatchCount);
        }
        
        scanner.close();
    }
}