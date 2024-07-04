import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jeel Vaishnav
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PascalWalk solver = new PascalWalk();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PascalWalk {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            long n = sc.nextLong();

            out.println("Case #" + testNumber + ": ");

            if (n <= 32) {
                for (long i = 1; i <= n; ++i) {
                    out.println(i + " " + 1);
                }
            } else {
                n -= 32;

                int already = 0;
                int left = 0;
                int row = 1;
                ArrayList<Pair> list = new ArrayList<>();
                while (already < 32) {
                    if (((n >> (row - 1)) & 1) == 1) {
                        if (left == 0) {
                            for (int col = 1; col <= row; ++col)
                                list.add(new Pair(row, col));
                        } else {
                            for (int col = row; col >= 1; --col)
                                list.add(new Pair(row, col));
                        }
                        left ^= 1;
                    } else {
                        if (left == 0)
                            list.add(new Pair(row, 1));
                        else
                            list.add(new Pair(row, row));
                        already++;
                    }
                    row++;
                }

                for (Pair curP : list)
                    out.println(curP.r + " " + curP.c);
            }
        }

        class Pair {
            int r;
            int c;

            Pair(int a, int b) {
                r = a;
                c = b;
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
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
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
            public boolean isSpaceChar(int ch);

        }

    }
}

