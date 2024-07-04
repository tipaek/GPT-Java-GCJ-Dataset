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
                final Map<Long, Long> frequencyMap = Arrays.stream(a).boxed()
                        .collect(Collectors.groupingBy(Long::valueOf, Collectors.counting()));
                final long maxFrequency = Collections.max(frequencyMap.values());

                long result = calculateMinimumOperations(a, d, frequencyMap, maxFrequency);
                pw.println("Case #" + (ii + 1) + ": " + result);
            }
        }
    }

    private static long calculateMinimumOperations(long[] a, int d, Map<Long, Long> frequencyMap, long maxFrequency) {
        if (d <= maxFrequency) {
            return 0;
        }
        if (d == 2) {
            return 1;
        }
        if (a.length == 1) {
            return d - 1;
        }

        List<Long> uniqueValues = new ArrayList<>(frequencyMap.keySet());
        uniqueValues.sort(Long::compareTo);

        List<Integer> operationCounts = new ArrayList<>();
        for (int i = 0; i < uniqueValues.size(); i++) {
            long currentValue = uniqueValues.get(i);
            long currentFrequency = frequencyMap.get(currentValue);
            int operations = 0;

            boolean found = false;
            for (int j = i + 1; j < uniqueValues.size(); j++) {
                long nextValue = uniqueValues.get(j);
                if (nextValue % currentValue == 0) {
                    long nextFrequency = frequencyMap.get(nextValue);
                    if (currentFrequency + nextValue / currentValue * nextFrequency >= d) {
                        operations += calculateOperations(d, currentFrequency, nextValue, currentValue, nextFrequency);
                        found = true;
                        break;
                    }
                    currentFrequency += nextValue / currentValue * nextFrequency;
                    operations += (nextValue / currentValue - 1) * nextFrequency;
                }
            }

            if (!found) {
                for (int j = i + 1; j < uniqueValues.size(); j++) {
                    long nextValue = uniqueValues.get(j);
                    if (nextValue % currentValue != 0) {
                        long nextFrequency = frequencyMap.get(nextValue);
                        if (currentFrequency + nextValue / currentValue * nextFrequency >= d) {
                            operations += calculateOperations(d, currentFrequency, nextValue, currentValue, nextFrequency);
                            found = true;
                            break;
                        }
                        currentFrequency += nextValue / currentValue * nextFrequency;
                        operations += nextValue / currentValue * nextFrequency;
                    }
                }
            }

            if (found) {
                operationCounts.add(operations);
            }
        }

        return Collections.min(operationCounts);
    }

    private static int calculateOperations(int d, long currentFrequency, long nextValue, long currentValue, long nextFrequency) {
        return (int) ((d - currentFrequency) / (nextValue / currentValue) * (nextValue / currentValue - 1) + (d - currentFrequency) % (nextValue / currentValue));
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

        public String nextLine() {
            int c;
            while (isSpaceChar(c = read())) {
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
            } while (!isEndOfLine(c = read()));
            return res.toString();
        }

        public String nextString() {
            int c;
            while (isSpaceChar(c = read())) {
            }
            StringBuilder res = new StringBuilder();
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