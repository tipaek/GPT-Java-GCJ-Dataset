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
        PascalWalk solver = new PascalWalk();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PascalWalk {
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int n = s.nextInt(), b = func.log2(n), left = 0;
            if ((n & (n + 1)) != 0) {
                left = n - (1 << b) + 1;
                b--;
            }
            int cur = 1;
            w.println("Case #" + testNumber + ": ");
            for (int i = 0; i <= b; i++) {
                if ((i & 1) == 0) for (int j = 1; j <= cur; j++) w.println(i + 1 + " " + j);
                else for (int j = cur; j >= 1; j--) w.println(i + 1 + " " + j);
                cur++;
            }
            if ((b & 1) == 0) for (int i = 0; i < left; i++) w.println(i + b + 2 + " " + (cur++));
            else for (int i = 0; i < left; i++) w.println(i + b + 2 + " " + 1);
        }

    }

    static class func {
        public static int log2(long a) {
            int cnt = -1;
            while (a > 0) {
                a >>= 1;
                cnt++;
            }
            return cnt;
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

