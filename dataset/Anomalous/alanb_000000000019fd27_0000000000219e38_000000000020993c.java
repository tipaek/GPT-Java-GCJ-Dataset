import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0;
            int rowsWithDuplicates = 0;
            int colsWithDuplicates = 0;
            int[][] matrix = new int[n][n];

            // Read matrix and calculate trace
            for (int row = 0; row < n; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() < n) {
                    rowsWithDuplicates++;
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < n; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() < n) {
                    colsWithDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);
        }

        scanner.close();
    }
}