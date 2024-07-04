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

    private boolean isValid(int[][] board, int x, int y, int val) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == val) {
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
            for (int val : row) {
                if (val == 0) {
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

    private boolean findAnswer(int n, int trace, int[][] board) {
        int min = n;
        int max = n * n;

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
        scanner.close();
    }
}