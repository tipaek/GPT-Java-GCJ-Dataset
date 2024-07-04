import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
             
            int t = Integer.parseInt(br.readLine());
            for (int p = 1; p <= t; p++) {
                int n = Integer.parseInt(br.readLine());
                int[][] matrix = new int[n][n];
                
                for (int i = 0; i < n; i++) {
                    String[] line = br.readLine().split(" ");
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Integer.parseInt(line[j]);
                    }
                }
                
                int trace = 0;
                for (int i = 0; i < n; i++) {
                    trace += matrix[i][i];
                }
                
                int duplicateRows = 0;
                int duplicateCols = 0;
                
                for (int i = 0; i < n; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    Set<Integer> colSet = new HashSet<>();
                    
                    for (int j = 0; j < n; j++) {
                        rowSet.add(matrix[i][j]);
                        colSet.add(matrix[j][i]);
                    }
                    
                    if (rowSet.size() < n) duplicateRows++;
                    if (colSet.size() < n) duplicateCols++;
                }
                
                bw.write(String.format("Case #%d: %d %d %d%n", p, trace, duplicateRows, duplicateCols));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}