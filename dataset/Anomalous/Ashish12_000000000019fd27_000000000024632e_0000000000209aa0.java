import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int testcase = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];

            if (solve(0, 0, n, k, matrix, 0)) {
                System.out.println("Case #" + testcase + ": POSSIBLE");
                printMatrix(matrix);
            } else {
                System.out.println("Case #" + testcase + ": IMPOSSIBLE");
            }
            testcase++;
        }
    }

    private static boolean solve(int row, int col, int n, int k, int[][] matrix, int trace) {
        if (row == 0 && col == n) {
            return trace == k;
        }
        if (trace >= k) return false;

        for (int num = 1; num <= n; num++) {
            if (isValid(row, col, matrix, num)) {
                matrix[row][col] = num;
                int nextRow = (row + 1) % n;
                int nextCol = (row + 1) == n ? col + 1 : col;
                if (solve(nextRow, nextCol, n, k, matrix, trace + (row == col ? num : 0))) {
                    return true;
                }
                matrix[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int row, int col, int[][] matrix, int num) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] == num || matrix[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}