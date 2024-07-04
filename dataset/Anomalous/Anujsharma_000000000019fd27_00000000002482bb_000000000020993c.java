import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            
            int expectedSum = (n * (n + 1)) / 2;
            long expectedProduct = 1;
            for (int m = 1; m <= n; m++) {
                expectedProduct *= m;
            }
            
            int validRows = 0, validCols = 0;
            
            for (int k = 0; k < n; k++) {
                int rowSum = 0, colSum = 0;
                long rowProduct = 1, colProduct = 1;
                
                for (int j = 0; j < n; j++) {
                    rowSum += matrix[k][j];
                    rowProduct *= matrix[k][j];
                    
                    colSum += matrix[j][k];
                    colProduct *= matrix[j][k];
                }
                
                if (rowSum == expectedSum && rowProduct == expectedProduct) {
                    validRows++;
                }
                
                if (colSum == expectedSum && colProduct == expectedProduct) {
                    validCols++;
                }
            }
            
            int diagonalSum = 0;
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
            }
            
            System.out.println("Case #" + i + ": " + diagonalSum + " " + (n - validRows) + " " + (n - validCols));
        }
        
        sc.close();
    }
}