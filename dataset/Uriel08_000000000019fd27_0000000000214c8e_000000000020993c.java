import java.io.*;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = 0;
        
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t;) {
            int n = Integer.parseInt(br.readLine()), trace = 0, rowsCount = 0, colsCount = 0;
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {          
               st = new StringTokenizer(br.readLine());  
               for (int k = 0; k < n; k++) {
                  matrix[j][k] = Integer.parseInt(st.nextToken());
               }
            }
            
            for (int j = 0; j < n; j++) {     
               Set rowsSet = new HashSet<Integer>();
               Set colsSet = new HashSet<Integer>();
               boolean rowsFlag = true, colsFlag = true;       
               for (int k = 0; k < n; k++) {
                  if (j == k) {
                     trace += matrix[j][k];
                  }
               
                  if (rowsFlag) {
                     if (rowsSet.contains(matrix[j][k])) {
                        rowsFlag = false;
                        rowsCount++;
                     } else {
                        rowsSet.add(matrix[j][k]);
                     }
                  }
                  
                  if (colsFlag) {
                     if (colsSet.contains(matrix[k][j])) {
                        colsFlag = false;
                        colsCount++;
                     } else {
                        colsSet.add(matrix[k][j]);
                     }
                  }
               }
            }
            bw.write("Case #" + (++i) + ": " + trace + " " + rowsCount + " " + colsCount + "\n");
            bw.flush();
        }
        
        br.close();
        bw.close();
    }
}