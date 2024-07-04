package codejam1;

import java.util.Scanner;

public class Codejam1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < n; j++) {
                if (hasDuplicates(getColumn(matrix, j))) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + x + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
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

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}