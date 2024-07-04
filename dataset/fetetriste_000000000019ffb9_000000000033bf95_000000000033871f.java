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
        B_SecurityUpdate solver = new B_SecurityUpdate();
        solver.solve(1, in, out);
        out.close();
    }

    static class B_SecurityUpdate {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            final int D = 1010;

            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                int n = in.nextInt();
                int m = in.nextInt();
                int[] x = new int[n];
                int[] firstAtLevel = new int[n];
                Arrays.fill(firstAtLevel, -1);
                int[] nextAtLevel = new int[n];

                int[] dist = new int[n];
                int[] numAtDistance = new int[D];
                numAtDistance[0] = 1;

                for (int i = 1; i < n; i++) {
                    x[i] = in.nextInt();
                    if (x[i] >= 0) {
                        dist[i] = x[i];
                        ++numAtDistance[dist[i]];
                    } else {
                        nextAtLevel[i] = firstAtLevel[-x[i]];
                        firstAtLevel[-x[i]] = i;
                    }
                }

                for (int lvl = 1; lvl < n; lvl++) {
                    if (firstAtLevel[lvl] < 0) {
                        continue;
                    }
                    int soFar = 0;
                    int curD = -1;
                    for (int d = 1; d < D; d++) {
                        soFar += numAtDistance[d - 1];
                        if (soFar >= lvl) {
                            curD = d;
                            break;
                        }
                    }
                    if (soFar != lvl) {
                        throw new AssertionError(test + " " + soFar + " " + lvl);
                    }
                    for (int i = firstAtLevel[lvl]; i >= 0; i = nextAtLevel[i]) {
                        dist[i] = curD;
                        ++numAtDistance[curD];
                    }
                }

                out.printf("Case #%d:", test);
                for (int i = 0; i < m; i++) {
                    int a = in.nextInt() - 1;
                    int b = in.nextInt() - 1;
                    int d = Math.abs(dist[a] - dist[b]);
                    if (d == 0) {
                        d = (int) 1e6;
                    }
                    out.printf(" " + d);
                }
                out.println();
            }
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

