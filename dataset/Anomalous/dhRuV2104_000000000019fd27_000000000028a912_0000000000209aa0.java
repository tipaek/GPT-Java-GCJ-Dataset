import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Cell {
    int row, col;
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            String result = isLatinPossible(n, k);

            System.out.println("Case #" + testCase + ": " + result);

            if (result.equals("POSSIBLE")) {
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        System.out.print(ansBoard[row][col] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static String isLatinPossible(int n, int k) {
        results = new HashSet<>();
        dp = new boolean[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (i <= j) {
                        dp[i][j] = dp[i][j] || dp[i][j - i];
                    }
                }
            }
        }

        if (!dp[n][k]) {
            return "IMPOSSIBLE";
        }

        List<Integer> tempCombination = new ArrayList<>();
        findCombinations(n, k, n, tempCombination);

        for (List<Integer> combination : results) {
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                board[i][i] = combination.get(i);
            }

            if (makeLatinMatrix(board)) {
                return "POSSIBLE";
            }
        }

        return "IMPOSSIBLE";
    }

    private static boolean makeLatinMatrix(int[][] board) {
        Cell cell = new Cell();
        int size = board.length;
        if (!findUnassignedCell(board, cell)) {
            ansBoard = board;
            return true;
        }

        for (int num = 1; num <= size; num++) {
            if (isSafe(board, num, cell.row, cell.col)) {
                board[cell.row][cell.col] = num;
                if (makeLatinMatrix(board)) {
                    return true;
                }
                board[cell.row][cell.col] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] board, int num, int row, int col) {
        int size = board.length;

        for (int i = 0; i < size; i++) {
            if (i != row && board[i][col] == num) {
                return false;
            }
        }

        for (int i = 0; i < size; i++) {
            if (i != col && board[row][i] == num) {
                return false;
            }
        }

        return true;
    }

    private static boolean findUnassignedCell(int[][] board, Cell cell) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == 0) {
                    cell.row = row;
                    cell.col = col;
                    return true;
                }
            }
        }
        return false;
    }

    private static void findCombinations(int index, int target, int count, List<Integer> tempCombination) {
        if (count == 0) {
            if (target == 0) {
                List<Integer> combination = new ArrayList<>(tempCombination);
                Collections.sort(combination);
                results.add(combination);
            }
            return;
        }

        if (index == 0 || target <= 0 || count < 0 || !dp[index][target]) {
            return;
        }

        if (index <= target && dp[index][target - index]) {
            tempCombination.add(index);
            findCombinations(index, target - index, count - 1, tempCombination);
            tempCombination.remove(tempCombination.size() - 1);
        }

        if (dp[index - 1][target]) {
            findCombinations(index - 1, target, count, tempCombination);
        }
    }

    static Set<List<Integer>> results;
    static int[][] ansBoard;
    static boolean[][] dp;
}