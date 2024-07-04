import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] results = new int[t][4];

        for (int i = 0; i < t; i++) {
            results[i][0] = i + 1;
            int n = scanner.nextInt();
            int trace = 0;
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            results[i][1] = trace;
            results[i][2] = countDuplicateRows(matrix, n);
            results[i][3] = countDuplicateCols(matrix, n);
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + results[i][0] + ": " + results[i][1] + " " + results[i][2] + " " + results[i][3]);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int row = 0; row < n; row++) {
            boolean[] seen = new boolean[n + 1];
            for (int col = 0; col < n; col++) {
                if (seen[matrix[row][col]]) {
                    duplicateRows++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int n) {
        int duplicateCols = 0;
        for (int col = 0; col < n; col++) {
            boolean[] seen = new boolean[n + 1];
            for (int row = 0; row < n; row++) {
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