import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix elements
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }
            
            int expectedSum = n * (n + 1) / 2;
            int rowIssues = 0, colIssues = 0;
            int diagonalSum = 0;
            
            for (int index = 0; index < n; index++) {
                int rowSum = 0;
                int colSum = 0;
                
                for (int j = 0; j < n; j++) {
                    rowSum += matrix[index][j];
                    colSum += matrix[j][index];
                }
                
                if (rowSum != expectedSum) {
                    rowIssues++;
                }
                
                if (colSum != expectedSum) {
                    colIssues++;
                }
                
                diagonalSum += matrix[index][index];
            }
            
            System.out.println("Case #" + i + ": " + diagonalSum + " " + rowIssues + " " + colIssues);
        }
    }
}