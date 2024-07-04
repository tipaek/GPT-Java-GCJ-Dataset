import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt(); // Dimension of the matrix
            int[][] matrix = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check rows and columns for duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() < n) rowCount++;
                if (colSet.size() < n) colCount++;
            }

            // Output the result for the current test case
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}