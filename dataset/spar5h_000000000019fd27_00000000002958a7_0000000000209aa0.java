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
        Indicium solver = new Indicium();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Indicium {
        boolean nextPermutation(int[] a) {
            int p = -1;
            for (int i = a.length - 2; i >= 0; i--) {
                if (a[i] < a[i + 1]) {
                    p = i;
                    break;
                }
            }
            if (p == -1)
                return false;
            int q = -1;
            for (int i = a.length - 1; i > p; i--) {
                if (a[i] > a[p]) {
                    q = i;
                    break;
                }
            }
            int temp = a[p];
            a[p] = a[q];
            a[q] = temp;
            for (int i = 0; i < (a.length - (p + 1)) / 2; i++) {
                temp = a[p + 1 + i];
                a[p + 1 + i] = a[a.length - i - 1];
                a[a.length - i - 1] = temp;
            }
            return true;
        }

        public void solve(int testNumber, InputReader s, PrintWriter w) {
            int n = s.nextInt(), k = s.nextInt();
            w.print("Case #" + testNumber + ": ");
            if (n > 5) {
                w.println("NA");
                return;
            }
            int[] r = new int[n];
            for (int i = 0; i < n; i++)
                r[i] = i;
            int[] c = new int[n];
            for (int i = 0; i < n; i++)
                c[i] = i;
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    mat[i][j] = (i + j) % n + 1;
            }
            boolean check = false;
            outer:
            while (true) {
                while (true) {
                    int trace = 0;
                    for (int i = 0; i < n; i++)
                        trace += mat[r[i]][c[i]];
                    if (trace == k) {
                        check = true;
                        break outer;
                    }
                    if (!nextPermutation(c))
                        break;
                }
                if (!nextPermutation(r))
                    break;
            }
            if (check) {
                w.println("POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++)
                        w.print(mat[r[i]][c[j]] + " ");
                    w.println();
                }
            } else
                w.println("IMPOSSIBLE");

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

