import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
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
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }
            
            // Calculate the number of rows with repeated elements
            int repeatedRows = 0;
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        repeatedRows++;
                        break;
                    }
                }
            }
            
            // Calculate the number of columns with repeated elements
            int repeatedCols = 0;
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        repeatedCols++;
                        break;
                    }
                }
            }
            
            // Print the result for the current test case
            System.out.println("Case #" + i + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
        
        sc.close();
    }
}