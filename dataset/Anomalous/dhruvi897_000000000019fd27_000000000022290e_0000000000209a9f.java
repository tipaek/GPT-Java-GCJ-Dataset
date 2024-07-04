import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int t = in.nextInt();
        Vestigium solver = new Vestigium();
        for (int i = 1; i <= t; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Vestigium {
        public void solve(int t, FastReader s, PrintWriter w) {
            String S = s.next();
            StringBuilder res = new StringBuilder();
            int pv = 0;
            int fp = 0, bp = 0;
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                int cv = Character.getNumericValue(c);
                if (res.length() == 0) {
                    for (int j = 0; j < cv; j++) {
                        res.append("(");
                        fp++;
                    }
                    res.append(c);
                } else {
                    if (cv > pv) {
                        int d = cv - pv;
                        for (int k = 0; k < d; k++) {
                            res.append("(");
                        }
                        res.append(c);
                        fp += d;
                    } else if (cv < pv) {
                        int d = pv - cv;
                        for (int k = 0; k < d; k++) {
                            res.append(")");
                        }
                        res.append(c);
                        bp += d;
                    } else {
                        res.append(c);
                    }
                }
                pv = cv;
            }
            while (fp != bp) {
                res.append(")");
                bp++;
            }
            w.println("Case #" + t + ": " + res.toString());
        }
    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public FastReader(InputStream stream) {
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
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}