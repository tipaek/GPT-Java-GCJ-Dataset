import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;


/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pranay2516
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Vestigium solver = new Vestigium();
        solver.solve(1, in, out);
        out.close();
    }

    static class Vestigium {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int q = 0; q < t; ++q) {
                int n = in.nextInt();
                int a[][] = new int[n][n];
                for (int i = 0; i < n; ++i) {
                    a[i] = in.readIntArray(n);
                }
                int cntr = 0, cntc = 0, r = 0;
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        for (int k = j + 1; k < n; ++k) {
                            if (a[i][j] == a[i][k]) {
                                r++;
                            }
                        }
                    }
                    if (r > 0) cntr++;
                    r = 0;
                }
                int c = 0;
                for (int j = 0; j < n; ++j) {
                    for (int i = 0; i < n; ++i) {
                        for (int k = i + 1; k < n; ++k) {
                            if (a[i][j] == a[k][j]) {
                                c++;
                            }
                        }
                    }
                    if (c > 0) cntc++;
                    c = 0;
                }
                out.println("Case #" + (q + 1) + ": " + Trace(a, n) + " " + cntr + " " + cntc);
            }
        }

        static int Trace(int mat[][], int n) {
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += mat[i][i];
            return sum;
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
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

        public boolean isSpaceChar(int c) {

            if (filter != null)
                return filter.isSpaceChar(c);

            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

