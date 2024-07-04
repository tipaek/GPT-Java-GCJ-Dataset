import java.util.Scanner;

public class Solution {

    private void printAnswer(int testCaseNumber, boolean isPossible, int[][] board) {
        String result = isPossible ? "POSSIBLE" : "IMPOSSIBLE";
        System.out.println("Case #" + testCaseNumber + ": " + result);
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

        for (int[] rows : board) {
            if (rows[col] == value) {
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
        for (int[] rows : board) {
            for (int cell : rows) {
                if (cell == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean solve(int[][] board, int row, int col) {
        if (row >= board.length || col >= board[0].length) {
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
        int index = 0;

        while (sum < trace && index < board.length) {
            board[index][index] = 1;
            index++;
            sum++;
        }

        index = 0;
        while (sum < trace && index < board.length) {
            board[index][index] = Math.min(board.length, board[index][index] + trace - sum);
            sum += board[index][index] - 1;
            index++;
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

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int boardSize = scanner.nextInt();
            int trace = scanner.nextInt();
            int[][] board = new int[boardSize][boardSize];
            boolean isPossible = solution.findAnswer(boardSize, trace, board);
            solution.printAnswer(testCase, isPossible, board);
        }
    }
}