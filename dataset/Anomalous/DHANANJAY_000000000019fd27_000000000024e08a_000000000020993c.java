import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int k = 1; k <= t; k++) {
            int sum = 0, duplicateRows = 0, duplicateCols = 0;
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            // Calculate diagonal sum
            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }
            
            // Check for duplicate rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < n) {
                    duplicateRows++;
                }
            }
            
            // Check for duplicate columns
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    colSet.add(matrix[j][i]);
                }
                if (colSet.size() < n) {
                    duplicateCols++;
                }
            }
            
            System.out.println("Case #" + k + ": " + sum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}