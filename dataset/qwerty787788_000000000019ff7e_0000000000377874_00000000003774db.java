import java.io.*;
import java.util.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    class MyString {
        MyString prev;
        char last;

        public MyString(MyString prev, char last) {
            this.prev = prev;
            this.last = last;
        }

        String str() {
            if (prev != null) {
                return prev.str() + last;
            } else {
                return "" + last;
            }
        }
    }

    void update(int[][] dp, MyString[][][] ans, int i, int j, int cost, int d1, MyString what) {
        if (dp[i][j] < cost) {
            return;
        }
        if (dp[i][j] > cost) {
            ans[i][j] = new MyString[cost + 1];
            dp[i][j] = cost;
        }
        if (ans[i][j][d1] != null && what.prev == null) {

        } else {
            ans[i][j][d1] = what;
        }
    }

    String solve(char[] a, char[] b) {
        int n = a.length;
        int m = b.length;
        // maxDist
        int[][] dp = new int[n + 1][m + 1];
        MyString[][][] ans = new MyString[n + 1][m + 1][];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        MyString empty = new MyString(null, ' ');
        ans[0][0] = new MyString[]{empty};
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int cur = dp[i][j];
                if (cur >= Integer.MAX_VALUE / 2) {
                    continue;
                }
                MyString[] last = ans[i][j];
                for (int d1 = 0; d1 < last.length; d1++) {
                    if (last[d1] == null) {
                        continue;
                    }
                    MyString lastStr = last[d1];
                    if (i < n) {
                        update(dp, ans, i + 1, j, cur + 1, d1 + 1, lastStr);
                        update(dp, ans, i + 1, j, cur + 1, d1, new MyString(lastStr, a[i]));
                        if (j < m) {
                            update(dp, ans, i + 1, j + 1, cur + 1, d1, new MyString(lastStr, a[i]));
                        }
                    }
                    if (j < m) {
                        update(dp, ans, i, j + 1, cur + 1, d1, lastStr);
                        update(dp, ans, i, j + 1, cur + 1, d1 + 1, new MyString(lastStr, b[j]));
                        if (i < n) {
                            update(dp, ans, i, j + 1, cur + 1, d1 + 1, new MyString(lastStr, b[j]));
                        }
                    }
                    if (i < n && j < m && a[i] == b[j]) {
                        update(dp, ans, i + 1, j + 1, cur, d1, new MyString(lastStr, a[i]));
                    }
                }
            }
        }
        MyString[] last = ans[n][m];
        MyString result = null;
        int bDiff = Integer.MAX_VALUE;
        int cost = dp[n][m];
        for (int i = 0; i < last.length; i++) {
            if (last[i] == null) {
                continue;
            }
            int d1 = i, d2 = cost - i;
            int diff = Math.abs(d1 - d2);
            if (diff < bDiff) {
                bDiff = diff;
                result = last[i];
            }
        }
        return result.str().substring(1);
    }

    void solve() {
        int tc = in.nextInt();
        for (int t = 0; t < tc; t++) {
            char[] a = in.next().toCharArray();
            char[] b = in.next().toCharArray();
            out.println("Case #" + (t + 1) + ": " + solve(a, b));
        }
    }

    void run() {
        try {
            in = new FastScanner(new File("Solution.in"));
            out = new PrintWriter(new File("Solution.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
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
    }

    public static void main(String[] args) {
        new Solution().runIO();
    }
}