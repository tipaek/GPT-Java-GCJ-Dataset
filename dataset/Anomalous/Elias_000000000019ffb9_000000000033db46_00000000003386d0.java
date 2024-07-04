import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        try {
            new Solution();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean[][] memo;

    public Solution() throws IOException {
        FasterScanner sc = new FasterScanner(System.in);

        int taskCount = sc.nextInt();
        for (int task = 1; task <= taskCount; task++) {
            int n = sc.nextInt();
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                pairs[i] = new Pair(x, y);
            }
            int result = 4;
            memo = new boolean[n][n];
            if (n > 4) {
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (memo[i][j]) continue;
                        memo[i][j] = true;
                        Pair p1 = pairs[i];
                        Pair p2 = pairs[j];
                        long deltaY = p2.y - p1.y;
                        long deltaX = p2.x - p1.x;
                        long gcdValue = gcd(deltaY, deltaX);
                        deltaY /= gcdValue;
                        deltaX /= gcdValue;
                        long[] slope = new long[]{deltaY, deltaX};
                        boolean[] processed = new boolean[n];
                        processed[i] = true;
                        processed[j] = true;
                        int collinearCount = countCollinear(pairs, processed, n, slope);
                        result = Math.max(result, collinearCount + 2);
                    }
                }
            } else {
                result = n;
            }
            result = Math.min(result, n);

            System.out.printf("Case #%d: %d%n", task, result);
        }

        sc.close();
    }

    private int countCollinear(Pair[] pairs, boolean[] processed, int n, long[] slope) {
        int count = 2;
        for (int i = 0; i < n; i++) {
            if (processed[i]) continue;
            for (int j = i + 1; j < n; j++) {
                if (processed[j]) continue;
                Pair p1 = pairs[i];
                Pair p2 = pairs[j];
                long deltaY = p2.y - p1.y;
                long deltaX = p2.x - p1.x;
                long gcdValue = gcd(deltaY, deltaX);
                deltaY /= gcdValue;
                deltaX /= gcdValue;
                long[] currentSlope = new long[]{deltaY, deltaX};
                if (slope[0] * currentSlope[1] == slope[1] * currentSlope[0]) {
                    memo[i][j] = true;
                    processed[i] = true;
                    processed[j] = true;
                    count += 2;
                }
            }
        }
        return count;
    }

    private long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    class Pair {
        long x, y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public class FasterScanner {
        private InputStream is;
        private byte[] buffer = new byte[1024];
        private int curChar;
        private int numChars;

        public FasterScanner(InputStream is) {
            this.is = is;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buffer[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public void close() {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}