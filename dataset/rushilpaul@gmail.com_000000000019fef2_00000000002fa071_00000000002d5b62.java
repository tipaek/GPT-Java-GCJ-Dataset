import java.util.*;

public class Solution {

    static long values[];
    static String ans;
    static char path[];
    static int tx, ty, bestLen, delta = 101;
    static boolean dp[][][];

    static void f(int x, int y, int n) {

        if(Math.abs(x) > Math.abs(tx) || Math.abs(y) > Math.abs(ty) || n >= 63)
            return;
        if(x == tx && y == ty) {
            if(n < bestLen) {
                bestLen = n;
                ans = new String(path, 0, n);
            }
            return;
        }
        if(dp[x+delta][y+delta][n])
            return;
        dp[x+delta][y+delta][n] = true;

        path[n] = 'E';
        f((int)(x + values[n]), y, n + 1);
        path[n] = 'W';
        f((int)(x - values[n]), y, n + 1);
        path[n] = 'N';
        f(x, (int)(y + values[n]), n + 1);
        path[n] = 'S';
        f(x, (int)(y - values[n]), n + 1);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        values = new long[63];
        for(int i = 0; i < 63; i++)
            values[i] = (1L << i);

        int t = sc.nextInt();
        for(int tt = 1; tt <= t; tt++) {

            tx = sc.nextInt();
            ty = sc.nextInt();
            path = new char[1000];
            ans = "";
            bestLen = Integer.MAX_VALUE;
            dp = new boolean[301][301][63];
            f(0, 0, 0);
            if(ans.length() == 0)
                ans = "IMPOSSIBLE";
            System.out.printf("Case #%d: %s\n", tt, ans);
        }
    }

}
