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

        for (int[] ints : board) {
            if (ints[col] == value) {
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

        for (int i = 1; i <= board.length; i++) {
            if (isValid(board, row, col, i)) {
                board[row][col] = i;

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
            int index = 0;
            while (sum < trace && index < board.length) {
                board[index][index]++;
                sum++;
                index++;
            }
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
        scanner.close();
    }
}