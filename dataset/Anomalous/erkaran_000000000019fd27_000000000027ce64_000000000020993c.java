import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();

        for (int i = 1; i <= testCaseCount; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read matrix and calculate trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            // Check for duplicate values in rows
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", i, trace, duplicateRows, duplicateCols);
        }

        sc.close();
    }
}