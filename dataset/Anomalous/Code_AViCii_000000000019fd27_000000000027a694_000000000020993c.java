import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicates = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        hasDuplicates = true;
                        break;
                    }
                }
                if (hasDuplicates) {
                    rowDuplicates++;
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicates = false;
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        hasDuplicates = true;
                        break;
                    }
                }
                if (hasDuplicates) {
                    colDuplicates++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}