import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            long trace = 0;
            int rowCount = 0, colCount = 0;
            int[] rowFlags = new int[n];
            int[] colFlags = new int[n];
            Map<Integer, Integer>[] rowMaps = new HashMap[n];
            Map<Integer, Integer>[] colMaps = new HashMap[n];
            
            for (int j = 0; j < n; j++) {
                rowMaps[j] = new HashMap<>();
                for (int k = 0; k < n; k++) {
                    if (j == 0) {
                        colMaps[k] = new HashMap<>();
                    }
                    matrix[j][k] = sc.nextInt();
                    
                    // Calculate trace
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                    
                    // Check for duplicate in row
                    if (rowMaps[j].containsKey(matrix[j][k])) {
                        if (rowFlags[j] == 0) {
                            rowFlags[j] = 1;
                            rowCount++;
                        }
                    } else {
                        rowMaps[j].put(matrix[j][k], 1);
                    }
                    
                    // Check for duplicate in column
                    if (colMaps[k].containsKey(matrix[j][k])) {
                        if (colFlags[k] == 0) {
                            colFlags[k] = 1;
                            colCount++;
                        }
                    } else {
                        colMaps[k].put(matrix[j][k], 1);
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}