import java.util.*;

class Solution {
    public static void analyzeMatrix(int[][] matrix, int caseNumber) {
        int n = matrix.length;
        int trace = 0;
        
        // Calculate the trace of the matrix
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        
        int duplicateRows = 0;
        // Check for duplicate values in rows
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() < n) {
                duplicateRows++;
            }
        }
        
        int duplicateCols = 0;
        // Check for duplicate values in columns
        for (int col = 0; col < n; col++) {
            Set<Integer> colSet = new HashSet<>();
            for (int row = 0; row < n; row++) {
                colSet.add(matrix[row][col]);
            }
            if (colSet.size() < n) {
                duplicateCols++;
            }
        }
        
        System.out.println("Case #" + (caseNumber + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            
            analyzeMatrix(matrix, i);
        }
        
        scanner.close();
    }
}