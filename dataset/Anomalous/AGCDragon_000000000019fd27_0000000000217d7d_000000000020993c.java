import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Checking for duplicate entries in rows
            int rowsWithDuplicates = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) {
                    rowsWithDuplicates++;
                }
            }

            // Checking for duplicate entries in columns
            int columnsWithDuplicates = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != n) {
                    columnsWithDuplicates++;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowsWithDuplicates + " " + columnsWithDuplicates);
        }
    }
}