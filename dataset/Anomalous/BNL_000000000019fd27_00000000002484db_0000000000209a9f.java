import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Reader in = new Reader();
        Solution solver = new Solution();
        solver.solve(out, in);
        out.flush();
        out.close();
    }

    static final int MAXN = 5 * (int)1e5 + 5;
    static final long MOD = (int)1e9 + 7;
    static int n, t;

    void solve(PrintWriter out, Reader in) throws IOException {
        t = in.nextInt();

        for (int itr = 1; itr <= t; itr++) {
            String s = in.next();
            n = s.length();

            StringBuilder ans = new StringBuilder();
            int add = 0, need;
            for (int i = 0; i < n; i++) {
                need = s.charAt(i) - '0';
                while (add < need) {
                    ans.append("(");
                    add++;
                }
                while (add > need) {
                    ans.append(")");
                    add--;
                }
                ans.append(s.charAt(i));
            }
            while (add > 0) {
                ans.append(")");
                add--;
            }
            out.println("Case #" + itr + ": " + ans);
        }
    }

    static class Reader {
        private final InputStream inputStream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

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
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = inputStream.read(buffer);
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

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}