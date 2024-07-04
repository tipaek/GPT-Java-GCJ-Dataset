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
            final Map<String, String> map = new HashMap<>();
            final List<String> list = new ArrayList<>();
            final Set<String> set = new HashSet<>();
            final StringBuilder builder = new StringBuilder();
            final long x = sc.nextInt();
            final long y = sc.nextInt();
            outerLoop: for (int ii = 0; ii < t; ii++) {
                for (int i = -5; i <= 5; i++) {
                    for (int j = -5; j <= 5; j++) {
                        pw.println(i + " " + j);
                        pw.flush();
                        if ("CENTER".equals(sc.nextLine())) {
                            continue outerLoop;
                        }
                    }
                }
                break;
            }
        }
    }

    private static boolean isOdd(final long i) {
        return (i & 1) != 0;
    }

    private static final class Point {
        public final int x;
        public final int y;
        public int z;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj instanceof Point) {
                final Point pt = (Point) obj;
                return this.x == pt.x && this.y == pt.y;
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            long bits = Double.doubleToLongBits(this.x);
            bits ^= Double.doubleToLongBits(this.y) * 31;
            return (int) bits ^ (int) (bits >> 32);
        }
    }

    private static final class FastScanner {
        private final InputStream is = System.in;
        private final byte[] buf = new byte[8192];
        private int curChar;
        private int numChars;

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            }
            if (this.curChar >= this.numChars) {
                this.curChar = 0;
                try {
                    this.numChars = this.is.read(this.buf);
                } catch (final IOException e) {
                    throw new InputMismatchException();
                }
                if (this.numChars <= 0) {
                    return -1;
                }
            }
            return this.buf[this.curChar++];
        }

        public String nextLine() {
            int c;
            while (isSpaceChar(c = read())) {
            }
            final StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
            } while (!isEndOfLine(c = read()));
            return res.toString();
        }

        public String nextString() {
            int c;
            while (isSpaceChar(c = read())) {
            }
            final StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
            } while (!isSpaceChar(c = read()));
            return res.toString();
        }

        public long nextLong() {
            int c;
            while (isSpaceChar(c = read())) {
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

        public int nextInt() {
            int c;
            while (isSpaceChar(c = read())) {
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

        public double nextDouble() {
            return Double.parseDouble(nextString());
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(nextString(), 10);
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(nextString());
        }

        public int[] nextArray(final int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public long[] nextLongArray(final int n) {
            final long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        public char[] nextCharArray(final int n) {
            final char[] bf = new char[n];
            int b, p = 0;
            while (isSpaceChar(b = read())) {
            }
            while (p < n && !isSpaceChar(b)) {
                bf[p++] = (char) b;
                b = read();
            }
            return n == p ? bf : Arrays.copyOf(bf, p);
        }

        public char[][] nextMatrix(final int n, final int m) {
            final char[][] map = new char[n][];
            for (int i = 0; i < n; i++) {
                map[i] = nextCharArray(m);
            }
            return map;
        }

        public int[][] nextIntMatrix(final int n, final int m) {
            final int[][] map = new int[n][];
            for (int i = 0; i < n; i++) {
                map[i] = nextArray(m);
            }
            return map;
        }

        public long[][] nextLongMatrix(final int n, final int m) {
            final long[][] map = new long[n][];
            for (int i = 0; i < n; i++) {
                map[i] = nextLongArray(m);
            }
            return map;
        }

        public boolean isSpaceChar(final int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(final int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}