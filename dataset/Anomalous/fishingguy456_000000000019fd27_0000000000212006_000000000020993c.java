import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for repeated elements in rows and columns
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    // Check row
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    // Check column
                    if (!colSet.add(matrix[j][i])) {
                        colHasDuplicate = true;
                    }
                }

                if (rowHasDuplicate) {
                    repeatedRows++;
                }
                if (colHasDuplicate) {
                    repeatedCols++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, repeatedRows, repeatedCols);
        }
    }
}