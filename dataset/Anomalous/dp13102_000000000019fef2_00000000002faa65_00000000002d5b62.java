import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public final class Solution {

    public static void main(final String[] args) {
        try (PrintWriter pw = new PrintWriter(System.out, false)) {
            final FastScanner sc = new FastScanner();
            final int t = sc.nextInt();
            for (int ii = 0; ii < t; ii++) {
                long x = sc.nextInt();
                long y = sc.nextInt();
                long ax = Math.abs(x);
                long ay = Math.abs(y);
                long s = Long.highestOneBit(ax + ay);
                if ((ax % 2 == ay % 2)) {
                    pw.println("Case #" + (ii + 1) + ": IMPOSSIBLE");
                    continue;
                }
                final StringBuilder sb = new StringBuilder();
                while (s != 0) {
                    if (ax >= ay) {
                        if (x > 0) {
                            x -= s;
                            sb.append("E");
                        } else {
                            x += s;
                            sb.append("W");
                        }
                    } else {
                        if (y > 0) {
                            y -= s;
                            sb.append("N");
                        } else {
                            y += s;
                            sb.append("S");
                        }
                    }
                    ax = Math.abs(x);
                    ay = Math.abs(y);
                    s >>= 1;
                }
                pw.println("Case #" + (ii + 1) + ": " + (x == 0 && y == 0 ? sb.reverse() : "IMPOSSIBLE"));
            }
        }
    }

    private static final class FastScanner {
        private final InputStream is = System.in;
        private final byte[] buf = new byte[8192];
        private int curChar;
        private int numChars;

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = is.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String nextString() {
            int c;
            while (isSpaceChar(c = read())) {
                // Skip spaces
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
            } while (!isSpaceChar(c = read()));
            return res.toString();
        }

        public int nextInt() {
            int c;
            while (isSpaceChar(c = read())) {
                // Skip spaces
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            int res = 0;
            do {
                res = res * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return negative ? -res : res;
        }

        public long nextLong() {
            int c;
            while (isSpaceChar(c = read())) {
                // Skip spaces
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            do {
                res = res * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return negative ? -res : res;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}