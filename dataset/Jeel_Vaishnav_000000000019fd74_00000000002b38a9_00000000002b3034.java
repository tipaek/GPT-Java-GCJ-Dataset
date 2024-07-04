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
        PatternMatching solver = new PatternMatching();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PatternMatching {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int n = sc.nextInt();
            ArrayList<Character> prefix = new ArrayList<>();
            ArrayList<Character> suffix = new ArrayList<>();
            ArrayList<Character> rest = new ArrayList<>();

            int flag = 0;

            char[][] s = new char[n][];

            for (int i = 0; i < n; ++i) {
                s[i] = sc.next().toCharArray();
            }

            main:
            for (int i = 0; i < n; ++i) {
                int l = 0;
                while (s[i][l] != '*') {
                    if (prefix.size() - 1 >= l) {
                        if (s[i][l] != prefix.get(l)) {
                            flag = 1;
                            break main;
                        }
                    } else
                        prefix.add(s[i][l]);

                    l++;
                }

                int r = s[i].length - 1;
                while (s[i][r] != '*') {
                    if (suffix.size() - 1 >= s[i].length - 1 - r) {
                        if (s[i][r] != suffix.get(s[i].length - 1 - r)) {
                            flag = 1;
                            break main;
                        }
                    } else
                        suffix.add(s[i][r]);

                    r--;
                }

                for (int j = l; j <= r; ++j) {
                    if (s[i][j] != '*')
                        rest.add(s[i][j]);
                }
            }

            out.print("Case #" + testNumber + ": ");
            if (flag == 1)
                out.println("*");
            else {
                for (char c : prefix)
                    out.print(c);
                for (char c : rest)
                    out.print(c);
                for (int i = suffix.size() - 1; i >= 0; --i)
                    out.print(suffix.get(i));
                out.println();
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

