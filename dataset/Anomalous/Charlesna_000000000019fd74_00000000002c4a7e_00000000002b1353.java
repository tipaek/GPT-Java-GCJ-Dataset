import java.io.*;
import java.util.InputMismatchException;

public class Solution implements Runnable {

    private static final long LIMIT = (long) 1e10;
    private static final int MAX = 500;
    private static long[][] tri = new long[MAX + 1][MAX + 1];
    private static long[][] prefix = new long[MAX + 1][MAX + 1];

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        buildTriangle();
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int N = in.nextInt();
            computeResult(N, i, out);
        }
        out.flush();
        out.close();
    }

    private static void buildTriangle() {
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    tri[i][j] = prefix[i][j] = 1;
                } else {
                    tri[i][j] = Math.min(tri[i - 1][j] + tri[i - 1][j - 1], LIMIT);
                    prefix[i][j] = prefix[i][j - 1] + tri[i][j];
                }
            }
        }
    }

    private static void computeResult(int N, int caseNumber, PrintWriter out) {
        out.println("Case #" + caseNumber + ":");
        int x = 1, y = 1;
        while (N > 0) {
            out.println(x + " " + y);
            N -= tri[x][y];

            if (prefix[x + 1][y] + tri[x + 1][y + 1] <= N) {
                x++;
                y++;
            } else if (prefix[x + 1][y - 1] + tri[x + 1][y] <= N) {
                x++;
            } else {
                y--;
            }
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int curChar;
        private int numChars;
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buffer);
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
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new InputMismatchException();
            }
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
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
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
            long result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            double result = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return result * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double fraction = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return result * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    fraction /= 10;
                    result += (c - '0') * fraction;
                    c = read();
                }
            }
            return result * sign;
        }

        public String readString() {
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

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }
    }
}