import java.util.Scanner;

public class Solution {

    public static void calculateVestigium(int testCase, int[][] matrix) {
        int trace = 0, rowViolations = 0, colViolations = 0;
        int n = matrix.length;
        final int expectedSum = (n * (n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            int[] rowCheck = new int[n + 1];
            int[] colCheck = new int[n + 1];
            int rowSum = 0, colSum = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                rowSum += matrix[i][j];
                colSum += matrix[j][i];

                rowCheck[matrix[i][j]]++;
                colCheck[matrix[j][i]]++;
            }

            if (rowSum != expectedSum || hasDuplicate(rowCheck)) {
                rowViolations++;
            }
            if (colSum != expectedSum || hasDuplicate(colCheck)) {
                colViolations++;
            }
        }

        System.out.println("Case #" + testCase + ": " + trace + " " + rowViolations + " " + colViolations);
    }

    private static boolean hasDuplicate(int[] checkArray) {
        for (int i = 1; i < checkArray.length; i++) {
            if (checkArray[i] > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int tIndex = 1; tIndex <= t; tIndex++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            calculateVestigium(tIndex, matrix);
        }

        scanner.close();
    }
}