import java.util.Scanner;

public class Solution {
    private static final String POSSIBLE_OUTPUT = "Case #%d: POSSIBLE";
    private static final String IMPOSSIBLE_OUTPUT = "Case #%d: IMPOSSIBLE";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int[] diagonal = new int[n];

        boolean isPossible = fillDiagonal(diagonal, 0, n, k, (diag, size) -> {
            for (int i = 0; i < size; ++i) {
                matrix[i][i] = diag[i];
            }
            return solve(0, 0, matrix, size);
        });

        if (isPossible) {
            System.out.println(String.format(POSSIBLE_OUTPUT, caseNum));
            for (int[] row : matrix) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println(String.format(IMPOSSIBLE_OUTPUT, caseNum));
        }
    }

    private interface DiagonalHandler {
        boolean handleDiagonal(int[] diagonal, int size);
    }

    private boolean fillDiagonal(int[] diagonal, int index, int n, int target, DiagonalHandler handler) {
        if (index == n) {
            return target == 0 && handler.handleDiagonal(diagonal, n);
        }

        for (int i = 1; i <= n; ++i) {
            diagonal[index] = i;
            if (fillDiagonal(diagonal, index + 1, n, target - i, handler)) {
                return true;
            }
        }
        diagonal[index] = 0;
        return false;
    }

    private boolean solve(int row, int col, int[][] matrix, int n) {
        if (row >= n) return true;
        if (col >= n) return solve(row + 1, 0, matrix, n);
        if (matrix[row][col] > 0) return solve(row, col + 1, matrix, n);

        for (int value = 1; value <= n; value++) {
            if (isValid(row, col, matrix, value, n)) {
                matrix[row][col] = value;
                if (solve(row, col + 1, matrix, n)) return true;
                matrix[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, int[][] matrix, int value, int n) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] == value || matrix[row][i] == value) {
                return false;
            }
        }
        return true;
    }
}