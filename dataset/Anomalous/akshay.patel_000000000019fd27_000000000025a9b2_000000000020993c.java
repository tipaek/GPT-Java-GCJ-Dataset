import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(System.out)) {
            
            int t = Integer.parseInt(br.readLine());
            
            for (int p = 1; p <= t; p++) {
                int n = Integer.parseInt(br.readLine());
                int[][] matrix = new int[n][n];
                int trace = 0, duplicateRows = 0, duplicateCols = 0;
                
                for (int i = 0; i < n; i++) {
                    String[] input = br.readLine().split(" ");
                    boolean[] rowCheck = new boolean[n];
                    boolean hasDuplicateInRow = false;
                    
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Integer.parseInt(input[j]) - 1;
                        if (!hasDuplicateInRow && rowCheck[matrix[i][j]]) {
                            hasDuplicateInRow = true;
                            duplicateRows++;
                        }
                        rowCheck[matrix[i][j]] = true;
                    }
                    trace += matrix[i][i];
                }
                
                trace += n; // Adjust trace to correct value
                
                for (int i = 0; i < n; i++) {
                    boolean[] colCheck = new boolean[n];
                    boolean hasDuplicateInCol = false;
                    
                    for (int j = 0; j < n; j++) {
                        if (!hasDuplicateInCol && colCheck[matrix[j][i]]) {
                            hasDuplicateInCol = true;
                            duplicateCols++;
                        }
                        colCheck[matrix[j][i]] = true;
                    }
                }
                
                pw.println("Case #" + p + ": " + trace + " " + duplicateRows + " " + duplicateCols);
            }
        }
    }
}