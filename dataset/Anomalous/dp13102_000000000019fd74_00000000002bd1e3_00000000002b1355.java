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
                final int c = sc.nextInt();
                final Set<Point> pointsSet = new HashSet<>();
                Point point;
                final Map<Point, Integer> pointMap = new HashMap<>();
                long totalSum = 0, currentSum = 0;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        point = new Point(i, j, sc.nextInt());
                        pointsSet.add(point);
                        currentSum += point.value;
                        pointMap.put(point, point.value);
                    }
                }
                totalSum = currentSum;
                while (true) {
                    final int setSize = pointsSet.size();
                    final Set<Point> toRemove = new HashSet<>();
                    for (final Point v : new HashSet<>(pointsSet)) {
                        int sum = 0, count = 0;
                        for (int i = v.x + 1; i < r; i++) {
                            if (pointsSet.contains(point = new Point(i, v.y))) {
                                sum += pointMap.get(point);
                                count++;
                                break;
                            }
                        }
                        for (int i = v.x - 1; i >= 0; i--) {
                            if (pointsSet.contains(point = new Point(i, v.y))) {
                                sum += pointMap.get(point);
                                count++;
                                break;
                            }
                        }
                        for (int i = v.y + 1; i < c; i++) {
                            if (pointsSet.contains(point = new Point(v.x, i))) {
                                sum += pointMap.get(point);
                                count++;
                                break;
                            }
                        }
                        for (int i = v.y - 1; i >= 0; i--) {
                            if (pointsSet.contains(point = new Point(v.x, i))) {
                                sum += pointMap.get(point);
                                count++;
                                break;
                            }
                        }
                        if (count != 0 && v.value < 1.0 * sum / count) {
                            currentSum -= v.value;
                            toRemove.add(v);
                        }
                    }
                    pointsSet.removeAll(toRemove);
                    totalSum += currentSum;
                    if (setSize == pointsSet.size()) {
                        totalSum -= currentSum;
                        break;
                    }
                }
                pw.println("Case #" + (ii + 1) + ": " + totalSum);
            }
        }
    }

    private static final class Point {
        public final int x;
        public final int y;
        public int value;

        public Point(final int x, final int y, final int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }

    private static final class FastScanner {
        private final InputStream is = System.in;
        private final byte[] buffer = new byte[8192];
        private int currentChar;
        private int numChars;

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            int c;
            while (isSpaceChar(c = read())) {}
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
            } while (!isEndOfLine(c = read()));
            return res.toString();
        }

        public String nextString() {
            int c;
            while (isSpaceChar(c = read())) {}
            StringBuilder res = new StringBuilder();
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
            return new BigInteger(nextString(), 10);
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
            int b, p = 0;
            while (isSpaceChar(b = read())) {}
            while (p < n && !isSpaceChar(b)) {
                arr[p++] = (char) b;
                b = read();
            }
            return n == p ? arr : Arrays.copyOf(arr, p);
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