import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCaseCount = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= testCaseCount; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int trace = 0, rowCount = 0, colCount = 0;
            
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) {
                    rowCount++;
                }
            }
            
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colCount++;
                }
            }
            
            System.out.println("#" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
        
        out.flush();
        out.close();
    }
}