import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            
            // Reading the matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = sc.nextInt();
                }
            }
            
            int p = (n * (n + 1)) / 2;
            long p1 = 1;
            
            // Calculating factorial of n
            for (int m = 1; m <= n; m++) {
                p1 *= m;
            }
            
            int r = 0, c = 0;
            
            // Check rows and columns
            for (int k = 0; k < n; k++) {
                int rowSum = 0, colSum = 0;
                long rowProduct = 1, colProduct = 1;
                
                for (int j = 0; j < n; j++) {
                    rowSum += a[k][j];
                    rowProduct *= a[k][j];
                    colSum += a[j][k];
                    colProduct *= a[j][k];
                }
                
                if (rowSum == p && rowProduct == p1) {
                    r++;
                }
                
                if (colSum == p && colProduct == p1) {
                    c++;
                }
            }
            
            int diagonalSum = 0;
            for (int j = 0; j < n; j++) {
                diagonalSum += a[j][j];
            }
            
            System.out.println("Case #" + i + ": " + diagonalSum + " " + (n - r) + " " + (n - c));
        }
        
        sc.close();
    }
}