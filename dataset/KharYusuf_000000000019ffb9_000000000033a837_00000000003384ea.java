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
        IncrementalHouseOfPancakes solver = new IncrementalHouseOfPancakes();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class IncrementalHouseOfPancakes {
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            long l = s.nextLong(), r = s.nextLong();
            long ans = 0;
            if (l > r) {
                long u = 1, d = (int) 2e9;
                while (u <= d) {
                    long mid = u + d >> 1;
                    if ((mid * (mid + 1) >> 1) <= l - r) u = mid + 1;
                    else d = mid - 1;
                }
                --u;
                l -= u * (u + 1) >> 1;
                ans = u;
            } else if (r > l) {
                long u = 1, d = (int) 2e9;
                while (u <= d) {
                    long mid = u + d >> 1;
                    if ((mid * (mid + 1) >> 1) <= r - l) u = mid + 1;
                    else d = mid - 1;
                }
                --u;
                r -= u * (u + 1) >> 1;
                ans = u;
            }
            //w.println(ans+" "+l+" "+r);
            if (l >= r) {
                long u1 = 1, d1 = (int) 2e9;
                while (u1 <= d1) {
                    long mid = u1 + d1 >> 1;
                    if (sum(ans + 1, mid) <= l) u1 = mid + 1;
                    else d1 = mid - 1;
                }
                long u2 = 1, d2 = (int) 2e9;
                while (u2 <= d2) {
                    long mid = u2 + d2 >> 1;
                    if (sum(ans + 2, mid) <= r) u2 = mid + 1;
                    else d2 = mid - 1;
                }
                u1--;
                u2--;
                if (u1 > u2) {
                    u1 = u2 + 1;
                }
                l -= sum(ans + 1, u1);
                r -= sum(ans + 2, u2);
                ans += u1 + u2;
            } else {
                long u2 = 1, d2 = (int) 1e9;
                while (u2 <= d2) {
                    long mid = u2 + d2 >> 1;
                    if (sum(ans + 1, mid) <= r) u2 = mid + 1;
                    else d2 = mid - 1;
                }
                long u1 = 1, d1 = (int) 1e9;
                while (u1 <= d1) {
                    long mid = u1 + d1 >> 1;
                    if (sum(ans + 2, mid) <= l) u1 = mid + 1;
                    else d1 = mid - 1;
                }
                u1--;
                u2--;
                if (u2 > u1) {
                    u2 = u1 + 1;
                }
                l -= sum(ans + 2, u1);
                r -= sum(ans + 1, u2);
                //w.println(u1+" "+u2);
                ans += u1 + u2;
            }
            w.println("Case #" + testNumber + ": " + ans + " " + l + " " + r);
        }

        long sum(long st, long n) {
            if (Long.MAX_VALUE / (double) n < (st + (n - 1))) return Long.MAX_VALUE;
            return n * (st + n - 1);
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

        public long nextLong() {

            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            long res = 0;

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

