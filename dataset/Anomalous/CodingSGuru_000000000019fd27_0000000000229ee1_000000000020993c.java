package codejam;

import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCases];

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowRepeats = countRepeatedRows(matrix, n);
            int colRepeats = countRepeatedColumns(matrix, n);

            results[t - 1] = String.format("Case #%d: %d %d %d", t, trace, rowRepeats, colRepeats);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int repeatCount = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                repeatCount++;
            }
        }
        return repeatCount;
    }

    private static int countRepeatedColumns(int[][] matrix, int size) {
        int repeatCount = 0;
        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                repeatCount++;
            }
        }
        return repeatCount;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (value > 0 && value <= array.length) {
                if (seen[value]) {
                    return true;
                }
                seen[value] = true;
            }
        }
        return false;
    }
}