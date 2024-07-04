import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int t = Integer.parseInt(br.readLine());
            for (int z = 1; z <= t; z++) {
                int n = Integer.parseInt(br.readLine());
                int[][] matrix = new int[n][n];
                
                for (int i = 0; i < n; i++) {
                    matrix[i] = Arrays.stream(br.readLine().split(" "))
                                      .mapToInt(Integer::parseInt)
                                      .toArray();
                }
                
                int trace = 0;
                int duplicateRows = 0;
                int duplicateCols = 0;
                
                for (int i = 0; i < n; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    Set<Integer> colSet = new HashSet<>();
                    
                    for (int j = 0; j < n; j++) {
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                        rowSet.add(matrix[i][j]);
                        colSet.add(matrix[j][i]);
                    }
                    
                    if (rowSet.size() != n) {
                        duplicateRows++;
                    }
                    if (colSet.size() != n) {
                        duplicateCols++;
                    }
                }
                
                bw.write(String.format("Case #%d: %d %d %d", z, trace, duplicateRows, duplicateCols));
                bw.newLine();
            }
        }
    }
}