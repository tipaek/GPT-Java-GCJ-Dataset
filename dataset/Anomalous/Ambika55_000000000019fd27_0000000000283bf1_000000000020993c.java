import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read matrix and calculate trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateCols(matrix, n);

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;

        for (int row = 0; row < size; row++) {
            boolean[] seen = new boolean[size + 1];
            for (int col = 0; col < size; col++) {
                if (seen[matrix[row][col]]) {
                    duplicateRows++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCols = 0;

        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size + 1];
            for (int row = 0; row < size; row++) {
                if (seen[matrix[row][col]]) {
                    duplicateCols++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }

        return duplicateCols;
    }
}