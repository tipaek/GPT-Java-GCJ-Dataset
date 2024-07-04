import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        
        int testCases = Integer.parseInt(str.nextToken());
        int caseNumber = 1;
        
        while (testCases > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                str = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            
            int trace = 0;
            int rowRepeated = 0;
            int colRepeated = 0;
            
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeated++;
                        break;
                    }
                }
                
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colRepeated++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeated + " " + colRepeated);
            caseNumber++;
            testCases--;
        }
    }
}