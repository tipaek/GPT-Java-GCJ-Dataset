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
 * @author Sparsh Sanchorawala
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
        public void solve(int testNumber, InputReader s, PrintWriter w) {
            long l = s.nextLong(), r = s.nextLong();
            long done = 0;
            w.print("Case #" + testNumber + ": ");
            if (l >= r) {
                long left = 0, right = (long) 2e9;
                while (left <= right) {
                    long mid = (left + right) / 2;
                    long can = mid * (mid + 1) / 2;
                    if (l - can >= r) {
                        done = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                l -= done * (done + 1) / 2;

                long lval = 0;
                left = 0;
                right = (long) 2e9;
                while (left <= right) {
                    long mid = (left + right) / 2;
                    if (mid * mid + done * mid <= r) {
                        lval = mid;
                        left = mid + 1;
                    } else
                        right = mid - 1;
                }
                long rval = 0;
                left = 0;
                right = (long) 2e9;
                while (left <= right) {
                    long mid = (left + right) / 2;
                    if (mid * (mid + 1) + done * mid <= l) {
                        rval = mid;
                        left = mid + 1;
                    } else
                        right = mid - 1;
                }
                l -= lval * (lval + done);
                r -= rval * (rval + 1 + done);
                long v = Math.min(lval, rval);
                done += 2 * v;
                if (lval > rval)
                    done++;
            } else {
                long left = 0, right = (long) 2e9;
                while (left <= right) {
                    long mid = (left + right) / 2;
                    long can = mid * (mid + 1) / 2;
                    if (r - can > l) {
                        done = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                r -= done * (done + 1) / 2;

                long rval = 0;
                left = 0;
                right = (long) 2e9;
                while (left <= right) {
                    long mid = (left + right) / 2;
                    if (mid * mid + done * mid <= r) {
                        rval = mid;
                        left = mid + 1;
                    } else
                        right = mid - 1;
                }
                long lval = 0;
                left = 0;
                right = (long) 2e9;
                while (left <= right) {
                    long mid = (left + right) / 2;
                    if (mid * (mid + 1) + done * mid <= l) {
                        lval = mid;
                        left = mid + 1;
                    } else
                        right = mid - 1;
                }
                l -= lval * (lval + 1 + done);
                r -= rval * (rval + done);
                long v = Math.min(lval, rval);
                done += 2 * v;
                if (rval > lval)
                    done++;

            }
            w.println(done + " " + l + " " + r);
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

