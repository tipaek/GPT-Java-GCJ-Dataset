import java.util.*;

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

    private boolean isValid(int[][] board, int row, int col, int value) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == value) {
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

    private boolean solve(int[][] board, int row, int col, int trace, int currentTrace) {
        if (isSolved(board)) {
            return currentTrace == trace;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || currentTrace > trace) {
            return false;
        }

        if (board[row][col] != 0) {
            return solve(board, row + (col + 1) / board.length, (col + 1) % board.length, trace, currentTrace);
        }

        for (int i = 1; i <= board.length; i++) {
            if (isValid(board, row, col, i)) {
                board[row][col] = i;
                int newTrace = currentTrace + (row == col ? board[row][col] : 0);
                if (solve(board, row + (col + 1) / board.length, (col + 1) % board.length, trace, newTrace)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private void fillBoard(int trace, int[][] board) {
        int sum = 0;
        int index = 0;

        while (sum < trace && index < board.length) {
            board[index][index] = 1;
            sum++;
            index++;
        }

        index = 0;
        while (sum < trace && index < board.length) {
            board[index][index] = Math.min(board.length, board[index][index] + trace - sum);
            sum += board[index][index] - 1;
            index++;
        }
    }

    private boolean findAnswer(int n, int trace, int[][] board) {
        int minTrace = n;
        int maxTrace = n * n;

        if (trace == minTrace + 1 || trace == maxTrace - 1 || trace < minTrace || trace > maxTrace) {
            return false;
        }

        for (int[] row : board) {
            Arrays.fill(row, 0);
        }

        return solve(board, 0, 0, trace, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] board = new int[n][n];
            boolean isPossible = solution.findAnswer(n, k, board);
            solution.printAnswer(caseNumber, isPossible, board);
        }
    }
}