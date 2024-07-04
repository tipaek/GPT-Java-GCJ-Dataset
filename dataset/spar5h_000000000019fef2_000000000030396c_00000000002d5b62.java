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
        Expogo solver = new Expogo();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Expogo {
        public void solve(int testNumber, InputReader s, PrintWriter w) {
            int x = s.nextInt(), y = s.nextInt();
            w.print("Case #" + testNumber + ": ");
            if ((x + y) % 2 == 0) {
                w.println("IMPOSSIBLE");
                return;
            }
            char xc = 'E', yc = 'N';
            if (x < 0) {
                xc = 'W';
                x = -x;
            }
            if (y < 0) {
                yc = 'S';
                y = -y;
            }
            int k = (int) (Math.log(Math.abs(x) + Math.abs(y)) / Math.log(2)) + 1;
            int c = k - 1;
            char[] res = new char[k];
            while (c >= 0) {
                if (x >= y) {
                    res[c] = xc;
                    x -= 1 << c;
                    if (x < 0) {
                        xc = (xc == 'E') ? 'W' : 'E';
                        x = -x;
                    }
                } else {
                    res[c] = yc;
                    y -= 1 << c;
                    if (y < 0) {
                        yc = (yc == 'N') ? 'S' : 'N';
                        y = -y;
                    }
                }
                c--;
            }
            for (int i = 0; i < k; i++)
                w.print(res[i]);
            w.println();
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

