import java.util.*;

public class Solution {

    public static void vestigium(int testCase, int[][] matrix) {
        int trace = 0, rowCount = 0, colCount = 0;
        int n = matrix.length;
        final int SUM = (n * (n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            int rowSum = 0, colSum = 0;
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }

            if (rowSum != SUM || rowSet.size() != n) {
                rowCount++;
            }
            if (colSum != SUM || colSet.size() != n) {
                colCount++;
            }
        }

        System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + rowCount + " " + colCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            vestigium(tItr, matrix);
        }

        scanner.close();
    }
}