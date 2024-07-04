import java.util.HashSet;
import java.util.Scanner;

/**
 * Vestigium class to solve the matrix trace, rows, and columns duplication problem.
 */
public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            // Check for row duplicates
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            // Check for column duplicates
            for (int i = 0; i < n; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            // Print the result for the current test case
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}