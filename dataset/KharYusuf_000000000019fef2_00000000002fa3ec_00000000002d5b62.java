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
        Expogo solver = new Expogo();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Expogo {
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int x = s.nextInt(), y = s.nextInt();
            char[] c = {'E', 'W', 'S', 'N'};
            int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
            if (x == 0 && y == 0) {
                w.println("Case #" + testNumber + ": ");
                return;
            }
            if ((x & 1) == (y & 1)) {
                w.println("Case #" + testNumber + ": IMPOSSIBLE");
                return;
            }
            for (int i = 1; i <= 9; i++) {
                int tot = (int) Math.pow(4, i);
                int[][] a = new int[tot][i];
                for (int j = 0, cur = 1; j < i; j++, cur *= 4)
                    for (int k = 0; k < tot; k++)
                        a[k][j] = (k / cur) % 4;
                char[] ans = new char[i];
                for (int j = 0; j < tot; j++) {
                    int cx = 0, cy = 0;
                    for (int k = 0; k < i; k++) {
                        cx += (1 << k) * dx[a[j][k]];
                        cy += (1 << k) * dy[a[j][k]];
                        ans[k] = c[a[j][k]];
                    }
                    if (cx == x && cy == y) {
                        w.print("Case #" + testNumber + ": ");
                        w.println(ans);
                        return;
                    }
                }
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

