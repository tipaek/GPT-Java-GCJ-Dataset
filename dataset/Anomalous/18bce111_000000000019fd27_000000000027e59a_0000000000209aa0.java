import java.util.Scanner;

class Solution {
    private static final int MAX_SIZE = 60;
    private static int[][] sqr = new int[MAX_SIZE][MAX_SIZE];
    private static int n = 0, k = 0;
    private static boolean[][] rowSafe = new boolean[MAX_SIZE][MAX_SIZE];
    private static boolean[][] colSafe = new boolean[MAX_SIZE][MAX_SIZE];
    private static boolean solved = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            n = input.nextInt();
            k = input.nextInt();
            solve(1, 1, 0, i);
            if (!solved) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            solved = false;
        }
    }

    private static void solve(int row, int col, int m, int caseNumber) {
        if (row == n && col == n + 1 && m == k && !solved) {
            solved = true;
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printSolution();
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            solve(row + 1, 1, m, caseNumber);
            return;
        }

        for (int i = 1; i <= n && !solved; i++) {
            if (!rowSafe[row][i] && !colSafe[col][i]) {
                rowSafe[row][i] = colSafe[col][i] = true;
                if (row == col) {
                    m += i;
                }
                sqr[row][col] = i;
                solve(row, col + 1, m, caseNumber);
                rowSafe[row][i] = colSafe[col][i] = false;
                if (row == col) {
                    m -= i;
                }
                sqr[row][col] = 0;
            }
        }
    }

    private static void printSolution() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(sqr[i][j] + " ");
            }
            System.out.println();
        }
    }
}