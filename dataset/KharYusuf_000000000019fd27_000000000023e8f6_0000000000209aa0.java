import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author KharYusuf
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Indicium solver = new Indicium();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Indicium {
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int n = s.nextInt(), k = s.nextInt();
            w.print("Case #" + testNumber + ": ");
            if (k % n != 0) {
                w.println("IMPOSSIBLE");
                return;
            }
            int[] vals = new int[n - 1];
            int dia = k / n, cur = 0;
            int[][] ans = new int[n][n];
            for (int i = 0; i < n; i++) ans[i][i] = dia;
            for (int i = 0; i < n; i++) if (i + 1 != dia) vals[cur++] = i + 1;
            cur = 0;
            for (int i = -n + 1; i < n; i++) {
                if (i == 0) continue;
                if (i < 0) {
                    int y = -i, x = 0;
                    while (y < n)
                        ans[x++][y++] = vals[cur];
                } else {
                    int y = 0, x = i;
                    while (x < n)
                        ans[x++][y++] = vals[cur];
                }
                cur++;
                if (cur == n - 1) cur = 0;
            }
            w.println("POSSIBLE");
            for (int[] i : ans) {
                for (int j : i) w.print(j + " ");
                w.println();
            }
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {

            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {

                curChar = 0;

                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }

            return buf[curChar++];
        }

        public int nextInt() {

            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();

                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public String next() {

            int c = read();

            while (isSpaceChar(c))
                c = read();

            StringBuilder res = new StringBuilder();

            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {

            if (filter != null)
                return filter.isSpaceChar(c);

            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

