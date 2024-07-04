import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Sparsh Sanchorawala
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SquareDance solver = new SquareDance();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SquareDance {
        public void solve(int testNumber, InputReader s, PrintWriter w) {
            int r = s.nextInt(), c = s.nextInt();
            long[][] a = new long[r][c];
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    a[i][j] = s.nextInt();
            long res = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++)
                    res += a[i][j];
            }
            while (true) {
                long[][] sum = new long[r][c];
                int[][] count = new int[r][c];
                for (int i = 0; i < r; i++) {
                    int curr = -1;
                    for (int j = 0; j < c; j++) {
                        if (a[i][j] > 0) {
                            if (curr != -1) {
                                sum[i][j] += a[i][curr];
                                count[i][j]++;
                            }
                            curr = j;
                        }
                    }
                }
                for (int i = 0; i < r; i++) {
                    int curr = -1;
                    for (int j = c - 1; j >= 0; j--) {
                        if (a[i][j] > 0) {
                            if (curr != -1) {
                                sum[i][j] += a[i][curr];
                                count[i][j]++;
                            }
                            curr = j;
                        }
                    }
                }
                for (int j = 0; j < c; j++) {
                    int curr = -1;
                    for (int i = 0; i < r; i++) {
                        if (a[i][j] > 0) {
                            if (curr != -1) {
                                sum[i][j] += a[curr][j];
                                count[i][j]++;
                            }
                            curr = i;
                        }
                    }
                }

                for (int j = 0; j < c; j++) {
                    int curr = -1;
                    for (int i = r - 1; i >= 0; i--) {
                        if (a[i][j] > 0) {
                            if (curr != -1) {
                                sum[i][j] += a[curr][j];
                                count[i][j]++;
                            }
                            curr = i;
                        }
                    }
                }

                int dead = 0;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (a[i][j] == 0)
                            continue;
                        if (sum[i][j] > count[i][j] * a[i][j] && count[i][j] > 0) {
                            dead++;
                            a[i][j] = 0;
                        }
                    }
                }
                if (dead == 0)
                    break;
                for (int i = 0; i < r; i++)
                    for (int j = 0; j < c; j++)
                        res += a[i][j];
            }
            w.print("Case #" + testNumber + ": ");
            w.println(res);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return nextString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

