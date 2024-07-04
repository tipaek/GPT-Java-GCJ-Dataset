import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            boolean possible = true;

            if (k == n + 1 || k == n * n - 1 || (n == 3 && (k == 5 || k == 7))) {
                possible = false;
            }

            if (possible) {
                int[][] grid = new int[n][n];
                int pointer = 0;

                while (k > 0) {
                    grid[pointer][pointer]++;
                    k--;
                    pointer++;
                    if (pointer == n) {
                        pointer = 0;
                    }
                }

                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                solveSudoku(grid, n);
                printGrid(grid, n);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
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
        int row = -1, col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < n && isEmpty; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
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

    private static void printGrid(int[][] board, int n) {
        for (int r = 0; r < n; r++) {
            for (int d = 0; d < n; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.println();
        }
    }
}