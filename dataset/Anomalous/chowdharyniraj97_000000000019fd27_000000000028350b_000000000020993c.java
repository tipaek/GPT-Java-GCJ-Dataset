import java.util.Scanner;

class Solution {

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
            int[] ans = vestigum(mat, n);
            System.out.printf("Case #%d: %d %d %d%n", k, ans[0], ans[1], ans[2]);
        }
    }

    public static int[] vestigum(int[][] mat, int n) {
        int[] ans = new int[3];
        int[][] row = new int[n][n + 1];
        int[][] col = new int[n][n + 1];
        int trace = 0, r = 0, c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                if (row[i][val] == 1 && row[i][0] == 0) {
                    r++;
                    row[i][0] = 1;
                }
                if (col[j][val] == 1 && col[0][j] == 0) {
                    c++;
                    col[0][j] = 1;
                }
                row[i][val]++;
                col[j][val]++;
                if (i == j) {
                    trace += val;
                }
            }
        }

        ans[0] = trace;
        ans[1] = r;
        ans[2] = c;
        return ans;
    }
}