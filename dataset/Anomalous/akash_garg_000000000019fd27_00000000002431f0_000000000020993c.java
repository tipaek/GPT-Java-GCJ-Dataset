import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            long diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the sum of the diagonal
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Check for duplicates in rows and columns
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
                if (hasDuplicates(getColumn(matrix, i))) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
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

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}