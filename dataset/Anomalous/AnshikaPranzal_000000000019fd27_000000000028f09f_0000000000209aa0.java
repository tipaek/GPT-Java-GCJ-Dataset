import java.util.*;

class Solution {

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        int size = board.length;
        int sqrt = (int) Math.sqrt(size);

        // Check row
        for (int d = 0; d < size; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        // Check column
        for (int r = 0; r < size; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        // Check box
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;
        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1, col = -1;
        boolean isEmpty = true;

        // Find an empty cell
        for (int i = 0; i < n && isEmpty; i++) {
            for (int j = 0; j < n && isEmpty; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                }
            }
        }

        // No empty cell found
        if (isEmpty) {
            return true;
        }

        // Try placing numbers 1 to n
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    return true;
                }
                board[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    public static void print(int[][] board, int n) {
        for (int r = 0; r < n; r++) {
            for (int d = 0; d < n; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.print("Case #" + (i + 1) + ": ");

            FindCombinationsWithKToSumN combinator = new FindCombinationsWithKToSumN();
            combinator.findCombinations(k, n, n);
        }
    }
}

class FindCombinationsWithKToSumN {

    public void findCombinations(int k, int n, int size) {
        List<Integer> combinationList = new ArrayList<>();
        combinationUtil(k, n, 0, 1, combinationList, size);
    }

    private void combinationUtil(int k, int n, int sum, int start, List<Integer> combinationList, int size) {
        if (k == 0) {
            if (sum == n) {
                int[][] board = new int[size][size];
                for (int i = 0; i < size; i++) {
                    board[i][i] = combinationList.get(i);
                }

                Solution solver = new Solution();
                if (solver.solveSudoku(board, size)) {
                    System.out.println("POSSIBLE");
                    solver.print(board, size);
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            }
            return;
        }

        for (int i = start; i <= size; i++) {
            combinationList.add(i);
            combinationUtil(k - 1, n, sum + i, i + 1, combinationList, size);
            combinationList.remove(combinationList.size() - 1);
        }
    }
}