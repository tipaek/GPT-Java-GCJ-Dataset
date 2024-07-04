import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

    public void run() throws IOException {
        FasterScanner sc = new FasterScanner(System.in);
        int amountOfTasks = sc.nextInt();

        for (int task = 1; task <= amountOfTasks; task++) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            long n = 0;

            long diff = Math.abs(l - r);
            long firstAmount = (long) Math.sqrt(2 * diff);
            n += firstAmount;
            long firstTotal = firstAmount * (firstAmount + 1) / 2;

            if (l >= r) {
                l -= firstTotal;
                if (l < 0) {
                    l += firstAmount;
                    n--;
                }
            } else {
                r -= firstTotal;
                if (r < 0) {
                    r += firstAmount;
                    n--;
                }
            }

            long nextVal = firstAmount + 1;
            if (l < r) {
                nextVal++;
            }
            long[] resultL = calculateNewValues(nextVal, l);
            l = resultL[0];
            n += resultL[1];

            nextVal = firstAmount + 1;
            if (l >= r) {
                nextVal++;
            }
            long[] resultR = calculateNewValues(nextVal, r);
            r = resultR[0];
            n += resultR[1];

            System.out.println("Case #" + task + ": " + n + " " + l + " " + r);
        }

        sc.close();
    }

    private long[] calculateNewValues(long start, long total) {
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

    public static class FasterScanner {
        private InputStream is;
        private byte[] buffer = new byte[1024];
        private int curChar;
        private int numChars;

        public FasterScanner(InputStream is) {
            this.is = is;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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