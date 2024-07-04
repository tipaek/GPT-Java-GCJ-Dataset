import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int l = 1; l <= t; l++) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = in.nextInt();
                }
            }
            solve(l, n, m);
        }
    }


    public static void solve(int t, int n, int[][] m) {
        int k = 0, r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            k += m[i][i];
        }
        for (int i = 0; i < n; i++) {
            int[] rc = new int[n + 1], cc = new int[n + 1];
            for (int j = 0; j < n; j++) {
                rc[m[i][j]]++;
                cc[m[j][i]]++;
            }
            boolean dupR = false, dupC = false;
            for (int j = 0; j <= n; j++) {
                if (rc[j] > 1) dupR = true;
                if (cc[j] > 1) dupC = true;
            }
            if (dupR) r++;
            if (dupC) c++;
        }
        System.out.println(String.format("Case #%d: %d %d %d", t, k, r, c));
    }
}
