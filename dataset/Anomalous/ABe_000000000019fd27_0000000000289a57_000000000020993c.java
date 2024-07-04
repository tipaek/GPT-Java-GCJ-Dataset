import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Reading the matrix and calculating the trace
            for (int row = 0; row < n; ++row) {
                for (int col = 0; col < n; ++col) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Checking for duplicate values in rows
            for (int row = 0; row < n; ++row) {
                Set<Integer> seen = new HashSet<>();
                for (int col = 0; col < n; ++col) {
                    if (!seen.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Checking for duplicate values in columns
            for (int col = 0; col < n; ++col) {
                Set<Integer> seen = new HashSet<>();
                for (int row = 0; row < n; ++row) {
                    if (!seen.add(matrix[row][col])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}