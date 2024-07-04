import java.util.Scanner;

public class Solution {
    private static final int MAX_SIZE = 60;
    private static int[][] sqr = new int[MAX_SIZE][MAX_SIZE];
    private static boolean[][] rowSafe = new boolean[MAX_SIZE][MAX_SIZE];
    private static boolean[][] colSafe = new boolean[MAX_SIZE][MAX_SIZE];
    private static int n, k, t;
    private static boolean solved;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            n = input.nextInt();
            k = input.nextInt();
            solved = false;
            solve(1, 1, 0);
            if (!solved) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static void solve(int row, int col, int m) {
        if (row == n && col == n + 1 && m == k && !solved) {
            solved = true;
            System.out.println("Case #" + (t + 1) + ": POSSIBLE");
            printSquare();
            return;
        }
        if (row > n) {
            return;
        }
        if (col > n) {
            solve(row + 1, 1, m);
            return;
        }
        for (int i = 1; i <= n && !solved; ++i) {
            if (!rowSafe[row][i] && !colSafe[col][i]) {
                rowSafe[row][i] = colSafe[col][i] = true;
                if (row == col) {
                    m += i;
                }
                sqr[row][col] = i;
                solve(row, col + 1, m);
                rowSafe[row][i] = colSafe[col][i] = false;
                if (row == col) {
                    m -= i;
                }
                sqr[row][col] = 0;
            }
        }
    }

    private static void printSquare() {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                System.out.print(sqr[i][j] + " ");
            }
            System.out.println();
        }
    }
}