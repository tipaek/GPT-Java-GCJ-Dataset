import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            
            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            int rowRepeats = 0;
            int columnRepeats = 0;
            
            // Check for row duplicates
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j] - 1]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
            }
            
            // Check for column duplicates
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i] - 1]) {
                        columnRepeats++;
                        break;
                    }
                    seen[matrix[j][i] - 1] = true;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
        
        scanner.close();
    }
}