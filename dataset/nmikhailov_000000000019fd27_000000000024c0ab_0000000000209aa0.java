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
 *
 * @author Nikita Mikhailov
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {

            int n = in.readInt();
            int k = in.readInt();

            if (k == (n + 1) * n / 2) {
                out.println("Case #" + testNumber + ": POSSIBLE");

                int ks = 2;
                if (n % 2 == 0) {
                    ks++;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int val = (n - i + j * ks) % n;
                        out.print((val + 1) + " ");
                    }
                    out.println();
                }

                return;
            }

            if (k % n != 0) {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
                return;
            }

            out.println("Case #" + testNumber + ": POSSIBLE");

            int st = k / n - 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int val = (st + i - j + 10 * n) % n;
                    out.print((val + 1) + " ");
                }
                out.println();
            }
        }

    }

    static class FastScanner {
        private StringTokenizer st;
        private BufferedReader in;

        public FastScanner(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String readToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(readToken());
        }

        public String next() {
            return readToken();
        }

    }
}

