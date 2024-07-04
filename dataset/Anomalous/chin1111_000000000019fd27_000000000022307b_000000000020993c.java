import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int numberOfTestCases = Integer.parseInt(br.readLine().trim());
        
        for (int i = 1; i <= numberOfTestCases; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                String[] row = br.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(row[k]);
                }
            }
            
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }
            
            for (int j = 0; j < n; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> columnSet = new HashSet<>();
                
                for (int k = 0; k < n; k++) {
                    rowSet.add(matrix[j][k]);
                    columnSet.add(matrix[k][j]);
                }
                
                if (rowSet.size() != n) {
                    duplicateRows++;
                }
                
                if (columnSet.size() != n) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}