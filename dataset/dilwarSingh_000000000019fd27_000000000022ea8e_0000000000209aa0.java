import java.util.*;

public class Solution {

    public static boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++) {

            if (board[r][col] == num) {
                return false;
            }
        }
    /*    int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }*/
        return true;
    }

    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
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
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board, int N) {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = s.nextInt();
            int k = s.nextInt();

            int pow = (int) Math.pow(n, 2);
            int arr[] = new int[pow];
            for (int x = 0; x < pow; x++) {
                arr[x] = (x % n) + 1;
            }
            sets.clear();
            printAllSubsets(arr, pow, k, n);

            System.out.print("Case #" + i + ": ");
            boolean getSolution = false;
            for (Collection<Integer> set : sets) {
                Object[] objects = set.toArray();
                int[][] board = new int[n][n];
                for (int x = 0; x < n; x++) {
                    board[x][x] = (Integer) objects[x];
                }
                if (solveSudoku(board, n)) {
                    getSolution = true;
                    System.out.println("POSSIBLE");
                    print(board, n);
                    break;
                }
            }

            if (!getSolution) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static boolean[][] dp;
    static Set<Collection<Integer>> sets = new HashSet<>();

    static void display(ArrayList<Integer> v, int digits) {
        if (v.size() == digits) {
            Collections.sort(v);
            sets.add(new ArrayList<>(v));
        }
    }

    static void printSubsetsRec(int arr[], int i, int sum,
                                ArrayList<Integer> p, int digits) {
        if (i == 0 && sum != 0 && dp[0][sum]) {
            p.add(arr[i]);
            display(p, digits);
            p.clear();
            return;
        }

        if (i == 0 && sum == 0) {
            display(p, digits);
            p.clear();
            return;
        }

        if (dp[i - 1][sum]) {
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(arr, i - 1, sum, b, digits);
        }
        if (sum >= arr[i] && dp[i - 1][sum - arr[i]]) {
            p.add(arr[i]);
            printSubsetsRec(arr, i - 1, sum - arr[i], p, digits);
        }
    }

    static void printAllSubsets(int arr[], int n, int sum, int digits) {
        if (n == 0 || sum < 0)
            return;

        dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = true;
        }

        if (arr[0] <= sum)
            dp[0][arr[0]] = true;

        for (int i = 1; i < n; ++i)
            for (int j = 0; j < sum + 1; ++j)
                dp[i][j] = (arr[i] <= j) ? (dp[i - 1][j] ||
                        dp[i - 1][j - arr[i]])
                        : dp[i - 1][j];
        if (dp[n - 1][sum] == false) {
            System.out.println("There are no subsets with" +
                    " sum " + sum);
            return;
        }
        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsRec(arr, n - 1, sum, p, digits);
    }
}