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
 * @author Pranay2516
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NestingDepth solver = new NestingDepth();
        solver.solve(1, in, out);
        out.close();
    }

    static class NestingDepth {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int q = 0; q < t; ++q) {
                String s = in.next();
                int n = s.length();
                char[] c = s.toCharArray();
                int[] a = new int[n];
                ArrayList<Character> ar = new ArrayList<>();
                for (int i = 0; i < n; ++i) {
                    a[i] = (int) c[i] - 48;
                }
                for (int i = 0; i < a[0]; ++i) {
                    ar.add('(');
                }
                ar.add(c[0]);
                for (int i = 0; i < n - 1; ++i) {
                    if (a[i + 1] == a[i]) ar.add(c[i + 1]);
                    else if (a[i + 1] > a[i]) {
                        for (int j = 0; j < a[i + 1] - a[i]; ++j) {
                            ar.add('(');
                        }
                        ar.add(c[i + 1]);
                    } else {
                        for (int j = 0; j < a[i] - a[i + 1]; ++j) {
                            ar.add(')');
                        }
                        ar.add(c[i + 1]);
                    }
                }
                for (int i = 0; i < a[n - 1]; ++i) {
                    ar.add(')');
                }
                out.print("Case #" + (q + 1) + ": ");
                for (int i = 0; i < ar.size(); ++i) {
                    out.print(ar.get(i));
                }
                ar.clear();
                out.println();
            }
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

        public String next() {

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

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

