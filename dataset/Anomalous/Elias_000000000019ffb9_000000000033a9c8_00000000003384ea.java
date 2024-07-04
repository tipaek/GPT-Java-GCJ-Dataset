import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        new Solution();
    }

    public Solution() throws FileNotFoundException {
        FastScanner scanner = new FastScanner(System.in);

        int taskCount = scanner.nextInt();
        for (int task = 1; task <= taskCount; task++) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            long n = 0;

            long difference = Math.abs(l - r);
            long initialSteps = (long) Math.sqrt(2 * difference);
            n += initialSteps;
            long initialSum = initialSteps * (initialSteps + 1) / 2;

            if (l >= r) {
                l -= initialSum;
                if (l < 0) {
                    l += initialSteps;
                    n--;
                }
            } else {
                r -= initialSum;
                if (r < 0) {
                    r += initialSteps;
                    n--;
                }
            }

            long nextValue = initialSteps + 1;
            if (l < r) {
                nextValue++;
            }
            long[] leftResult = calculateNextValue(nextValue, l);
            long newL = leftResult[0];
            n += leftResult[1];

            nextValue = initialSteps + 1;
            if (l >= r) {
                nextValue++;
            }
            long[] rightResult = calculateNextValue(nextValue, l);
            long newR = rightResult[0];
            n += rightResult[1];

            System.out.printf("Case #%d: %d %d %d%n", task, n, newL, newR);
        }

        scanner.close();
    }

    private long[] calculateNextValue(long start, long total) {
        long[] result = new long[2];
        long min = 0;
        long max = (long) Math.sqrt(total) * 4 + 4;
        long mid;

        while (min < max) {
            mid = (min + max + 1) / 2;
            if (mid * mid + (start - 1) * mid <= total) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }

        mid = min;
        result[0] = total - start * mid - mid * (mid - 1);
        result[1] = mid;
        return result;
    }

    public class FastScanner {
        private InputStream input;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastScanner(InputStream input) {
            this.input = input;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = input.read(buffer);
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
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sign;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sign;
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