import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    private void printAnswer(int caseNumber, boolean isPossible, int[][] board) {
        String result = isPossible ? "POSSIBLE" : "IMPOSSIBLE";
        System.out.println("Case #" + caseNumber + ": " + result);
        if (isPossible) {
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

    private boolean isValid(int[][] board, int x, int y, int value) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }

        for (int[] row : board) {
            if (row[y] == value) {
                return false;
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[x][j] == value) {
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
        if (n == 2) {
            board[0][0] = trace;
            board[1][1] = 2;
            return;
        }

        board[0][0] = trace - (n - 2) - 2;
        board[1][1] = 2;

        for (int i = 2; i < n; i++) {
            board[i][i] = 1;
        }
    }

    private boolean findAnswer(int n, int trace, int[][] board) {
        for (int[] row : board) {
            Arrays.fill(row, 0);
        }

        fillBoard(trace, board);
        return solve(board, 0, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int trace = scanner.nextInt();
            int[][] board = new int[n][n];
            boolean isPossible = solution.findAnswer(n, trace, board);
            solution.printAnswer(caseNumber, isPossible, board);
        }
    }
}