import java.util.*;

public class Solution {

    private void printAnswer(int T, boolean flag, int[][] board) {
        String ans = flag ? "POSSIBLE" : "IMPOSSIBLE";
        System.out.println("Case #" + T + ": " + ans);
        if (flag) {
            for (int[] row : board) {
                for (int j = 0; j < row.length; j++) {
                    System.out.print(row[j]);
                    if (j != row.length - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    private boolean isValid(int[][] board, int x, int y, int val) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }

        for (int[] row : board) {
            if (row[y] == val) {
                return false;
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[x][j] == val) {
                return false;
            }
        }

        return true;
    }

    private boolean isSolved(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean solve(int[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }

        if (isSolved(board)) {
            return true;
        }

        if (board[x][y] != 0) {
            return solve(board, x + (y + 1) / board.length, (y + 1) % board.length);
        }

        for (int i = 1; i <= board.length; i++) {
            if (isValid(board, x, y, i)) {
                board[x][y] = i;

                if (solve(board, x + (y + 1) / board.length, (y + 1) % board.length)) {
                    return true;
                }

                board[x][y] = 0;
            }
        }
        return false;
    }

    private void fillBoard(int trace, int[][] board) {
        int n = board.length;
        int min = 1;
        int max = n;

        for (int i = 0; i < n; i++) {
            board[i][i] = (trace - min - (n - 2) + max) % n + min;
        }
    }

    private boolean findAnswer(int n, int trace, int[][] board) {
        int min = n;
        int max = n * n;

        if (trace == min + 1 || trace == max - 1 || trace < min || trace > max) {
            return false;
        }

        for (int[] row : board) {
            Arrays.fill(row, 0);
        }

        fillBoard(trace, board);
        return solve(board, 0, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        int T = sc.nextInt();
        for (int count = 1; count <= T; count++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] board = new int[N][N];
            boolean ans = solution.findAnswer(N, K, board);
            solution.printAnswer(count, ans, board);
        }
    }
}