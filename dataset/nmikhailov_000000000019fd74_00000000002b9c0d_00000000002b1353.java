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
        TaskB solver = new TaskB();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {

            int n = in.readInt();
            out.println("Case #" + testNumber + ": ");

            if (n > 1000) {
                return;
            }

            if (n < 3) {
                for (int i = 0; i < n; i++) {
                    out.println((i + 1) + " " + 1);
                }
            } else {
                int rest = n - 2;
                int nextC = 2;

                int row = 2, col = 2;

                out.println("1 1");
                out.println("2 2");

                while (nextC <= rest) {
                    row++;
                    out.println(row + " " + col);
                    rest -= nextC;
                    nextC += 1;
                }
                col--;
                while (rest > 0) {
                    out.println(row + " " + col);
                    rest -= nextC;
                    row++;
                }
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

