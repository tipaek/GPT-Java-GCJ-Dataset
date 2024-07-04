import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            boolean found = false;
            int multiple = n;
            
            for (multiple = n; multiple <= n * n; multiple += n) {
                if (multiple == k) {
                    found = true;
                    multiple /= n;
                    break;
                }
            }
            
            if (found) {
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                generateMatrix(n, k, multiple);
            } else {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
    }
    
    private static void generateMatrix(int n, int k, int p) {
        int[][] matrix = new int[n][n];
        
        matrix[0][0] = p;
        
        for (int j = 1; j < n; j++) {
            matrix[0][j] = matrix[0][j - 1] - 1;
            if (matrix[0][j] == 0) {
                matrix[0][j] = n;
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + 1;
                if (matrix[i][j] == n + 1) {
                    matrix[i][j] = 1;
                }
            }
        }
        
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}