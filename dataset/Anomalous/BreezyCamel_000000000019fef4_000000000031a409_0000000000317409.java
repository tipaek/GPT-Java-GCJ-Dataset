import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        new Solver().solve(in, out);
        out.close();
    }

    static class Solver {
        public void solve(InputReader in, OutputWriter out) {
            int t = in.nextInt();
            for (int i = 1; i <= t; i++) {
                int e = in.nextInt();
                int n = in.nextInt();
                String path = in.next();
                int min = 0;
                char[] pathArr = path.toCharArray();

                for (char direction : pathArr) {
                    if (e == 0 && n == 0) {
                        break;
                    }
                    switch (direction) {
                        case 'N': n++; break;
                        case 'S': n--; break;
                        case 'E': e++; break;
                        case 'W': e--; break;
                    }
                    if (e > 0) e--;
                    else if (e < 0) e++;
                    else if (n > 0) n--;
                    else if (n < 0) n++;
                    min++;
                }

                if (e != 0 || n != 0) {
                    out.printf("Case #%d: IMPOSSIBLE\n", i);
                } else {
                    out.printf("Case #%d: %d\n", i, min);
                }
            }
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

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
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
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
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder sb = new StringBuilder();
            do {
                sb.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return sb.toString();
        }

        private static boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void printf(String format, Object... args) {
            writer.printf(format, args);
        }

        public void close() {
            writer.close();
        }
    }
}