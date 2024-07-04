import java.util.Scanner;

public class Solution {

    private static boolean hasFoundSolution;

    private void solve(int testcaseNum, int[][] board, int index, int targetSum) throws Exception {
        final int size = board.length;
        if (index == size * size) {
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += board[i][i];
            }
            if (trace == targetSum) {
                System.out.println("Case #" + (testcaseNum + 1) + ": POSSIBLE");
                printSolution(board);
                hasFoundSolution = true;
                throw new Exception();
            }
        } else {
            int row = index / size;
            int col = index % size;

            if (board[row][col] != 0) {
                solve(testcaseNum, board, index + 1, targetSum);
            } else {
                for (int i = 1; i <= size; i++) {
                    if (isConsistent(board, row, col, i, targetSum)) {
                        board[row][col] = i;
                        solve(testcaseNum, board, index + 1, targetSum);
                        board[row][col] = 0;
                    }
                }
            }
        }
    }

    private void printSolution(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private boolean isConsistent(int[][] board, int row, int col, int value, int targetSum) {
        final int size = board.length;
        for (int i = 0; i < size; i++) {
            if (board[row][i] == value || board[i][col] == value) {
                return false;
            }
        }

        int trace = 0;
        int smallerDim = Math.min(row, col);
        for (int i = 0; i <= smallerDim; i++) {
            trace += board[i][i];
        }
        return trace <= targetSum;
    }

    public void runSolver(int testcaseNum, int size, int targetSum) throws Exception {
        int[][] board = new int[size][size];
        solve(testcaseNum, board, 0, targetSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        Solution solution = new Solution();

        for (int i = 0; i < t; i++) {
            hasFoundSolution = false;
            int size = scanner.nextInt();
            int targetSum = scanner.nextInt();

            try {
                solution.runSolver(i, size, targetSum);
            } catch (Exception ignored) {
            }

            if (!hasFoundSolution) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}