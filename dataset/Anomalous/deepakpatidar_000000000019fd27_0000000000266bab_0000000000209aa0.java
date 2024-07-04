import java.util.Scanner;

public class Solution {
    private static final int MAX_SIZE = 60;
    private static int[][] square = new int[MAX_SIZE][MAX_SIZE];
    private static boolean[][] rowUsed = new boolean[MAX_SIZE][MAX_SIZE];
    private static boolean[][] colUsed = new boolean[MAX_SIZE][MAX_SIZE];
    private static int n, k, testCaseNumber;
    private static boolean solved;

    private static void solve(int row, int col, int sum) {
        if (row == n && col == n + 1 && sum == k && !solved) {
            solved = true;
            System.out.println("Case #" + testCaseNumber + ": POSSIBLE");
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    System.out.print(square[i][j] + " ");
                }
                System.out.println();
            }
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            solve(row + 1, 1, sum);
            return;
        }

        for (int i = 1; i <= n && !solved; ++i) {
            if (!rowUsed[row][i] && !colUsed[col][i]) {
                rowUsed[row][i] = colUsed[col][i] = true;
                if (row == col) {
                    sum += i;
                }
                square[row][col] = i;

                solve(row, col + 1, sum);

                rowUsed[row][i] = colUsed[col][i] = false;
                if (row == col) {
                    sum -= i;
                }
                square[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int currentTestCase = 1; currentTestCase <= testCases; ++currentTestCase) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            testCaseNumber = currentTestCase;
            solve(1, 1, 0);
            if (!solved) {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
            }
            solved = false;
        }
        scanner.close();
    }
}