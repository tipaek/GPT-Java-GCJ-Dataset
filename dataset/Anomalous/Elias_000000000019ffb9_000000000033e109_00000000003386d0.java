import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        try {
            new Solution().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean[][] memo;

    private void execute() throws IOException {
        FasterScanner sc = new FasterScanner(System.in);

        int numberOfTasks = sc.nextInt();
        for (int task = 1; task <= numberOfTasks; task++) {
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
                        long f = p2.y - p1.y;
                        long s = p2.x - p1.x;
                        long gcdValue = gcd(f, s);
                        f /= gcdValue;
                        s /= gcdValue;
                        long[] slope = new long[]{f, s};
                        boolean[] processed = new boolean[n];
                        processed[i] = true;
                        processed[j] = true;
                        int parallelCount = countParallelPairs(pairs, processed, n, slope);
                        result = Math.max(result, parallelCount + 2);
                    }
                }
            } else {
                result = n;
            }
            result = Math.min(result, n);

            System.out.println("Case #" + task + ": " + result);
        }

        sc.close();
    }

    private int countParallelPairs(Pair[] pairs, boolean[] processed, int n, long[] slope) {
        int count = 2;
        for (int i = 0; i < n; i++) {
            if (processed[i]) continue;
            for (int j = i + 1; j < n; j++) {
                Pair p1 = pairs[i];
                Pair p2 = pairs[j];
                long f = p2.y - p1.y;
                long s = p2.x - p1.x;
                long gcdValue = gcd(f, s);
                f /= gcdValue;
                s /= gcdValue;
                long[] currentSlope = new long[]{f, s};
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
        return b == 0 ? a : gcd(b, a % b);
    }

    static class Pair {
        long x, y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static class FasterScanner {
        private InputStream input;
        private byte[] buffer = new byte[1024];
        private int curChar, numChars;

        FasterScanner(InputStream input) {
            this.input = input;
        }

        int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = input.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[curChar++];
        }

        String nextLine() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        String nextString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        long nextLong() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = res * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sign;
        }

        int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = res * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sign;
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        void close() {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}