import java.util.Scanner;

public class Incidium {
    private static final int MAX_SIZE = 60;
    private static int[][] sqr = new int[MAX_SIZE][MAX_SIZE];
    private static int n = 0, k = 0, t = 0;
    private static boolean[][] rowSafe = new boolean[MAX_SIZE][MAX_SIZE];
    private static boolean[][] colSafe = new boolean[MAX_SIZE][MAX_SIZE];
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

    private static void solve(int row, int col, int m) {
        if (row == n && col == n + 1 && m == k && !solved) {
            solved = true;
            System.out.println("Case #" + (t + 1) + ": POSSIBLE");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(sqr[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        if (row > n) {
            return;
        }
        if (col > n) {
            solve(row + 1, 1, m);
            return;
        }
        for (int i = 1; i <= n && !solved; i++) {
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
}