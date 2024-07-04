import java.util.Scanner;

class Solution {
    static boolean solved;
    static int[][] ans = new int[60][60];
    static boolean[][] rowsafe = new boolean[60][60];
    static boolean[][] colsafe = new boolean[60][60];
    static int n, k, t;

    static void solver(int row, int col, int m) {
        if (row == n && col == n + 1 && m == k && !solved) {
            solved = true;
            System.out.println("Case #" + t + ": POSSIBLE");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            solver(row + 1, 1, m);
            return;
        }

        for (int i = 1; i <= n && !solved; i++) {
            if (!rowsafe[row][i] && !colsafe[col][i]) {
                rowsafe[row][i] = colsafe[col][i] = true;
                if (row == col) m += i;

                ans[row][col] = i;
                solver(row, col + 1, m);

                rowsafe[row][i] = colsafe[col][i] = false;
                if (row == col) m -= i;
                ans[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();

        for (t = 1; t <= z; t++) {
            n = sc.nextInt();
            k = sc.nextInt();
            solved = false;
            solver(1, 1, 0);
            if (!solved)
                System.out.println("Case #" + t + ": IMPOSSIBLE");
        }
    }
}