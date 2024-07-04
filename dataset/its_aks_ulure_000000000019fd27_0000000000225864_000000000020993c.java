import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Task {
        PrintWriter out;
        InputReader in;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            this.in = in;
            int n = ni();
            int[][] mat = new int[n][n];
            int trace = 0, row = 0, col = 0;
            int i = 0, j = 0;

            for (i = 0; i < n; i++) {
                HashSet<Integer> hset = new HashSet<>();
                for (j = 0; j < n; j++) {
                    mat[i][j] = ni();
                    if (i == j)
                        trace += mat[i][j];
                    hset.add(mat[i][j]);
                }
                if (hset.size() != n)
                    row++;
            }
            for (i = 0; i < n; i++) {
                HashSet<Integer> hset = new HashSet<>();
                for (j = 0; j < n; j++)
                    hset.add(mat[j][i]);
                if (hset.size() != n)
                    col++;
            }
            pn("Case #" + testNumber + ": " + trace + " " + row + " " + col);
        }

        int ni() {
            return in.nextInt();
        }

        void pn(String zx) {
            out.println(zx);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

