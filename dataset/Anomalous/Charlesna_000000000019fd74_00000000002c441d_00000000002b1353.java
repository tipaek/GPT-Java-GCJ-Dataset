import java.io.*;
import java.util.InputMismatchException;

public class Solution implements Runnable {

    private static final int MAX_N = 500;
    private static final long LIMIT = (long) 1e10;
    private static long[][] tri = new long[MAX_N + 1][MAX_N + 1];
    private static long[][] prefix = new long[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        buildTriangle();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int N = in.nextInt();
            processResult(N, i, w);
        }
        w.flush();
        w.close();
    }

    private static void buildTriangle() {
        for (int i = 1; i <= MAX_N; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    tri[i][j] = 1;
                } else {
                    tri[i][j] = Math.min(tri[i - 1][j] + tri[i - 1][j - 1], LIMIT);
                }
                prefix[i][j] = prefix[i][j - 1] + tri[i][j];
            }
        }
    }

    private static void processResult(int N, int t, PrintWriter w) {
        w.println("Case #" + (t + 1) + ":");
        int x = 1, y = 1;
        while (N > 0) {
            w.println(x + " " + y);
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
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private final BufferedReader br;

        public InputReader(InputStream stream) {
            this.stream = stream;
            this.br = new BufferedReader(new InputStreamReader(stream));
        }

        private int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = res * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9') throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }
    }
}