import java.util.Scanner;

public class Solution {
    static int[][] sqr = new int[60][60];
    static int n, k, t;
    static boolean[][] rowUsed = new boolean[60][60];
    static boolean[][] colUsed = new boolean[60][60];
    static boolean solved;

    static void solve(int row, int col, int sum) {
        if (row == n && col == n + 1 && sum == k && !solved) {
            solved = true;
            System.out.println("Case #" + t + ": POSSIBLE");
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    System.out.print(sqr[i][j] + " ");
                }
                System.out.println();
            }
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            solve(row + 1, 1, sum);
        }

        for (int i = 1; i <= n && !solved; ++i) {
            if (!rowUsed[row][i] && !colUsed[col][i]) {
                rowUsed[row][i] = colUsed[col][i] = true;
                if (row == col) {
                    sum += i;
                }
                sqr[row][col] = i;

                solve(row, col + 1, sum);

                rowUsed[row][i] = colUsed[col][i] = false;
                if (row == col) {
                    sum -= i;
                }
                sqr[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (t = 1; t <= testCases; ++t) {
            n = sc.nextInt();
            k = sc.nextInt();
            solve(1, 1, 0);
            if (!solved) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
            solved = false;
        }
        sc.close();
    }
}