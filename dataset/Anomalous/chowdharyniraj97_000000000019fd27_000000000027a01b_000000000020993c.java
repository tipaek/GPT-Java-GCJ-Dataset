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

            int[] ans = calculateVestigium(mat, n);
            System.out.printf("Case #%d: %d %d %d%n", k, ans[0], ans[1], ans[2]);
        }
    }

    public static int[] calculateVestigium(int[][] mat, int n) {
        int[] row = new int[n + 1];
        int[] col = new int[n + 1];
        int trace = 0, r = 0, c = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(row, 0);
            Arrays.fill(col, 0);
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                row[val]++;
                col[mat[j][i]]++;
                if (row[val] == 2) {
                    r++;
                }
                if (col[mat[j][i]] == 2) {
                    c++;
                }
                if (i == j) {
                    trace += val;
                }
            }
        }

        return new int[]{trace, r, c};
    }
}