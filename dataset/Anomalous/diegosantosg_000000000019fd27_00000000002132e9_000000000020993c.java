import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            // Calculate trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            // Count rows with duplicate values
            int rowCount = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        rowCount++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
            
            // Count columns with duplicate values
            int colCount = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        colCount++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
            
            // Print result for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
        }
        
        sc.close();
    }
}