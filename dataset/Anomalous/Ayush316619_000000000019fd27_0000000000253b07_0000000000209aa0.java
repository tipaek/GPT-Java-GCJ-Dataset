import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        for (int tc = 1; tc <= t; tc++) {
            String[] input = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            processTestCase(n, k, tc);
        }
    }

    private static void processTestCase(int n, int k, int tc) {
        int[][] matrix = new int[n][n];

        if (!fillMatrix(matrix, n)) {
            System.out.println("Case #" + tc + ": IMPOSSIBLE");
        } else {
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }
            if (diagonalSum == k) {
                System.out.println("Case #" + tc + ": POSSIBLE");
                printMatrix(matrix, n);
            } else {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean fillMatrix(int[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    for (int num = 1; num <= n; num++) {
                        if (isSafe(matrix, num, row, col, n)) {
                            matrix[row][col] = num;
                            if (fillMatrix(matrix, n)) {
                                return true;
                            }
                            matrix[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int[][] matrix, int num, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (matrix[row][i] == num || matrix[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.setLength(sb.length() - 1); // Remove trailing space
            sb.append("\n");
        }
        System.out.print(sb.toString().trim());
    }
}