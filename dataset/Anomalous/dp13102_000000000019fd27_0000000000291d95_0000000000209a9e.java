import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;

public final class Solution {
    public static void main(final String[] args) {
        try (PrintWriter pw = new PrintWriter(System.out, false)) {
            final FastScanner sc = new FastScanner();
            final int t = sc.nextInt();
            final int b = sc.nextInt();
            for (int ii = 0; ii < t; ii++) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < b; i++) {
                    pw.println(i);
                    pw.flush();
                    sb.append(sc.nextLine());
                }
                pw.println(sb);
                pw.flush();
                if ("N".equals(sc.nextLine())) {
                    break;
                }
            }
        }
    }

    private static final class Point {
        public final int x, y;

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
            return 31 * x + y;
        }
    }

    private static final class FastScanner {
        private final InputStream is = System.in;
        private final byte[] buf = new byte[8192];
        private int curChar, numChars;

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = is.read(buf);
                } catch (final IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c;
            while (isSpaceChar(c = read())) {}
            final StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
            } while (!isEndOfLine(c = read()));
            return res.toString();
        }

        public String nextString() {
            int c;
            while (isSpaceChar(c = read())) {}
            final StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
            } while (!isSpaceChar(c = read()));
            return res.toString();
        }

        public long nextLong() {
            int c;
            while (isSpaceChar(c = read())) {}
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
            while (isSpaceChar(c = read())) {}
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
            return new BigInteger(nextString());
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(nextString());
        }

        public int[] nextArray(final int n) {
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(final int n) {
            final long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        public char[] nextCharArray(final int n) {
            final char[] arr = new char[n];
            int c, index = 0;
            while (isSpaceChar(c = read())) {}
            while (index < n && !isSpaceChar(c)) {
                arr[index++] = (char) c;
                c = read();
            }
            return index == n ? arr : Arrays.copyOf(arr, index);
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