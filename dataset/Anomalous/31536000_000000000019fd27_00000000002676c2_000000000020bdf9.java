import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        new Solution().solve();
    }

    private static class Range {
        final int start, end, index;

        public Range(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public void solve() {
        FastScanner scanner = new FastScanner();
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.print("Case #" + testCase + ": ");
            int n = scanner.nextInt();
            Range[] ranges = new Range[n];
            for (int i = 0; i < n; i++) {
                ranges[i] = new Range(scanner.nextInt(), scanner.nextInt(), i);
            }
            Arrays.sort(ranges, (a, b) -> Integer.compare(a.start, b.start));

            char[] result = new char[n];
            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (Range range : ranges) {
                if (cEnd <= jEnd) {
                    if (jEnd <= range.start) {
                        jEnd = range.end;
                        result[range.index] = 'J';
                    } else if (cEnd <= range.start) {
                        cEnd = range.end;
                        result[range.index] = 'C';
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    if (cEnd <= range.start) {
                        cEnd = range.end;
                        result[range.index] = 'C';
                    } else if (jEnd <= range.start) {
                        jEnd = range.end;
                        result[range.index] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                System.out.println(new String(result));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static class FastScanner {
        private final java.io.InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int pointer = 0;
        private int bufferLength = 0;

        private boolean hasNextByte() {
            if (pointer < bufferLength) return true;
            pointer = 0;
            try {
                bufferLength = in.read(buffer);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return bufferLength > 0;
        }

        private int readByte() {
            return hasNextByte() ? buffer[pointer++] : -1;
        }

        private static boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[pointer])) pointer++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public long nextLong() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            long n = 0;
            boolean negative = false;
            int b = readByte();
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            while (true) {
                if ('0' <= b && b <= '9') {
                    n = n * 10 + (b - '0');
                } else if (b == -1 || !isPrintableChar(b)) {
                    return negative ? -n : n;
                } else {
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }

        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
            return (int) nl;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}