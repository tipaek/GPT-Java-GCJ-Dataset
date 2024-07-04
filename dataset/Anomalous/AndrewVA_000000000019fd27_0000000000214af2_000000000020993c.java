import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            // Read matrix and calculate trace and row repeats
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasRepeats = false;
                
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    
                    // Check for duplicates in the row
                    if (!rowSet.add(matrix[row][col])) {
                        rowHasRepeats = true;
                    }
                    
                    // Calculate trace
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
                
                if (rowHasRepeats) {
                    rowRepeats++;
                }
            }
            
            // Calculate column repeats
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasRepeats = false;
                
                for (int row = 0; row < n; row++) {
                    // Check for duplicates in the column
                    if (!colSet.add(matrix[row][col])) {
                        colHasRepeats = true;
                    }
                }
                
                if (colHasRepeats) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}