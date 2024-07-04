import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        int[][] result = new int[t][3];
        
        for (int i = 0; i < t; ++i) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;
            
            // Read matrix
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    matrix[j][k] = scan.nextInt();
                }
            }
            
            // Calculate trace
            for (int j = 0; j < n; ++j) {
                trace += matrix[j][j];
            }
            
            // Check for duplicate values in rows
            for (int j = 0; j < n; ++j) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; ++k) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowCount++;
                        break;
                    }
                }
            }
            
            // Check for duplicate values in columns
            for (int j = 0; j < n; ++j) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; ++k) {
                    if (!colSet.add(matrix[k][j])) {
                        colCount++;
                        break;
                    }
                }
            }
            
            // Store results
            result[i][0] = trace;
            result[i][1] = rowCount;
            result[i][2] = colCount;
        }
        
        // Print results
        for (int i = 0; i < t; ++i) {
            System.out.println("Case #" + (i + 1) + ": " + result[i][0] + " " + result[i][1] + " " + result[i][2]);
        }
    }
}