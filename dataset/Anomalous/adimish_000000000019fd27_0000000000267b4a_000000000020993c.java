import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Reading the matrix and calculating the trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            // Checking for duplicate values in rows
            for (int row = 0; row < n; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            // Checking for duplicate values in columns
            for (int col = 0; col < n; col++) {
                int[] column = new int[n];
                for (int row = 0; row < n; row++) {
                    column[row] = matrix[row][col];
                }
                if (hasDuplicates(column)) {
                    duplicateCols++;
                }
            }

            System.out.println(trace + " " + duplicateRows + " " + duplicateCols);
        }
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