import java.util.Scanner;

public class Solution {
    private static final int MAX_SIZE = 60;
    private static int[][] square = new int[MAX_SIZE][MAX_SIZE];
    private static boolean[][] rowSafe = new boolean[MAX_SIZE][MAX_SIZE];
    private static boolean[][] colSafe = new boolean[MAX_SIZE][MAX_SIZE];
    private static int n, k;
    private static boolean solved;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            n = input.nextInt();
            k = input.nextInt();
            solved = false;
            solve(1, 1, 0);
            if (!solved) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
        input.close();
    }

    private static void solve(int row, int col, int sum) {
        if (row == n && col == n + 1 && sum == k && !solved) {
            solved = true;
            System.out.println("Case #" + (sum + 1) + ": POSSIBLE");
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
        for (int i = 1; i <= n && !solved; i++) {
            if (!rowSafe[row][i] && !colSafe[col][i]) {
                rowSafe[row][i] = colSafe[col][i] = true;
                if (row == col) {
                    sum += i;
                }
                square[row][col] = i;
                solve(row, col + 1, sum);
                rowSafe[row][i] = colSafe[col][i] = false;
                if (row == col) {
                    sum -= i;
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