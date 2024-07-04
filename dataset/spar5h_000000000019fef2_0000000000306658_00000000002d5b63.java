import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
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
        BlindfoldedBullseye solver = new BlindfoldedBullseye();
        int testCount = 1;
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class BlindfoldedBullseye {
        public void solve(int testNumber, InputReader s, PrintWriter w) {
            int t = s.nextInt();
            int a = s.nextInt(), b = s.nextInt();
            for (int ti = 1; ti <= t; ti++) {
                boolean ck = false;
                Random r = new Random(93);
                ArrayList<Pair> list = new ArrayList<Pair>();
                outer:
                for (int i = 0; i < 300; i++) {
                    int x = 0, y = 0;
                    outer2:
                    while (true) {
                        x = r.nextInt(2 * ((int) 1e9 - a)) - ((int) 1e9 - a);
                        y = r.nextInt(2 * ((int) 1e9 - a)) - ((int) 1e9 - a);
                        for (Pair p : list) {
                            if (p.x == x && p.y == y)
                                continue outer2;
                        }
                        list.add(new Pair(x, y));
                        break;
                    }
                    w.println(x + " " + y);
                    w.flush();
                    String str = s.next();
                    if (str.equals("CENTER")) {
                        ck = true;
                        break outer;
                    } else if (str.equals("WRONG")) {
                        ck = true;
                        break outer;
                    }
                }
                while (!ck) {
                    w.println(0 + " " + 0);
                    w.flush();
                    if (s.next().equals("WRONG"))
                        break;
                }
            }

        }

        class Pair {
            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

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

