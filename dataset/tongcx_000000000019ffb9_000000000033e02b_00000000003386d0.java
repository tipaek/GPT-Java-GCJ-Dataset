import java.util.Scanner;

public class Solution {

    static int loss(int even, int odd, int one) {
        if (odd == 0 && one == 0) {
            if (even == 1) {
                return 0;
            }
            return 1;
        }
        if (odd + one <= 2) {
            return 0;
        }
        if (odd % 2 == 0) {
            if (one > 2) {
                return one - 2;
            }
            return 0;
        }
        if (one > 1) {
            return one - 1;
        }
        return 0;
    }

    static boolean sameDir(long x0, long y0, long x1, long y1) {
        return x0*y1 - y0*x1 == 0;
    }

    static int go(long[] x, long[] y) {
        int n = x.length;
        if (n == 1) {
            return 1;
        }
        long[] dx = new long[n*n];
        long[] dy = new long[n*n];
        int nd = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean hasSame = false;
                long dxx = x[j] - x[i];
                long dyy = y[j] - y[i];
                for (int k = 0; k < nd; k++) {
                    if (sameDir(dxx, dyy, dx[k], dy[k])) {
                        hasSame = true;
                        break;
                    }
                }
                if (!hasSame) {
                    dx[nd] = dxx;
                    dy[nd] = dyy;
                    nd++;
                }
            }
        }

        int ans = 0;
        for (int k = 0; k < nd; k++) {
            int nc = 0;
            int[] cnt = new int[n];
            int[] rep = new int[n];
            for (int i = 0; i < n; i++) {
                boolean hasSame = false;
                for (int c = 0; c < nc; c++) {
                    if (sameDir(x[i] - x[rep[c]], y[i] - y[rep[c]], dx[k], dy[k])) {
                        hasSame = true;
                        cnt[c]++;
                        break;
                    }
                }
                if (!hasSame) {
                    cnt[nc] = 1;
                    rep[nc] = i;
                    nc++;
                }
            }
            /*
            for (int c = 0; c < nc; c++) {
                System.out.printf("%d ", cnt[c]);
            }
            System.out.println();
             */

            int even = 0;
            int odd = 0;
            int one = 0;
            for (int c = 0; c < nc; c++) {
                if (cnt[c] == 1) {
                    one++;
                } else if (cnt[c] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            // System.out.printf("e %d %d %d %d\n", even, odd, n, helper(even, odd, n));
            ans = Math.max(ans, n - loss(even, odd, one));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            long []x = new long[n];
            long []y = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextLong();
                y[i] = scanner.nextLong();
            }
            System.out.printf("Case #%d: %d\n", t+1, go(x, y));
        }
    }
}
