import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (isImpossible(n, k)) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                int[][] matrix = initializeMatrix(n);
                adjustMatrix(matrix, n, k);
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                solveSudoku(matrix, n);
                printMatrix(matrix, n);
            }
        }
    }

    private static boolean isImpossible(int n, int k) {
        int x = n + 1;
        int y = n * n - 1;
        return k == x || k == y || (n == 3 && (k == 5 || k == 7));
    }

    private static int[][] initializeMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }

    private static void adjustMatrix(int[][] matrix, int n, int k) {
        int pointer = 0;
        while (k - n > 0) {
            matrix[pointer][pointer]++;
            k--;
            pointer = (pointer + 1) % n;
        }

        if (matrix[n - 1][n - 1] == matrix[n - 2][n - 2] - 1) {
            matrix[n - 2][n - 2]++;
            matrix[n - 3][n - 3]--;
        } else if (matrix[0][0] == matrix[1][1] + 1) {
            matrix[0][0]++;
            matrix[1][1]--;
            if (matrix[0][0] > n) {
                matrix[0][0]--;
                matrix[2][2]++;
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num || board[d][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        outerLoop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break outerLoop;
                }
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static void printMatrix(int[][] board, int n) {
        for (int r = 0; r < n; r++) {
            for (int d = 0; d < n; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.println();
        }
    }
}