import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
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
        Thermometers solver = new Thermometers();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Thermometers {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);

            int k = in.nextInt(), n = in.nextInt();
            long[] x = in.nextLongArray(n), temps = in.nextLongArray(n);
            long add = k - x[0];
            for (int i = 0; i < x.length; i++) {
                x[i] = (x[i] + add) % k;
            }

            x = Arrays.copyOf(x, 2 * n + 1);
            for (int i = n; i < x.length; i++) {
                x[i] = x[i - n] + k;
            }


            long[][] min = new long[x.length][x.length];
            long[][] max = new long[x.length][x.length];
            long[][] free = new long[x.length][x.length];
            int[][] sign = new int[x.length][x.length];

            for (int i = 0; i < n; i++) {
                min[i][i] = x[i];
                max[i][i] = x[i + 1];
                free[i][i] = 0;
                sign[i][i] = 1;
                for (int j = i + 1; j <= i + n; j++) {
                    min[i][j] = min[i][j - 1];
                    max[i][j] = max[i][j - 1];
                    sign[i][j] = -sign[i][j - 1];
                    free[i][j] = 2 * x[j] - free[i][j - 1];
                    if (sign[i][j] == 1) {
                        min[i][j] = Math.max(min[i][j], x[j] - free[i][j]);
                        max[i][j] = Math.min(max[i][j], x[j + 1] - free[i][j]);
                    } else {
                        min[i][j] = Math.max(min[i][j], free[i][j] - x[j + 1]);
                        max[i][j] = Math.min(max[i][j], free[i][j] - x[j]);
                    }
                }
            }

            int ans = 2 * n;

            // check ans == n + 1
            for (int start = 0; start < n; start++) {
                long left = min[start][start + n], right = max[start][start + n];
                if (sign[start][start + n] == 1) {
                    if (free[start][start + n] <= k) {
                        ans = n + 1;
                    }
                } else {
                    if (Math.max(left, (free[start][start + n] - k) * 0.5) < right) {
                        ans = n + 1;
                    }
                }
            }
            // check ans == n
            if (min[0][n] < max[0][n]) {
                if (n % 2 == 0) {
                    // t = t + free[0][n]
                    if (free[0][n] == k) {
                        ans = n;
                    }
                } else {
                    // t + k = free[0][n] - t
                    double t = (free[0][n] - k) * 0.5;
                    if (min[0][n] < t && t < max[0][n]) {
                        ans = n;
                    }
                }
            }
            // DP
            int INF = Integer.MAX_VALUE / 3;
            int[][] dp = new int[x.length][x.length];
            for (int start = 0; start < n; start++) {
                for (int[] b : dp) {
                    Arrays.fill(b, INF);
                }
                for (int i = 1; i < n; i++) {
                    if (min[start][start + i] < max[start][start + i]) {
                        dp[start][start + i] = 1;
                    }
                }

                for (int i = start; i < n; i++) {
                    for (int j = start + 1; j < n; j++) {

                        long minStart;
                        if (sign[i][j] == 1) {
                            minStart = min[i][j] + free[i][j];
                        } else {
                            minStart = -max[i][j] + free[i][j];
                        }

                        if (dp[i][j] != INF) {
                            int dpVal = dp[i][j];
                            long[] maxJ = max[j];
                            int[] dpJ = dp[j];
                            for (int next = start + 2; next <= start + n; next++) {
                                if (minStart < maxJ[next] && min[j][next] < max[j][next]) {
                                    dpJ[next] = Math.min(dpJ[next], dpVal + 1);
                                }
                            }
                        }
                    }
                }

                for (int i = 1; i < n; i++) {
                    ans = Math.min(ans, dp[start + i][start + n] + n);
                }
            }
            out.println(ans);
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

        public int nextInt() {
            return Integer.parseInt(next());
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[] nextLongArray(int n) {
            long[] ret = new long[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nextLong();
            }
            return ret;
        }

    }
}

