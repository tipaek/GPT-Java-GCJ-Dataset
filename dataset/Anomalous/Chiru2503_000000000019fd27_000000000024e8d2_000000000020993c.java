import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCases = Integer.parseInt(br.readLine());
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            
            // Reading the matrix
            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }
            
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            // Checking for repeated elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }
            
            // Checking for repeated elements in columns
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colRepeats++;
                        break;
                    }
                }
            }
            
            bw.write("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats + "\n");
            caseNumber++;
        }
        
        bw.flush();
    }
}