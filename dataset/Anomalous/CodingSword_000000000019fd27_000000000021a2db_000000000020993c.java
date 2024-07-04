import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            int duplicateRows = 0, duplicateCols = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix, i, 0, 0, 1)) {
                    duplicateCols++;
                }
            }
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(matrix, 0, j, 1, 0)) {
                    duplicateRows++;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", t, diagonalSum, duplicateCols, duplicateRows);
        }
    }

    private static boolean hasDuplicates(int[][] matrix, int startX, int startY, int dx, int dy) {
        int n = matrix.length;
        boolean[] seen = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int value = matrix[startX + i * dx][startY + i * dy];
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }

        return false;
    }
}