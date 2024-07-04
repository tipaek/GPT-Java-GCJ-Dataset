import java.util.Scanner;

public class Solution {

    private static boolean hasFoundSolution;

    private void solve(int testcaseNum, int[][] board, int ind, int sum) throws Exception {
        final int S = board.length;
        if (ind == S * S) {
            // We've definitely reached a solution now
            int trace = 0;
            for (int i = 0; i < board.length; i++) {
                trace += board[i][i];
            }
            if (trace == sum) {
                System.out.println("Case #" + (testcaseNum + 1) + ": POSSIBLE");
                printSolution(board);
                hasFoundSolution = true;
                throw new Exception();
            }
        } else {
            int row = ind / S;
            int col = ind % S;

            // Advance forward on cells that are prefilled
            if (board[row][col] != 0) {
                solve(testcaseNum, board, ind + 1, sum);
            } else {
                // We are positioned on something we need to fill in. Try all possibilities
                for (int i = 1; i <= S; i++) {
                    if (consistent(board, row, col, i, sum)) {
                        board[row][col] = i;
                        solve(testcaseNum, board, ind + 1, sum);
                        board[row][col] = 0; // Unmake move
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

    private boolean consistent(int[][] board, int row, int col, int c, int sum) {
        final int S = board.length;
        // Check columns/rows
        for (int i = 0; i < S; i++) {
            if (board[row][i] == c || board[i][col] == c) {
                return false;
            }
        }

        int trace = 0;
        int smallerDim = Math.min(row, col);
        for (int i = 0; i <= smallerDim; i++) {
            trace += board[i][i];
        }
        return trace <= sum;
    }

    public void runSolver(int testcaseNum, int size, int sum) throws Exception {
        int[][] board = new int[size][size];
        solve(testcaseNum, board, 0, sum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Solution ob = new Solution();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            hasFoundSolution = false;
            int size = in.nextInt();
            int sum = in.nextInt();
            in.nextLine();
            try {
                ob.runSolver(i, size, sum);
            } catch (Exception e) {
                // Continue to next test case
            }

            if (!hasFoundSolution) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}