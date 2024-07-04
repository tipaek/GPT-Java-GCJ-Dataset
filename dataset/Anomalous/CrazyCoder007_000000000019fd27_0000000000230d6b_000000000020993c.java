package code_jam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int count = 1; count <= t; count++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace, duplicate rows, and duplicate columns
            Result result = calculate(n, matrix);

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", count, result.trace, result.dupRows, result.dupCols);
        }
    }

    private static Result calculate(int n, int[][] matrix) {
        int trace = 0;
        int dupRows = 0;
        int dupCols = 0;

        // Calculate the trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate rows
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    dupRows++;
                    break;
                }
            }
        }

        // Check for duplicate columns
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(matrix[i][j])) {
                    dupCols++;
                    break;
                }
            }
        }

        return new Result(trace, dupRows, dupCols);
    }

    private static class Result {
        int trace;
        int dupRows;
        int dupCols;

        Result(int trace, int dupRows, int dupCols) {
            this.trace = trace;
            this.dupRows = dupRows;
            this.dupCols = dupCols;
        }
    }
}