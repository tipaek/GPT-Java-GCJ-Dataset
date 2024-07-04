import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;
            
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j) trace += matrix[i][j];
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < n) rowCount++;
            }
            
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < n) colCount++;
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}