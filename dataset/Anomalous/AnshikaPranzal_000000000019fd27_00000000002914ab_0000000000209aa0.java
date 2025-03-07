import java.util.*;

public class Solution {

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check row for the number
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        // Check column for the number
        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        // Check subgrid for the number
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        // No conflicts, safe to place the number
        return true;
    }

    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1, col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < n && isEmpty; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
        }

        if (isEmpty) {
            return true; // No empty space left
        }

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    return true;
                }
                board[row][col] = 0; // Backtrack
            }
        }

        return false; // Trigger backtracking
    }

    public static void printBoard(int[][] board, int n) {
        for (int r = 0; r < n; r++) {
            for (int d = 0; d < n; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.hasNextInt() ? sc.nextInt() : 0;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            System.out.print("Case #" + (i + 1) + ": ");
            FindCombinationsWithKToSumN combFinder = new FindCombinationsWithKToSumN();
            combFinder.findCombinations(k, n, n);
        }
    }
}

class FindCombinationsWithKToSumN {

    public void findCombinations(int n, int k, int k2) {
        List<Integer> combinationList = new ArrayList<>();
        combinationUtil(k, n, 0, 1, combinationList, k2);
    }

    private void combinationUtil(int k, int n, int sum, int start, List<Integer> combinationList, int k2) {
        if (k == 0) {
            if (sum == n) {
                int[][] board = new int[k2][k2];
                for (int i = 0; i < k2; i++) {
                    board[i][i] = combinationList.get(i);
                }

                Solution solver = new Solution();
                if (solver.solveSudoku(board, k2)) {
                    System.out.println("POSSIBLE");
                    solver.printBoard(board, k2);
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            }
            return;
        }

        for (int i = start; i <= k2; i++) {
            combinationList.add(i);
            combinationUtil(k - 1, n, sum + i, i + 1, combinationList, k2);
            combinationList.remove(combinationList.size() - 1);
        }
    }
}