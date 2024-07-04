import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public final class Solution {

    public static void main(final String[] args) {
        try (PrintWriter pw = new PrintWriter(System.out, false)) {
            final FastScanner sc = new FastScanner();
            final int t = sc.nextInt();
            for (int ii = 0; ii < t; ii++) {
                final int n = sc.nextInt();
                final Interval[] intervals = new Interval[n];
                final Map<Interval, Integer> indexMap = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    intervals[i] = new Interval(sc.nextInt(), sc.nextInt());
                    indexMap.put(intervals[i], i);
                }
                Arrays.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
                
                final StringBuilder result = new StringBuilder();
                Interval c = new Interval(-1, -1);
                Interval j = new Interval(-1, -1);
                result.append('C');
                c = intervals[0];
                
                for (int i = 1; i < n; i++) {
                    Interval current = intervals[i];
                    if (current.start < c.end) {
                        if (current.start < j.end) {
                            result.setLength(0);
                            result.append("IMPOSSIBLE");
                            break;
                        }
                        j = current;
                        result.append('J');
                    } else {
                        c = current;
                        result.append('C');
                    }
                }
                
                if (!"IMPOSSIBLE".equals(result.toString())) {
                    final String assignments = result.toString();
                    for (int i = 0; i < n; i++) {
                        Interval interval = intervals[i];
                        int originalIndex = indexMap.get(interval);
                        result.replace(originalIndex, originalIndex + 1, assignments.charAt(i) + "");
                    }
                }
                
                pw.println("Case #" + (ii + 1) + ": " + result);
            }
        }
    }

    private static final class Interval {
        public final int start;
        public final int end;

        public Interval(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + this.start + ", " + this.end + ")";
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj instanceof Interval) {
                final Interval other = (Interval) obj;
                return this.start == other.start && this.end == other.end;
            }
            return false;
        }

        @Override
        public int hashCode() {
            long bits = java.lang.Double.doubleToLongBits(this.start);
            bits ^= java.lang.Double.doubleToLongBits(this.end) * 31;
            return (int) bits ^ (int) (bits >> 32);
        }
    }

    private static final class FastScanner {
        private final InputStream is = System.in;
        private final byte[] buffer = new byte[8192];
        private int currentChar;
        private int numChars;

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            }
            if (this.currentChar >= this.numChars) {
                this.currentChar = 0;
                try {
                    this.numChars = this.is.read(this.buffer);
                } catch (final IOException e) {
                    throw new InputMismatchException();
                }
                if (this.numChars <= 0) {
                    return -1;
                }
            }
            return this.buffer[this.currentChar++];
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
            long result = 0;
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return negative ? -result : result;
        }

        public int nextInt() {
            int c;
            while (isSpaceChar(c = read())) {}
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            int result = 0;
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return negative ? -result : result;
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
            final char[] array = new char[n];
            int c, index = 0;
            while (isSpaceChar(c = read())) {}
            while (index < n && !isSpaceChar(c)) {
                array[index++] = (char) c;
                c = read();
            }
            return n == index ? array : Arrays.copyOf(array, index);
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