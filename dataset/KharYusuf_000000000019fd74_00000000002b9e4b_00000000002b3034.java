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
 * @author KharYusuf
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PatternMatching solver = new PatternMatching();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PatternMatching {
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int n = s.nextInt();
            ArrayList<Character> pre = new ArrayList<>(), suf = new ArrayList<>(), mid = new ArrayList<>();
            char[][] c = new char[n][];
            for (int i = 0; i < n; i++)
                c[i] = s.next().toCharArray();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < c[i].length && c[i][j] != '*'; j++) {
                    if (j < pre.size()) {
                        if (pre.get(j) != c[i][j]) {
                            w.println("Case #" + testNumber + ": *");
                            return;
                        }
                    } else
                        pre.add(c[i][j]);
                }
                for (int j = c[i].length - 1, k = 0; j >= 0 && c[i][j] != '*'; j--, k++) {
                    if (k < suf.size()) {
                        //w.println(k+" "+suf+" "+c[i][j]);
                        if (suf.get(k) != c[i][j]) {
                            w.println("Case #" + testNumber + ": *");
                            return;
                        }
                    } else suf.add(c[i][j]);
                }
                int j = 0, k = c[i].length - 1;
                for (; j < c[i].length && c[i][j] != '*'; j++) ;
                j++;
                for (; k >= 0 && c[i][k] != '*'; k--) ;
                k--;
                for (; j <= k; j++) if (c[i][j] != '*') mid.add(c[i][j]);
            }
            w.print("Case #" + testNumber + ": ");
            for (char cc : pre) w.print(cc);
            for (char cc : mid) w.print(cc);
            for (int i = suf.size() - 1; i >= 0; i--) w.print(suf.get(i));
            w.println();

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

