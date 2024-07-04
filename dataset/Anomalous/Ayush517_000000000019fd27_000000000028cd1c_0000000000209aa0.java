import java.util.Scanner;

class Solution {
    static int[][] square = new int[55][55];
    static int n, k, testCaseNumber;
    static boolean[][] rowUsed = new boolean[55][55];
    static boolean[][] colUsed = new boolean[55][55];
    static boolean solved;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (testCaseNumber = 1; testCaseNumber <= t; testCaseNumber++) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            solved = false;
            solve(1, 1, 0);
            if (!solved) {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
            }
        }
    }

    static void solve(int row, int col, int sum) {
        if (solved) return;
        if (row == n && col == n + 1 && sum == k) {
            solved = true;
            System.out.println("Case #" + testCaseNumber + ": POSSIBLE");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(square[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        if (row > n) return;
        if (col > n) {
            solve(row + 1, 1, sum);
            return;
        }
        tryNumbers(row, col, sum);
    }

    static void tryNumbers(int row, int col, int sum) {
        for (int num = 1; num <= n && !solved; num++) {
            if (!rowUsed[row][num] && !colUsed[col][num]) {
                rowUsed[row][num] = colUsed[col][num] = true;
                if (row == col) {
                    sum += num;
                }
                square[row][col] = num;

                solve(row, col + 1, sum);

                rowUsed[row][num] = colUsed[col][num] = false;
                if (row == col) {
                    sum -= num;
                }
                square[row][col] = 0;
            }
        }
    }
}