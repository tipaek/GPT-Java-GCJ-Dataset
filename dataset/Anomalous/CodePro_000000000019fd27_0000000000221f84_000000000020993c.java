package jam;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfCases = in.nextInt();
        String[] results = new String[numOfCases];

        for (int i = 0; i < numOfCases; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateCols(matrix, n);

            results[i] = "Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols;
        }

        for (String result : results) {
            System.out.println(result);
        }

        in.close();
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int row = 0; row < n; row++) {
            if (hasDuplicates(matrix[row])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int n) {
        int duplicateCols = 0;
        for (int col = 0; col < n; col++) {
            int[] columnArray = new int[n];
            for (int row = 0; row < n; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (hasDuplicates(columnArray)) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}