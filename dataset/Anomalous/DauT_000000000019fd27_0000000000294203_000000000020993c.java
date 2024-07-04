import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            String result = calculateResult(matrix, n, t);
            System.out.println(result);
        }
    }

    static String calculateResult(int[][] matrix, int n, int caseNumber) {
        int trace = 0;
        int rowCount = 0;
        int columnCount = 0;
        
        // Calculate trace and row violations
        for (int i = 0; i < n; i++) {
            boolean[] seenInRow = new boolean[n + 1];
            boolean rowHasDuplicate = false;
            
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                
                if (seenInRow[matrix[i][j]]) {
                    rowHasDuplicate = true;
                } else {
                    seenInRow[matrix[i][j]] = true;
                }
            }
            
            if (rowHasDuplicate) {
                rowCount++;
            }
        }
        
        // Calculate column violations
        for (int j = 0; j < n; j++) {
            boolean[] seenInColumn = new boolean[n + 1];
            boolean columnHasDuplicate = false;
            
            for (int i = 0; i < n; i++) {
                if (seenInColumn[matrix[i][j]]) {
                    columnHasDuplicate = true;
                } else {
                    seenInColumn[matrix[i][j]] = true;
                }
            }
            
            if (columnHasDuplicate) {
                columnCount++;
            }
        }
        
        return "Case #" + caseNumber + ": " + trace + " " + rowCount + " " + columnCount;
    }
}