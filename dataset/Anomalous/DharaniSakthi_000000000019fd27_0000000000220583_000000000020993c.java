import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            // Read the matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            
            // Calculate the trace
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }
            
            // Check for row duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            // Check for column duplicates
            for (int k = 0; k < n; k++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][k])) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            // Print the result for the current test case
            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}