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
            for (int ii = 0; ii < t; ii++) {
                final int n = sc.nextInt();
                final int k = sc.nextInt();
                handleCase(pw, ii, n, k);
            }
        }
    }

    private static void handleCase(PrintWriter pw, int caseNumber, int n, int k) {
        pw.print("Case #" + (caseNumber + 1) + ": ");
        switch (n) {
            case 2:
                handleCaseFor2(pw, k);
                break;
            case 3:
                handleCaseFor3(pw, k);
                break;
            case 4:
                handleCaseFor4(pw, k);
                break;
            default:
                handleCaseForDefault(pw, k);
        }
    }

    private static void handleCaseFor2(PrintWriter pw, int k) {
        switch (k) {
            case 2:
                pw.println("POSSIBLE");
                pw.println("1 2");
                pw.println("2 1");
                break;
            case 4:
                pw.println("POSSIBLE");
                pw.println("2 1");
                pw.println("1 2");
                break;
            default:
                pw.println("IMPOSSIBLE");
        }
    }

    private static void handleCaseFor3(PrintWriter pw, int k) {
        switch (k) {
            case 3:
                pw.println("POSSIBLE");
                pw.println("1 2 3");
                pw.println("3 1 2");
                pw.println("2 3 1");
                break;
            case 6:
                pw.println("POSSIBLE");
                pw.println("2 1 3");
                pw.println("3 2 1");
                pw.println("1 3 2");
                break;
            case 9:
                pw.println("POSSIBLE");
                pw.println("3 2 1");
                pw.println("1 3 2");
                pw.println("2 1 3");
                break;
            default:
                pw.println("IMPOSSIBLE");
        }
    }

    private static void handleCaseFor4(PrintWriter pw, int k) {
        switch (k) {
            case 4:
                pw.println("POSSIBLE");
                pw.println("1 2 3 4");
                pw.println("2 1 4 3");
                pw.println("3 4 1 2");
                pw.println("4 3 2 1");
                break;
            case 8:
                pw.println("POSSIBLE");
                pw.println("2 1 4 3");
                pw.println("1 2 3 4");
                pw.println("4 3 2 1");
                pw.println("3 4 1 2");
                break;
            case 10:
                pw.println("POSSIBLE");
                pw.println("1 2 3 4");
                pw.println("3 4 1 2");
                pw.println("4 3 2 1");
                pw.println("2 1 4 3");
                break;
            case 12:
                pw.println("POSSIBLE");
                pw.println("3 4 1 2");
                pw.println("4 3 2 1");
                pw.println("1 2 3 4");
                pw.println("2 1 4 3");
                break;
            case 16:
                pw.println("POSSIBLE");
                pw.println("4 3 2 1");
                pw.println("3 4 1 2");
                pw.println("2 1 4 3");
                pw.println("1 2 3 4");
                break;
            default:
                pw.println("IMPOSSIBLE");
        }
    }

    private static void handleCaseForDefault(PrintWriter pw, int k) {
        switch (k) {
            case 5:
                pw.println("POSSIBLE");
                pw.println("1 2 3 4 5");
                pw.println("5 1 2 3 4");
                pw.println("4 5 1 2 3");
                pw.println("3 4 5 1 2");
                pw.println("2 3 4 5 1");
                break;
            case 10:
                pw.println("POSSIBLE");
                pw.println("2 1 5 4 3");
                pw.println("3 2 1 5 4");
                pw.println("4 3 2 1 5");
                pw.println("5 4 3 2 1");
                pw.println("1 5 4 3 2");
                break;
            case 15:
                pw.println("POSSIBLE");
                pw.println("5 4 3 2 1");
                pw.println("4 3 2 1 5");
                pw.println("3 2 1 5 4");
                pw.println("2 1 5 4 3");
                pw.println("1 5 4 3 2");
                break;
            case 20:
                pw.println("POSSIBLE");
                pw.println("4 3 2 1 5");
                pw.println("5 4 3 2 1");
                pw.println("1 5 4 3 2");
                pw.println("2 1 5 4 3");
                pw.println("3 2 1 5 4");
                break;
            case 25:
                pw.println("POSSIBLE");
                pw.println("5 4 3 2 1");
                pw.println("1 5 4 3 2");
                pw.println("2 1 5 4 3");
                pw.println("3 2 1 5 4");
                pw.println("4 3 2 1 5");
                break;
            default:
                pw.println("IMPOSSIBLE");
        }
    }

    private static final class P {
        public final int x;
        public final int y;

        public P(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj instanceof P) {
                final P pt = (P) obj;
                return this.x == pt.x && this.y == pt.y;
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            long bits = java.lang.Double.doubleToLongBits(this.x);
            bits ^= java.lang.Double.doubleToLongBits(this.y) * 31;
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
            boolean f = true;
            if (c == '-') {
                f = false;
                c = read();
            }
            long res = 0;
            do {
                res = res * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return f ? res : -res;
        }

        public int nextInt() {
            int c;
            while (isSpaceChar(c = read())) {
            }
            boolean f = true;
            if (c == '-') {
                f = false;
                c = read();
            }
            int res = 0;
            do {
                res = res * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return f ? res : -res;
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