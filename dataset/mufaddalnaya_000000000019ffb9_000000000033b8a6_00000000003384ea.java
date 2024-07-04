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
 * @author Mufaddal Naya
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        IncrementalHouseOfPancakes solver = new IncrementalHouseOfPancakes();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class IncrementalHouseOfPancakes {
        public void solve(int testNumber, InputReader c, OutputWriter w) {
            long l = c.readLong(), r = c.readLong();
            long diff = Math.max(l, r) - Math.min(l, r);
            long vl = 0, vr = (long) 1e9;
            long n = 0;
            while (vl <= vr) {
                long mid = vl + vr >> 1;
                if (get(mid) <= diff) {
                    n = mid;
                    vl = mid + 1;
                } else {
                    vr = mid - 1;
                }
            }
            if (l > r) {
                l -= get(n);
            } else {
                r -= get(n);
            }

            vl = 0;
            vr = (long) 1e9;

//        w.printLine(n);
            long cur = 0;
            while (vl <= vr) {
                long mid = vl + vr >> 1;
                if (pos(mid, l, r, n)) {
                    cur = mid;
                    vl = mid + 1;
                } else {
                    vr = mid - 1;
                }
            }
//        w.printLine(cur);
//        w.printLine(n,cur,l,r);
            long nn = n + cur * 2;
            if (r > l) {
                if (n % 2 == 0) {
                    r -= (get(n / 2 + cur) - get(n / 2)) * 2 - cur;
                    l -= ((get(n / 2 + cur) - get(n / 2)) * 2);
//                l -=
                } else {
                    l -= (get(n / 2 + cur) - get(n / 2)) * 2 + cur;
                    r -= ((get(n / 2 + cur) - get(n / 2)) * 2);
                }
                if (r >= nn + 1) {
                    r -= nn + 1;
                    nn++;
                }
            } else {
                if (n % 2 == 0) {
                    l -= (get(n / 2 + cur) - get(n / 2)) * 2 - cur;
                    r -= ((get(n / 2 + cur) - get(n / 2)) * 2);
//                l -=
                } else {
                    r -= (get(n / 2 + cur) - get(n / 2)) * 2 + cur;
                    l -= ((get(n / 2 + cur) - get(n / 2)) * 2);
                }
                if (l >= nn + 1) {
                    l -= nn + 1;
                    nn++;
                }
            }
            w.printLine("Case #" + testNumber + ":", nn, l, r);


        }

        private boolean pos(long x, long l, long r, long n) {

            if (l < r) {
                pos(x, r, l, n);
            }

            if (n % 2 == 0) {

                if (r < (get(n / 2 + x) - get(n / 2)) * 2) {
                    return false;
                }
                if (l < (get(n / 2 + x) - get(n / 2)) * 2 - x) {
                    return false;
                }

            } else {
                if (l < (get(n / 2 + x) - get(n / 2)) * 2) {
                    return false;
                }
                if (r < (get(n / 2 + x) - get(n / 2)) * 2 + x) {
                    return false;
                }
            }

            return true;
        }

        private long get(long mid) {
            return mid * (mid + 1) / 2;
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

        public long readLong() {
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

        public String readString() {
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
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

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

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

