import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();

        for (int i = 1; i <= times; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    matrix[x][y] = sc.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            // Calculate the number of rows with duplicate elements
            int rowDuplicates = 0;
            for (int[] row : matrix) {
                if (hasDuplicates(row)) {
                    rowDuplicates++;
                }
            }

            // Calculate the number of columns with duplicate elements
            int colDuplicates = 0;
            for (int col = 0; col < n; col++) {
                if (hasColumnDuplicates(matrix, col)) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        sc.close();
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

    private static boolean hasColumnDuplicates(int[][] matrix, int col) {
        boolean[] seen = new boolean[matrix.length + 1];
        for (int row = 0; row < matrix.length; row++) {
            int value = matrix[row][col];
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}