import java.io.*;
import java.util.InputMismatchException;

public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        buildTriangle();
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int N = in.nextInt();
            processTestCase(N, i, w);
        }
        w.flush();
        w.close();
    }

    static long[][] triangle = new long[501][501];
    static long[][] prefixSum = new long[501][501];

    private static void buildTriangle() {
        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    prefixSum[i][j] = 1;
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                    triangle[i][j] = Math.min(triangle[i][j], (long) 1e10);
                    prefixSum[i][j] = prefixSum[i][j - 1] + triangle[i][j];
                }
            }
        }
    }

    private static void processTestCase(int N, int testCaseNumber, PrintWriter w) {
        w.println("Case #" + testCaseNumber + ":");
        int x = 1, y = 1;
        while (N > 0) {
            w.println(x + " " + y);
            N -= triangle[x][y];

            if (prefixSum[x + 1][y - 1] + triangle[x + 1][y] <= N && triangle[x + 1][y] > triangle[x + 1][y + 1]) {
                x++;
            } else if (prefixSum[x + 1][y] + triangle[x + 1][y + 1] <= N) {
                x++;
                y++;
            } else if (prefixSum[x + 1][y - 1] + triangle[x + 1][y] <= N) {
                x++;
            } else {
                y--;
            }
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
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
                result *= 10;
                result += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
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
                result *= 10;
                result += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            double result = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return result * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                result *= 10;
                result += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double fraction = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return result * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    fraction /= 10;
                    result += (c - '0') * fraction;
                    c = read();
                }
            }
            return result * sign;
        }

        public String readString() {
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

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}