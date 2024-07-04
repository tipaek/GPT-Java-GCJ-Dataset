import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int index = 1; index <= cases; index++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, repRows = 0, repCols = 0;

            // Read the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate trace and check for repeated rows and columns
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];

                if (hasDuplicate(matrix[i])) {
                    repRows++;
                }

                if (hasDuplicate(getColumn(matrix, i))) {
                    repCols++;
                }
            }

            System.out.println("Case #" + index + ": " + trace + " " + repRows + " " + repCols);
        }
    }

    // Helper method to check for duplicates in an array
    private static boolean hasDuplicate(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }

    // Helper method to get a column from a matrix
    private static int[] getColumn(int[][] matrix, int col) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][col];
        }
        return column;
    }
}