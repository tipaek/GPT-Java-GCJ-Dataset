import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int K = input.nextInt();
            int[][] board = new int[N][N];

            if (solve(board, K)) {
                System.out.println("Case #" + ks + ": POSSIBLE");
                printBoard(board);
            } else {
                System.out.println("Case #" + ks + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean solve(int[][] board, int K) {
        int N = board.length;
        int row = -1, col = -1;
        boolean allFull = true;
        int total = 0;

        outerLoop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) total += board[i][j];
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    allFull = false;
                    break outerLoop;
                }
            }
        }

        if (allFull) {
            return total == K;
        }

        for (int num = 1; num <= N; num++) {
            if (isSafe(board, row, col, num, K)) {
                board[row][col] = num;
                if (solve(board, K)) return true;
                board[row][col] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num, int K) {
        int N = board.length;

        for (int d = 0; d < N; d++) {
            if (board[row][d] == num || board[d][col] == num) {
                return false;
            }
        }

        int total = 0;
        for (int i = 0; i < N; i++) {
            total += board[i][i];
            if (total > K) return false;
        }

        return true;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}