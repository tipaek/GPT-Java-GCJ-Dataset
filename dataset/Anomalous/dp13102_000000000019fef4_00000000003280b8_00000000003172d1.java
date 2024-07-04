import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public final class Solution {

    public static void main(final String[] args) {
        try (PrintWriter pw = new PrintWriter(System.out, false)) {
            final FastScanner sc = new FastScanner();
            final int t = sc.nextInt();
            for (int ii = 0; ii < t; ii++) {
                final int n = sc.nextInt();
                final int d = sc.nextInt();
                final long[] a = sc.nextLongArray(n);
                final Map<Long, Long> m = Arrays.stream(a).boxed().collect(Collectors.groupingBy(Long::valueOf, Collectors.counting()));
                final long mx = m.values().stream().max(Long::compareTo).orElse(0L);
                long c = 0;
                if (d > mx) {
                    if (d == 2) {
                        c = 1;
                    } else {
                        if (a.length == 1) {
                            c = d - 1;
                        } else {
                            c = calculateMinOperations(d, m);
                        }
                    }
                }
                pw.println("Case #" + (ii + 1) + ": " + c);
            }
        }
    }

    private static long calculateMinOperations(int d, Map<Long, Long> m) {
        final List<Long> sl = new ArrayList<>(m.keySet());
        sl.sort(Long::compareTo);
        final List<Integer> l = new ArrayList<>();
        final int z = sl.size();
        for (int i = 0; i < z; i++) {
            final long p = sl.get(i);
            long x = m.get(p);
            int cx = 0;
            boolean f = false;
            for (int j = i + 1; j < z; j++) {
                long u = sl.get(j);
                if (u % p == 0) {
                    long v = m.get(u);
                    if (x + u / p * v >= d) {
                        cx += (d - x) / (u / p) * (u / p - 1) + (d - x) % (u / p);
                        f = true;
                        break;
                    }
                    x += u / p * v;
                    cx += (u / p - 1) * v;
                }
            }
            if (!f) {
                for (int j = i + 1; j < z; j++) {
                    long u = sl.get(j);
                    if (u % p != 0) {
                        long v = m.get(u);
                        if (x + u / p * v >= d) {
                            cx += (d - x) / (u / p) * (u / p) + (d - x) % (u / p);
                            f = true;
                            break;
                        }
                        x += u / p * v;
                        cx += u / p * v;
                    }
                }
            }
            if (f) {
                l.add(cx);
            }
        }
        return l.isEmpty() ? d - 1 : Collections.min(l);
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