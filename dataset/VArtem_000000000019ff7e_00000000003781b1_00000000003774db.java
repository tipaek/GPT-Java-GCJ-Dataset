import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NamingCompromise solver = new NamingCompromise();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class NamingCompromise {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);

            String s = in.next(), t = in.next();
            int n = s.length(), m = t.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= m; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    }
                }
            }
            int ans = dp[n][m] / 2;
            int curI = n, curJ = m;
            while (dp[curI][curJ] > ans) {
                if (curI > 0 && curJ > 0 && s.charAt(curI - 1) == t.charAt(curJ - 1) && dp[curI][curJ] == dp[curI - 1][curJ - 1]) {
                    curI--;
                    curJ--;
                    continue;
                }
                if (curI > 0 && curJ > 0 && dp[curI][curJ] == dp[curI - 1][curJ - 1] + 1) {
                    curI--;
                    curJ--;
                    continue;
                }
                if (curI > 0 && dp[curI][curJ] == dp[curI - 1][curJ] + 1) {
                    curI--;
                    continue;
                }
                if (curJ > 0 && dp[curI][curJ] == dp[curI][curJ - 1] + 1) {
                    curJ--;
                    continue;
                }
            }
            out.println(s.substring(0, curI) + t.substring(curJ));
        }

    }

    static class FastScanner {
        public BufferedReader br;
        public StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

    }
}

