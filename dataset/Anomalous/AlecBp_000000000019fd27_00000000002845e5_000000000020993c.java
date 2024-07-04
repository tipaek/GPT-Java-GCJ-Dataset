package vestigium;

import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for repeated rows
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean hasRepeatedRow = false;
                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        hasRepeatedRow = true;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
                if (hasRepeatedRow) {
                    repeatedRows++;
                }
            }

            // Check for repeated columns
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean hasRepeatedCol = false;
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        hasRepeatedCol = true;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
                if (hasRepeatedCol) {
                    repeatedCols++;
                }
            }

            System.out.println(trace + " " + repeatedRows + " " + repeatedCols);
        }

        scanner.close();
    }
}