import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int testCase = 0; testCase < t; testCase++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            
            // Read the matrix and calculate the trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }
            
            int rowRepeats = 0;
            int colRepeats = 0;
            
            // Check for duplicate values in rows
            for (int row = 0; row < n; row++) {
                boolean[] seen = new boolean[n + 1];
                for (int col = 0; col < n; col++) {
                    if (seen[matrix[row][col]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }
            
            // Check for duplicate values in columns
            for (int col = 0; col < n; col++) {
                boolean[] seen = new boolean[n + 1];
                for (int row = 0; row < n; row++) {
                    if (seen[matrix[row][col]]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }
            
            System.out.println(trace + " " + rowRepeats + " " + colRepeats);
        }
        
        sc.close();
    }
}