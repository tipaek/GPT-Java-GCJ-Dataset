package code_jam;

import java.util.Scanner;

class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            calculateAndPrintResult(testCase, n, matrix);
        }
    }

    public static void calculateAndPrintResult(int testCase, int n, int[][] matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        // Calculate trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Calculate duplicate rows
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    duplicateRows++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        // Calculate duplicate columns
        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                if (seen[matrix[i][j]]) {
                    duplicateCols++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }
}