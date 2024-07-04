import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Reader in = new Reader();
        new Solution().solve(out, in);
        out.flush();
        out.close();
    }

    static final int MAXN = 5 * (int) 1e5 + 5;
    static final long MOD = (int) 1e9 + 7;
    static int n, t;

    void solve(PrintWriter out, Reader in) throws IOException {
        t = in.nextInt();

        for (int itr = 1; itr <= t; itr++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            n = s.length();
            int[] need = new int[n + 1];

            for (int i = 0; i < n; i++) {
                switch (s.charAt(i)) {
                    case 'S': y--; break;
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                need[i + 1] = Math.abs(x) + Math.abs(y);
            }

            int lo = 1, hi = n, mid, res = -1;
            while (lo <= hi) {
                mid = (lo + hi) / 2;
                if (need[mid] <= mid) {
                    hi = mid - 1;
                    res = mid;
                } else {
                    lo = mid + 1;
                }
            }

            if (res == -1) {
                out.println("Case #" + itr + ": IMPOSSIBLE");
            } else {
                out.println("Case #" + itr + ": " + res);
            }
        }
    }

    static class Reader {
        private InputStream inputStream;
        private byte[] buffer = new byte[1024];
        private int curChar, numChars;

        public Reader() {
            this(System.in);
        }

        public Reader(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = inputStream.read(buffer);
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
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public String next() {
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
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
            return result * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
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
            return result * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}