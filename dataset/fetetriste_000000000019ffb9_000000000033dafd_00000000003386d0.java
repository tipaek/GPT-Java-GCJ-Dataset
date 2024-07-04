import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        C_WormholeInOne solver = new C_WormholeInOne();
        solver.solve(1, in, out);
        out.close();
    }

    static class C_WormholeInOne {
        int ans;
        int[] pair;
        int n;
        int[] x;
        int[] y;

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                int n = in.nextInt();
                int[] x = new int[n];
                int[] y = new int[n];
                for (int i = 0; i < n; i++) {
                    x[i] = in.nextInt();
                    y[i] = in.nextInt();
                }
                out.printf("Case #%d: %d\n", test, solve(x, y));
            }
        }

        private int solve(int[] x, int[] y) {
            int n = x.length;
            if (n < 3) {
                return n;
            }
            this.n = n;
            this.x = x;
            this.y = y;
            ans = 0;
            pair = new int[n];
            Arrays.fill(pair, -1);
            rec(0);
            return ans;
        }

        private void rec(int pos) {
            if (pos == n) {
                for (int dir0 = 0; dir0 < n; dir0++) {
                    for (int dir1 = 0; dir1 < dir0; dir1++) {
                        long dx = x[dir1] - x[dir0];
                        long dy = y[dir1] - y[dir0];
                        for (int i = 0; i < n; i++) {
                            ans = Math.max(ans, simulate(i, dx, dy));
                        }
                    }
                }
                return;
            }

            rec(pos + 1);
            for (int i = pos + 1; i < n; i++) {
                if (pair[i] >= 0) {
                    continue;
                }
                pair[pos] = i;
                pair[i] = pos;
                rec(pos + 1);
                pair[pos] = -1;
                pair[i] = -1;
            }
        }

        private int simulate(int i, long dx, long dy) {
            boolean[] was = new boolean[n];
            int res = 0;
            for (int step = 0; step < 2 * n + 1; step++) {
                was[i] = true;
                i = pair[i];
                if (i < 0) {
                    break;
                }
                was[i] = true;
                int k = -1;
                long distK = -1;
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        continue;
                    }
                    long odx = x[j] - x[i];
                    long ody = y[j] - y[i];
                    long distJ = odx * odx + ody * ody;
                    if (dot(dx, dy, odx, ody) <= 0) {
                        continue;
                    }
                    if (cross(dx, dy, odx, ody) != 0) {
                        continue;
                    }
                    if (k < 0 || distK > distJ) {
                        k = j;
                        distK = distJ;
                    }
                }
                if (k < 0) {
                    break;
                }
                i = k;
            }
            for (int j = 0; j < n; j++) {
                if (was[j]) {
                    ++res;
                }
            }
            return res;
        }

        private long dot(long x0, long y0, long x1, long y1) {
            return x0 * x1 + y0 * y1;
        }

        private long cross(long x0, long y0, long x1, long y1) {
            return x0 * y1 - x1 * y0;
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

