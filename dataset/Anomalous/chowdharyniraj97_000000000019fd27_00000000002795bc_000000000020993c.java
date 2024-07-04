import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int[] ans = new int[3];
            vestigum(mat, n, ans);
            System.out.println("Case #" + k + ": " + ans[0] + " " + ans[1] + " " + ans[2]);
        }
    }

    public static void vestigum(int[][] mat, int n, int[] ans) {
        boolean[][] row = new boolean[n][n + 1];
        boolean[][] col = new boolean[n][n + 1];
        int trace = 0;
        int r = 0;
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                if (row[i][val]) {
                    r++;
                }
                if (col[j][val]) {
                    c++;
                }
                row[i][val] = true;
                col[j][val] = true;
                if (i == j) {
                    trace += val;
                }
            }
        }

        ans[0] = trace;
        ans[1] = r;
        ans[2] = c;
    }
}