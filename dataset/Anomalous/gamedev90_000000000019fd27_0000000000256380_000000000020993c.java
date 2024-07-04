import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[][] matrix = new String[n][n];
            int trace = 0;
            
            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().split(" ");
                matrix[i] = row;
                trace += Integer.parseInt(matrix[i][i]);
            }
            
            List<Integer> duplicateCounts = getDuplicateCounts(matrix);
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateCounts.get(0) + " " + duplicateCounts.get(1));
            caseNumber++;
        }
    }

    private static List<Integer> getDuplicateCounts(String[][] matrix) {
        int n = matrix.length;
        int duplicateRows = 0, duplicateCols = 0;

        for (int i = 0; i < n; i++) {
            Set<String> rowSet = new HashSet<>();
            Set<String> colSet = new HashSet<>();
            boolean rowDuplicate = false, colDuplicate = false;

            for (int j = 0; j < n; j++) {
                if (!rowDuplicate && !rowSet.add(matrix[i][j])) {
                    duplicateRows++;
                    rowDuplicate = true;
                }
                if (!colDuplicate && !colSet.add(matrix[j][i])) {
                    duplicateCols++;
                    colDuplicate = true;
                }
            }
        }
        
        return Arrays.asList(duplicateRows, duplicateCols);
    }
}