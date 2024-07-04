import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = sc.nextInt();
                }
            }
            
            int expectedSum = (n * (n + 1)) / 2;
            int rowErrors = 0, colErrors = 0;
            
            for (int j = 0; j < n; j++) {
                int rowSum = 0, colSum = 0;
                
                for (int k = 0; k < n; k++) {
                    rowSum += a[j][k];
                    colSum += a[k][j];
                }
                
                if (rowSum != expectedSum) rowErrors++;
                if (colSum != expectedSum) colErrors++;
            }
            
            int diagonalSum = 0;
            for (int j = 0; j < n; j++) {
                diagonalSum += a[j][j];
            }
            
            System.out.println("Case #" + i + ": " + diagonalSum + " " + rowErrors + " " + colErrors);
        }
        
        sc.close();
    }
}