import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int trace = 0, rowCount = 0, colCount = 0;
            int[][] matrix = new int[n][n];

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                trace += matrix[i][i];
            }

            // Create a set of expected values for rows and columns
            HashSet<Integer> expectedValues = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                expectedValues.add(i);
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>(expectedValues);
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.remove(matrix[i][j])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    rowCount++;
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < n; i++) {
                HashSet<Integer> colSet = new HashSet<>(expectedValues);
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!colSet.remove(matrix[j][i])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    colCount++;
                }
            }

            // Output the result for the current case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
            caseNumber++;
        }
    }
}