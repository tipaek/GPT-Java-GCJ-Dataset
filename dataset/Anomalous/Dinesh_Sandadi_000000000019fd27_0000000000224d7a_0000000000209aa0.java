import java.util.*;

public class Solution {

    private void printAnswer(int caseNumber, boolean isPossible, int[][] board) {
        String result = isPossible ? "POSSIBLE" : "IMPOSSIBLE";
        System.out.println("Case #" + caseNumber + ": " + result);
        if (isPossible) {
            for (int[] row : board) {
                for (int cell : row) {
                    System.out.print(cell + " ");
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

    private boolean solve(int[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        if (isSolved(board)) {
            return true;
        }

        if (board[row][col] != 0) {
            return solve(board, row + (col + 1) / board.length, (col + 1) % board.length);
        }

        for (int value = 1; value <= board.length; value++) {
            if (isValid(board, row, col, value)) {
                board[row][col] = value;

                if (solve(board, row + (col + 1) / board.length, (col + 1) % board.length)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }
        return false;
    }

    private void fillBoard(int trace, int[][] board) {
        int sum = 0;
        while (sum < trace) {
            for (int i = 0; i < board.length && sum < trace; i++) {
                board[i][i]++;
                sum++;
            }
        }
    }

    private boolean findAnswer(int size, int trace, int[][] board) {
        int minTrace = size;
        int maxTrace = size * size;

        if (trace == minTrace + 1 || trace == maxTrace - 1 || trace < minTrace || trace > maxTrace) {
            return false;
        }

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
            int size = scanner.nextInt();
            int trace = scanner.nextInt();
            int[][] board = new int[size][size];
            boolean isPossible = solution.findAnswer(size, trace, board);
            solution.printAnswer(caseNumber, isPossible, board);
        }
    }
}