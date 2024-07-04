import java.util.*;

public class Solution {

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        int size = board.length;
        int sqrt = (int) Math.sqrt(size);

        // Check row and column
        for (int i = 0; i < size; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check sub-grid
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

        // Find the first empty cell
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

        // No empty cell found, puzzle solved
        if (isEmpty) {
            return true;
        }

        // Try placing numbers 1 to n in the empty cell
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    return true;
                }
                board[row][col] = 0; // Reset cell if placing num didn't lead to solution
            }
        }

        return false; // Trigger backtracking
    }

    public static void print(int[][] board, int n) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int size = n * n;
            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = (i % n) + 1;
            }

            sets.clear();
            findAllSubsets(arr, size, k, n);

            System.out.print("Case #" + t + ": ");
            boolean solutionFound = false;

            for (Collection<Integer> set : sets) {
                int[][] board = new int[n][n];
                Integer[] nums = set.toArray(new Integer[0]);

                for (int i = 0; i < n; i++) {
                    board[i][i] = nums[i];
                }

                if (solveSudoku(board, n)) {
                    solutionFound = true;
                    System.out.println("POSSIBLE");
                    print(board, n);
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

    static void display(ArrayList<Integer> subset, int digits) {
        if (subset.size() == digits) {
            Collections.sort(subset);
            sets.add(new ArrayList<>(subset));
        }
    }

    static void findSubsetsRecursively(int[] arr, int index, int sum, ArrayList<Integer> currentSubset, int digits) {
        if (index == 0 && sum != 0 && dp[0][sum]) {
            currentSubset.add(arr[0]);
            display(currentSubset, digits);
            currentSubset.clear();
            return;
        }

        if (index == 0 && sum == 0) {
            display(currentSubset, digits);
            currentSubset.clear();
            return;
        }

        if (dp[index - 1][sum]) {
            ArrayList<Integer> newSubset = new ArrayList<>(currentSubset);
            findSubsetsRecursively(arr, index - 1, sum, newSubset, digits);
        }

        if (sum >= arr[index] && dp[index - 1][sum - arr[index]]) {
            currentSubset.add(arr[index]);
            findSubsetsRecursively(arr, index - 1, sum - arr[index], currentSubset, digits);
        }
    }

    static void findAllSubsets(int[] arr, int n, int sum, int digits) {
        if (n == 0 || sum < 0) {
            return;
        }

        dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j] || (j >= arr[i] && dp[i - 1][j - arr[i]]);
            }
        }

        if (!dp[n - 1][sum]) {
            System.out.println("There are no subsets with sum " + sum);
            return;
        }

        ArrayList<Integer> currentSubset = new ArrayList<>();
        findSubsetsRecursively(arr, n - 1, sum, currentSubset, digits);
    }
}