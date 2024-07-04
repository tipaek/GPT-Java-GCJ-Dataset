import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int t = 1; t <= testCaseCount; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            // Process each row and column
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];
                boolean rowDuplicate = false;
                boolean colDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    // Calculate trace
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    
                    // Check for duplicates in row
                    if (rowCheck[matrix[i][j]]) {
                        rowDuplicate = true;
                    }
                    rowCheck[matrix[i][j]] = true;
                    
                    // Check for duplicates in column
                    if (colCheck[matrix[j][i]]) {
                        colDuplicate = true;
                    }
                    colCheck[matrix[j][i]] = true;
                }
                
                if (rowDuplicate) {
                    rowRepeats++;
                }
                if (colDuplicate) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}