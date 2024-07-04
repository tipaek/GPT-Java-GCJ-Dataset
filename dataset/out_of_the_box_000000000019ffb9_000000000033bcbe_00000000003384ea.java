import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author out_of_the_box
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        IncrementalHouseOfPancakes solver = new IncrementalHouseOfPancakes();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class IncrementalHouseOfPancakes {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long l = in.nextLong();
            long r = in.nextLong();
            long ans;
            if (l >= r) {
                long diff = l - r;
                long init = getMaxN(1, 1, diff);
                l -= getAPSum(1, 1, init);
                if (l >= r) {
                    long p = getMaxN(init + 1, 2, l);
                    long q = getMaxN(init + 2, 2, r);
                    if (p <= q) {
                        ans = init + 2 * p;
                        l -= getAPSum(init + 1, 2, p);
                        r -= getAPSum(init + 2, 2, p);
                    } else {
                        ans = init + 2 * q + 1L;
                        l -= getAPSum(init + 1, 2, q + 1);
                        r -= getAPSum(init + 2, 2, q);
                    }
                } else {
                    long p = getMaxN(init + 1, 2, r);
                    long q = getMaxN(init + 2, 2, l);
                    if (p <= q) {
                        ans = init + 2 * p;
                        r -= getAPSum(init + 1, 2, p);
                        l -= getAPSum(init + 2, 2, p);
                    } else {
                        ans = init + 2 * q + 1L;
                        r -= getAPSum(init + 1, 2, q + 1);
                        l -= getAPSum(init + 2, 2, q);
                    }
                }
            } else {
                long diff = r - l;
                long init = getMaxN(1, 1, diff);
                r -= getAPSum(1, 1, init);
                if (l >= r) {
                    long p = getMaxN(init + 1, 2, l);
                    long q = getMaxN(init + 2, 2, r);
                    if (p <= q) {
                        ans = init + 2 * p;
                        l -= getAPSum(init + 1, 2, p);
                        r -= getAPSum(init + 2, 2, p);
                    } else {
                        ans = init + 2 * q + 1L;
                        l -= getAPSum(init + 1, 2, q + 1);
                        r -= getAPSum(init + 2, 2, q);
                    }
                } else {
                    long p = getMaxN(init + 1, 2, r);
                    long q = getMaxN(init + 2, 2, l);
                    if (p <= q) {
                        ans = init + 2 * p;
                        r -= getAPSum(init + 1, 2, p);
                        l -= getAPSum(init + 2, 2, p);
                    } else {
                        ans = init + 2 * q + 1L;
                        r -= getAPSum(init + 1, 2, q + 1);
                        l -= getAPSum(init + 2, 2, q);
                    }
                }
            }

            out.println(String.format("Case #%d: %d %d %d", testNumber, ans, l, r));
        }

        private long getMaxN(long a, long d, long v) {
            long A = d;
            long B = 2L * a - d;
            long C = -2L * v;
            double deter = Math.sqrt(B * B - 4.0 * A * C);
            double ans = (-1L * B + deter) / (2.0 * A);
            return (long) ans;
//        long maxN = 5L;//TODO
//        return BinarySearch.searchLastZero(1L, maxN, n -> (getAPSum(a,d,n) > v));
        }

        private long getAPSum(long a, long d, long n) {
            return (n * (2L * a + (n - 1L) * d)) / 2L;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
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
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return nextString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

