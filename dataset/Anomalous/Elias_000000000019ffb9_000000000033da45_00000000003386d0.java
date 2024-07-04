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
        FasterScanner scanner = new FasterScanner(System.in);
        int numberOfTasks = scanner.nextInt();

        for (int task = 1; task <= numberOfTasks; task++) {
            int n = scanner.nextInt();
            Pair[] pairs = new Pair[n];

            for (int i = 0; i < n; i++) {
                long x = scanner.nextLong();
                long y = scanner.nextLong();
                pairs[i] = new Pair(x, y);
            }

            int result = calculateMaxCollinearPoints(n, pairs);
            System.out.println("Case #" + task + ": " + result);
        }

        scanner.close();
    }

    private int calculateMaxCollinearPoints(int n, Pair[] pairs) {
        memo = new boolean[n][n];
        int result = 4;

        if (n <= 4) {
            return n;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (memo[i][j]) continue;
                memo[i][j] = true;

                Pair p1 = pairs[i];
                Pair p2 = pairs[j];
                long f = p2.y - p1.y;
                long s = p2.x - p1.x;
                long gcd = gcd(f, s);
                f /= gcd;
                s /= gcd;

                long[] slope = {f, s};
                boolean[] done = new boolean[n];
                done[i] = true;
                done[j] = true;

                int collinearCount = getCollinearPointsCount(pairs, done, n, slope);
                result = Math.max(result, collinearCount + 2);
            }
        }

        return Math.min(result, n);
    }

    private int getCollinearPointsCount(Pair[] pairs, boolean[] done, int n, long[] slope) {
        int count = 2;

        for (int i = 0; i < n; i++) {
            if (done[i]) continue;

            for (int j = i + 1; j < n; j++) {
                if (done[j]) continue;

                Pair p1 = pairs[i];
                Pair p2 = pairs[j];
                long f = p2.y - p1.y;
                long s = p2.x - p1.x;
                long gcd = gcd(f, s);
                f /= gcd;
                s /= gcd;

                long[] currentSlope = {f, s};
                if (slope[0] == currentSlope[0] && slope[1] == currentSlope[1]) {
                    memo[i][j] = true;
                    done[i] = true;
                    done[j] = true;
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

    public static class FasterScanner {
        private final InputStream input;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FasterScanner(InputStream input) {
            this.input = input;
        }

        private int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = input.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public void close() {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}