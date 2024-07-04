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
        ESAbATAd solver = new ESAbATAd();
        int testCount = 1;
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ESAbATAd {
        public void solve(int testNumber, InputReader s, PrintWriter w) {
            int t = s.nextInt(), b = s.nextInt();
            for (int t_i = 1; t_i <= t; t_i++) {
                int[] a = new int[b];
                for (int i = 0; i < b / 2; i++) {
                    w.println(i + 1);
                    w.flush();
                    a[i] = s.next().charAt(0) - '0';
                    w.println(b - i - 1 + 1);
                    w.flush();
                    a[b - i - 1] = s.next().charAt(0) - '0';
                }
                for (int k = 10; k <= b; k *= 5) {
                    for (int i = 0; i < b / k; i++) {
                        int[] par = new int[2];
                        for (int j = 0; j < k / 2; j++) {
                            int v0 = a[i * k / 2 + j];
                            int v1 = a[b - 1 - (i * k / 2 + j)];
                            if (par[v0 ^ v1] == -1) {
                                w.println((i * k / 2 + j) + 1);
                                w.flush();
                                int x = s.next().charAt(0) - '0';
                                par[v0 ^ v1] = x ^ v0;
                            }
                        }
                        if (par[0] == -1 || par[1] == -1) {
                            w.println(1);
                            w.flush();
                            s.next();
                        }
                        for (int j = 0; j < k / 2; j++) {
                            int v0 = a[i * k / 2 + j];
                            int v1 = a[b - 1 - (i * k / 2 + j)];
                            a[i * k / 2 + j] ^= par[v0 ^ v1];
                            a[b - 1 - (i * k / 2 + j)] ^= par[v0 ^ v1];
                        }
                    }
                }

                for (int i = 0; i < b; i++)
                    w.print(a[i]);
                w.println();
                w.flush();
                s.next();
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

