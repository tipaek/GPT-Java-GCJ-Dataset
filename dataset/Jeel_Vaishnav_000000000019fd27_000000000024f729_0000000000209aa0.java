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
 * @author Jeel Vaishnav
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
        int[][] mat;
        int[] rowMask;
        int[] colMask;
        int flag;
        int n;

        void solve(int hashInd) {
            if (hashInd == n * n) {
                flag = 1;
                return;
            }

            int col = hashInd % n;
            int row = hashInd / n;

            if (row == col)
                solve(hashInd + 1);
            else {
                for (int i = 0; i < n; ++i) {
                    if (((rowMask[row] >> i) & 1) == 0 && ((colMask[col] >> i) & 1) == 0) {
                        rowMask[row] |= (1 << i);
                        colMask[col] |= (1 << i);

                        mat[row][col] = i;

                        solve(hashInd + 1);

                        if (flag == 1)
                            return;

                        rowMask[row] ^= (1 << i);
                        colMask[col] ^= (1 << i);
                    }
                }
            }
        }

        void fillDiagonal(int ind, int k) {
            if (ind == n) {
                if (k == 0)
                    solve(0);
                return;
            }
            for (int i = 0; i < n; ++i) {
                rowMask[ind] |= (1 << i);
                colMask[ind] |= (1 << i);
                mat[ind][ind] = i;

                fillDiagonal(ind + 1, k - i - 1);

                if (flag == 1)
                    return;

                rowMask[ind] ^= (1 << i);
                colMask[ind] ^= (1 << i);
            }
        }

        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            n = sc.nextInt();
            int k = sc.nextInt();

            mat = new int[n][n];
            rowMask = new int[n];
            colMask = new int[n];
            flag = 0;
            fillDiagonal(0, k);

            if (flag == 0)
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            else {
                out.println("Case #" + testNumber + ": POSSIBLE");
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        out.print((mat[i][j] + 1) + " ");
                    }
                    out.println();
                }
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

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
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

