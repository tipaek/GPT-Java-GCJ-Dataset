import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Counting rows with duplicates
            int duplicateRows = 0;
            for (int[] row : matrix) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicates = false;
                for (int value : row) {
                    if (!rowSet.add(value)) {
                        hasDuplicates = true;
                        break;
                    }
                }
                if (hasDuplicates) {
                    duplicateRows++;
                }
            }

            // Counting columns with duplicates
            int duplicateCols = 0;
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicates = false;
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        hasDuplicates = true;
                        break;
                    }
                }
                if (hasDuplicates) {
                    duplicateCols++;
                }
            }

            // Printing the result
            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}