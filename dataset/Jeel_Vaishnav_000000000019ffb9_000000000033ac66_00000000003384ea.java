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
 * @author Jeel Vaishnav
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        IncrementalHouseOfPancakes solver = new IncrementalHouseOfPancakes();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class IncrementalHouseOfPancakes {
        long findPancakes(long start, long end) {
            if (end < start)
                return 0;
            long total = (end - start) / 2L + 1L;
            long ans = start * total + total * (total - 1L);
            return ans;
        }

        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            long l = sc.nextLong();
            long r = sc.nextLong();

            long already = 0;
            long maxLimit = (long) 2e9 + 5;

            long ansl = 0;
            long ansr = 0;

            if (l > r) {
                long start = 1, end = maxLimit;
                while (start <= end) {
                    long mid = (start + end) >> 1;

                    long pancakes = mid * (mid + 1L) / 2L;

                    if (pancakes > l) {
                        end = mid - 1;
                    } else if (l - pancakes >= r) {
                        already = mid;
                        start = mid + 1;
                    } else
                        end = mid - 1;
                }
                ansl += already * (already + 1L) / 2L;
            } else if (l < r) {
                long start = 1, end = maxLimit;
                while (start <= end) {
                    long mid = (start + end) >> 1;

                    long pancakes = mid * (mid + 1L) / 2L;

                    if (pancakes > r) {
                        end = mid - 1;
                    } else if (r - pancakes > l) {
                        already = mid;
                        start = mid + 1;
                    } else
                        end = mid - 1;
                }
                ansr += already * (already + 1L) / 2L;

                if (r - (already + 1L) >= 0) {
                    already++;
                    ansr += already;
                }
            }

            l -= ansl;
            r -= ansr;

            long start = already + 1L, end = maxLimit, poss = already;
            while (start <= end) {
                long mid = (start + end) >> 1;

                long lPancakes = findPancakes(already + 1L, mid);
                long rPancakes = findPancakes(already + 2L, mid);

                if (l - lPancakes >= 0 && r - rPancakes >= 0) {
                    poss = mid;
                    start = mid + 1L;
                } else
                    end = mid - 1L;
            }

            l -= findPancakes(already + 1L, poss);
            r -= findPancakes(already + 2L, poss);

            out.println("Case #" + testNumber + ": " + poss + " " + l + " " + r);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
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

        public String readString() {
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

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

