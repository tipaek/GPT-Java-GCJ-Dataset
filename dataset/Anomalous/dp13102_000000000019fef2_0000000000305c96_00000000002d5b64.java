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
                final int r = sc.nextInt();
                final int s = sc.nextInt();
                final List<Integer> l = new ArrayList<>();
                final List<Integer> ll = new ArrayList<>();
                for (int i = 0; i < s; i++) {
                    for (int j = 0; j < r; j++) {
                        l.add(j + 1);
                    }
                }
                ll.addAll(l);
                Collections.sort(ll);
                final StringBuilder sb = new StringBuilder();
                int c = 0, x = r, y = 1, v = r;
                final int z = r * s;
                while (!ll.equals(l)) {
                    for (int i = z - 1; i >= 0; i--) {
                        int p = l.get(i);
                        if (p == x - 1) {
                            int b = p;
                            int a = i + 1 - b;
                            sb.append(a).append(" ").append(b).append("\n");
                            for (int j = b; j > 0; j--) {
                                l.remove(i);
                                l.add(0, j);
                            }
                            y++;
                            break;
                        }
                    }
                    if (y == s) {
                        y = 1;
                        v--;
                        x = v;
                    }
                    c++;
                }
                sb.deleteCharAt(sb.length() - 1);
                pw.println("Case #" + (ii + 1) + ": " + c + "\n" + sb);
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