import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            
            // Read matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = sc.nextInt();
                }
            }
            
            int p = (n * (n + 1)) / 2;
            BigInteger factorial = calculateFactorial(n);
            
            int r = 0, c = 0;
            
            for (int k = 0; k < n; k++) {
                int rowSum = 0, colSum = 0;
                BigInteger rowFactorial = BigInteger.ONE;
                BigInteger colFactorial = BigInteger.ONE;
                
                // Calculate row sum and row factorial
                for (int j = 0; j < n; j++) {
                    rowSum += a[k][j];
                    rowFactorial = rowFactorial.multiply(BigInteger.valueOf(a[k][j]));
                }
                
                // Calculate column sum and column factorial
                for (int j = 0; j < n; j++) {
                    colSum += a[j][k];
                    colFactorial = colFactorial.multiply(BigInteger.valueOf(a[j][k]));
                }
                
                if (rowSum == p && rowFactorial.equals(factorial)) {
                    r++;
                }
                
                if (colSum == p && colFactorial.equals(factorial)) {
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
    
    private static BigInteger calculateFactorial(int n) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = n; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}