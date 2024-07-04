import java.util.Arrays;
import java.util.Scanner;

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

        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == value) {
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
        int sum = 0;
        int n = board.length;

        if (n == 2) {
            board[0][0] = trace;
            return;
        }

        board[0][0] = trace - (n - 2) - 2;
        board[1][1] = 2;

        int index = 0;
        while (sum < trace && index < n) {
            board[index][index] = 1;
            index++;
            sum++;
        }

        index = 0;
        while (sum < trace && index < n) {
            board[index][index] = Math.min(n, board[index][index] + trace - sum);
            sum += board[index][index] - 1;
            index++;
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
        int testCases = sc.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = sc.nextInt();
            int trace = sc.nextInt();
            int[][] board = new int[n][n];
            boolean isPossible = solution.findAnswer(n, trace, board);
            solution.printAnswer(caseNumber, isPossible, board);
        }
    }
}