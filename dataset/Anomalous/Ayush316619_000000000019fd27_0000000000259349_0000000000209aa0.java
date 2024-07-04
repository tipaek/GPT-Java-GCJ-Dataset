import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(reader.readLine().trim());

            for (int tc = 1; tc <= t; tc++) {
                String[] input = reader.readLine().trim().split(" ");
                int n = Integer.parseInt(input[0]);
                int k = Integer.parseInt(input[1]);

                processCase(n, k, tc);
            }
        }
    }

    private static void processCase(int n, int k, int tc) {
        Result result = findSolution(n, k);
        if (result.isPossible) {
            System.out.println("Case #" + tc + ": POSSIBLE");
            printMatrix(result.matrix);
        } else {
            System.out.println("Case #" + tc + ": IMPOSSIBLE");
        }
    }

    private static Result findSolution(int n, int k) {
        for (int i = 1; i <= n; i++) {
            int[][] matrix = new int[n][n];
            matrix[0][0] = i;
            if (fillMatrix(matrix, n)) {
                int diagonalSum = calculateDiagonalSum(matrix, n);
                if (diagonalSum == k) {
                    return new Result(true, matrix);
                }
            }
        }
        return new Result(false, new int[n][n]);
    }

    private static boolean fillMatrix(int[][] matrix, int n) {
        int[] emptyCell = findEmptyCell(matrix, n);
        if (emptyCell == null) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

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

    private static int[] findEmptyCell(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean isSafe(int[][] matrix, int num, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] == num || matrix[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder output = new StringBuilder();
        for (int[] row : matrix) {
            for (int num : row) {
                output.append(num).append(" ");
            }
            output.setLength(output.length() - 1); // Remove trailing space
            output.append("\n");
        }
        System.out.print(output);
    }

    private static class Result {
        final boolean isPossible;
        final int[][] matrix;

        Result(boolean isPossible, int[][] matrix) {
            this.isPossible = isPossible;
            this.matrix = matrix;
        }
    }
}