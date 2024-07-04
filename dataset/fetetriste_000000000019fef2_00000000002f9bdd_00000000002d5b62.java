import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        A_Expogo solver = new A_Expogo();
        solver.solve(1, in, out);
        out.close();
    }

    static class A_Expogo {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                int x = in.nextInt();
                int y = in.nextInt();
                out.printf("Case #%d: %s\n", test, solve(x, y));
            }
        }

        private String solve(int x, int y) {
            StringBuilder res = new StringBuilder();
            while (x != 0 || y != 0) {
                if (e(x) == e(y)) {
                    return "IMPOSSIBLE";
                }
                if (x == 0) {
                    res.append(y < 0 ? "S" : "N");
                    y -= Math.signum(y);
                } else if (y == 0) {
                    res.append(x < 0 ? "W" : "E");
                    x -= Math.signum(x);
                } else if (e(x)) {
                    if (e((y + 1) / 2) != e(x / 2)) {
                        ++y;
                        res.append("S");
                    } else {
                        --y;
                        res.append("N");
                    }
                } else {
                    if (e((x + 1) / 2) != e(y / 2)) {
                        ++x;
                        res.append("W");
                    } else {
                        --x;
                        res.append("E");
                    }
                }
                x /= 2;
                y /= 2;
            }
            return res.toString();
        }

        private boolean e(int x) {
            return x % 2 == 0;
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

