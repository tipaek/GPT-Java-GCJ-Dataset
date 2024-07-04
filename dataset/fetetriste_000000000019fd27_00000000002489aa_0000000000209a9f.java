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
        B_NestingDepth solver = new B_NestingDepth();
        solver.solve(1, in, out);
        out.close();
    }

    static class B_NestingDepth {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                char[] s = in.next().toCharArray();
                out.printf("Case #%d: %s\n", test, solve(s));
            }
        }

        private String solve(char[] s) {
            StringBuilder sb = new StringBuilder();
            int depth = 0;
            for (int i = 0; i <= s.length; i++) {
                int d = i < s.length ? s[i] - '0' : 0;
                while (depth < d) {
                    ++depth;
                    sb.append("(");
                }
                while (depth > d) {
                    --depth;
                    sb.append(")");
                }
                if (i < s.length) {
                    sb.append(s[i]);
                }
            }
            return sb.toString();
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

