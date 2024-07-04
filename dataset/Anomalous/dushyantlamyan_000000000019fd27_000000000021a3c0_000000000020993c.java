import java.util.*;
import java.io.*;

public class Solution {
    private static int total = 0;
    private static int temp1 = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[][] transpose = new int[n][n];
            int duplicateRows = 0;

            for (int row = 0; row < n; row++) {
                Set<Integer> rowValues = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    rowValues.add(matrix[row][col]);
                    transpose[col][row] = matrix[row][col];
                }
                if (rowValues.size() < n) {
                    duplicateRows++;
                }
            }

            calculateTraceAndDuplicateColumns(matrix, n, transpose);

            System.out.println("Case #" + i + ": " + total + " " + duplicateRows + " " + temp1);
            total = 0; // Reset total for the next test case
            temp1 = 0; // Reset temp1 for the next test case
        }
    }

    private static void calculateTraceAndDuplicateColumns(int[][] matrix, int n, int[][] transpose) {
        for (int i = 0; i < n; i++) {
            Set<Integer> columnValues = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    total += matrix[i][j];
                }
                columnValues.add(matrix[j][i]);
            }
            if (columnValues.size() < n) {
                temp1++;
            }
        }
    }
}