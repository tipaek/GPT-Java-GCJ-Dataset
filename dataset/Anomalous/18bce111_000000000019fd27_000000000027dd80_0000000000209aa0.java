import java.util.Scanner;

public class Solution {
    private static final int MAX_SIZE = 60;
    private static int[][] square = new int[MAX_SIZE][MAX_SIZE];
    private static boolean[][] rowSafe = new boolean[MAX_SIZE][MAX_SIZE];
    private static boolean[][] colSafe = new boolean[MAX_SIZE][MAX_SIZE];
    private static int n = 0, k = 0, t = 0;
    private static boolean solved = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        t = input.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            n = input.nextInt();
            k = input.nextInt();
            solve(1, 1, 0);

            if (!solved) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
            solved = false;
        }

        input.close();
    }

    private static void solve(int row, int col, int sum) {
        if (row == n && col == n + 1 && sum == k && !solved) {
            solved = true;
            System.out.println("Case #" + t + ": POSSIBLE");
            printSquare();
            return;
        }

        if (row > n) {
            return;
        }

        if (col > n) {
            solve(row + 1, 1, sum);
            return;
        }

        for (int num = 1; num <= n && !solved; num++) {
            if (!rowSafe[row][num] && !colSafe[col][num]) {
                rowSafe[row][num] = colSafe[col][num] = true;
                if (row == col) {
                    sum += num;
                }
                square[row][col] = num;
                solve(row, col + 1, sum);
                rowSafe[row][num] = colSafe[col][num] = false;
                if (row == col) {
                    sum -= num;
                }
                square[row][col] = 0;
            }
        }
    }

    private static void printSquare() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }
}