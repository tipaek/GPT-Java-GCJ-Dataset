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
            final StringBuilder sb = new StringBuilder();
            final long x = sc.nextInt();
            final long y = sc.nextInt();

            outerLoop:
            for (int test = 0; test < t; test++) {
                for (int i = -10; i <= 10; i++) {
                    for (int j = -10; j <= 10; j++) {
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

    private static boolean isOdd(final long number) {
        return (number & 1) != 0;
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
            return "(" + x + ", " + y + ")";
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            final Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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
                } catch (final IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c;
            while (isSpaceChar(c = read())) {
                // Skip whitespace
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
                // Skip whitespace
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
                // Skip whitespace
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
                // Skip whitespace
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
            final int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        public char[] nextCharArray(final int n) {
            final char[] buffer = new char[n];
            int b, p = 0;
            while (isSpaceChar(b = read())) {
                // Skip whitespace
            }
            while (p < n && !isSpaceChar(b)) {
                buffer[p++] = (char) b;
                b = read();
            }
            return n == p ? buffer : Arrays.copyOf(buffer, p);
        }

        public char[][] nextMatrix(final int n, final int m) {
            final char[][] matrix = new char[n][];
            for (int i = 0; i < n; i++) {
                matrix[i] = nextCharArray(m);
            }
            return matrix;
        }

        public int[][] nextIntMatrix(final int n, final int m) {
            final int[][] matrix = new int[n][];
            for (int i = 0; i < n; i++) {
                matrix[i] = nextArray(m);
            }
            return matrix;
        }

        public long[][] nextLongMatrix(final int n, final int m) {
            final long[][] matrix = new long[n][];
            for (int i = 0; i < n; i++) {
                matrix[i] = nextLongArray(m);
            }
            return matrix;
        }

        public boolean isSpaceChar(final int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(final int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}