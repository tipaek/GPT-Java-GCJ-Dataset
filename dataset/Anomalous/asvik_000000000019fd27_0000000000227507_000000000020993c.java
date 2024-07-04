import java.util.Scanner;

public class Solution {

    public static void vestigium(int testCase, int[][] matrix) {
        int n = matrix.length;
        int trace = 0, rows = 0, cols = 0;
        final int SUM = n * (n + 1) / 2;

        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n + 1];
            boolean[] colCheck = new boolean[n + 1];
            int rowSum = 0, colSum = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowSum += matrix[i][j];
                colSum += matrix[j][i];

                if (rowCheck[matrix[i][j]] || colCheck[matrix[j][i]]) {
                    if (!rowCheck[matrix[i][j]]) {
                        rows++;
                    }
                    if (!colCheck[matrix[j][i]]) {
                        cols++;
                    }
                    break;
                }
                rowCheck[matrix[i][j]] = true;
                colCheck[matrix[j][i]] = true;
            }
        }

        System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + rows + " " + cols);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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