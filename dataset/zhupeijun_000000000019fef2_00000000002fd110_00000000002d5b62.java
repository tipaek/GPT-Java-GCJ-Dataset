
import java.util.Scanner;

public class Solution {
    private Scanner sc = new Scanner(System.in);

    private static final long[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final char[] DIRC = {'E', 'W', 'S', 'N'};

    private int find(long[] d, long v) {
        for (int k = 0; k < d.length; ++k) {
            if (v <= d[k]) {
                return k;
            }
        }
        return -1;
    }

    private void solve() {
        long x = sc.nextInt();
        long y = sc.nextInt();

        long len = Math.abs(x) + Math.abs(y);
        if (len % 2 == 0) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        long[] d = new long[35];
        long[] l = new long[35];
        d[0] = 0;
        l[0] = 0;
        long base = 1;
        for (int i = 1; i < d.length; ++i) {
            d[i] = d[i - 1] + base;
            l[i] = base;
            base *= 2;
        }

        int k = find(d, len);
        long step = l[k];
        StringBuilder result = new StringBuilder();
        while (len > 0) {
            for (int i = 0; i < DIR.length; ++i) {
                long nx = x + DIR[i][0] * step;
                long ny = y + DIR[i][1] * step;

                long nl = Math.abs(nx) + Math.abs(ny);
                int nk = find(d, nl);
                if (l[nk] < step) {
                    x = nx;
                    y = ny;
                    len = nl;
                    step /= 2;
                    result.append(DIRC[i]);
                    break;
                }
            }
        }

        result.reverse();
        System.out.println(result.toString());
    }

    private void run() {
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
