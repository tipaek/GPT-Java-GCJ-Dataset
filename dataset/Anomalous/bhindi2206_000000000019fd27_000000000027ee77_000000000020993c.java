import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests = sc.nextInt();
        
        for (int test = 1; test <= numberOfTests; test++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }
            
            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            // Count rows with duplicate elements
            int duplicateRows = 0;
            for (int row = 0; row < n; row++) {
                boolean[] seen = new boolean[n + 1];
                for (int col = 0; col < n; col++) {
                    if (seen[matrix[row][col]]) {
                        duplicateRows++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }
            
            // Count columns with duplicate elements
            int duplicateCols = 0;
            for (int col = 0; col < n; col++) {
                boolean[] seen = new boolean[n + 1];
                for (int row = 0; row < n; row++) {
                    if (seen[matrix[row][col]]) {
                        duplicateCols++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }
            
            // Print the result for the current test case
            System.out.println("Case #" + test + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        sc.close();
    }
}