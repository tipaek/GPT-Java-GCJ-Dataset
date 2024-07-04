import java.util.*;

public class Solution {

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num || board[d][col] == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1, col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n && isEmpty; i++) {
            for (int j = 0; j < n && isEmpty; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                }
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void printBoard(int[][] board, int N) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int pow = n * n;
            int[] arr = new int[pow];
            for (int x = 0; x < pow; x++) {
                arr[x] = (x % n) + 1;
            }
            sets.clear();
            generateAllSubsets(arr, pow, k, n);

            System.out.print("Case #" + i + ": ");
            boolean solutionFound = false;
            for (Collection<Integer> set : sets) {
                Object[] objects = set.toArray();
                int[][] board = new int[n][n];
                for (int x = 0; x < n; x++) {
                    board[x][x] = (Integer) objects[x];
                }
                if (solveSudoku(board, n)) {
                    solutionFound = true;
                    System.out.println("POSSIBLE");
                    printBoard(board, n);
                    break;
                }
            }

            if (!solutionFound) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static boolean[][] dp;
    static Set<Collection<Integer>> sets = new HashSet<>();

    static void addSet(ArrayList<Integer> subset, int digits) {
        if (subset.size() == digits) {
            Collections.sort(subset);
            sets.add(new ArrayList<>(subset));
        }
    }

    static void findSubsetsRec(int[] arr, int i, int sum, ArrayList<Integer> subset, int digits) {
        if (i == 0 && sum != 0 && dp[0][sum]) {
            subset.add(arr[i]);
            addSet(subset, digits);
            subset.clear();
            return;
        }

        if (i == 0 && sum == 0) {
            addSet(subset, digits);
            subset.clear();
            return;
        }

        if (dp[i - 1][sum]) {
            ArrayList<Integer> newSubset = new ArrayList<>(subset);
            findSubsetsRec(arr, i - 1, sum, newSubset, digits);
        }
        if (sum >= arr[i] && dp[i - 1][sum - arr[i]]) {
            subset.add(arr[i]);
            findSubsetsRec(arr, i - 1, sum - arr[i], subset, digits);
        }
    }

    static void generateAllSubsets(int[] arr, int n, int sum, int digits) {
        if (n == 0 || sum < 0) return;

        dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = (arr[i] <= j) ? (dp[i - 1][j] || dp[i - 1][j - arr[i]]) : dp[i - 1][j];
            }
        }

        if (!dp[n - 1][sum]) {
            System.out.println("There are no subsets with sum " + sum);
            return;
        }

        ArrayList<Integer> subset = new ArrayList<>();
        findSubsetsRec(arr, n - 1, sum, subset, digits);
    }
}