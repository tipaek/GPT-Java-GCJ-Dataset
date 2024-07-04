import java.io.*;
import java.util.*;

public class Solution {
    static String M;
    static Integer[][] dp;

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        int tc = scn.nextInt();

        for (int t = 1; t <= tc; t++) {
            int x = scn.nextInt();
            int y = scn.nextInt();
            M = scn.next();
            dp = new Integer[2010][1005];
            int ans = dfs(x, y, 0);
            System.out.print("Case #" + t + ": ");
            System.out.println(ans != Integer.MAX_VALUE ? ans : "IMPOSSIBLE");
        }
    }

    static int dfs(int x, int y, int cur) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);

        if (dp[absX + absY][cur] != null && dp[absX + absY][cur] != Integer.MAX_VALUE) {
            return dp[absX + absY][cur];
        }
        if (cur >= M.length() && (x != 0 || y != 0)) {
            dp[absX + absY][cur] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        if (x == 0 && y == 0) {
            return cur;
        }

        char dir = M.charAt(cur);
        int xp = x, yp = y;
        if (dir == 'N' || dir == 'S') {
            yp += (dir == 'N') ? 1 : -1;
        } else {
            xp += (dir == 'E') ? 1 : -1;
        }

        int move = -1;
        if (Math.abs(xp) > Math.abs(yp)) {
            move = (xp > 0) ? dfs(xp - 1, yp, cur + 1) : dfs(xp + 1, yp, cur + 1);
        } else {
            move = (yp > 0) ? dfs(xp, yp - 1, cur + 1) : dfs(xp, yp + 1, cur + 1);
        }

        int dm = dfs(xp, yp, cur + 1);
        dp[absX + absY][cur] = Math.min(move, dm);
        return dp[absX + absY][cur];
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}