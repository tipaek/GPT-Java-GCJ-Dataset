import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            
            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            // Calculate trace and check for duplicate rows and columns
            for (int i = 0; i < N; i++) {
                boolean[] rowCheck = new boolean[N];
                boolean[] colCheck = new boolean[N];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                for (int j = 0; j < N; j++) {
                    int rowValue = matrix[i][j];
                    int colValue = matrix[j][i];
                    
                    // Check for duplicates in the row
                    if (!rowCheck[rowValue - 1]) {
                        rowCheck[rowValue - 1] = true;
                    } else {
                        rowHasDuplicate = true;
                    }
                    
                    // Check for duplicates in the column
                    if (!colCheck[colValue - 1]) {
                        colCheck[colValue - 1] = true;
                    } else {
                        colHasDuplicate = true;
                    }
                    
                    // Calculate trace
                    if (i == j) {
                        trace += rowValue;
                    }
                }
                
                if (rowHasDuplicate) {
                    duplicateRows++;
                }
                
                if (colHasDuplicate) {
                    duplicateCols++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}