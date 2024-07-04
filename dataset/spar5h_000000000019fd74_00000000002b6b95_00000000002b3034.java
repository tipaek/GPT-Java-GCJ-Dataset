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
        PatternMatching solver = new PatternMatching();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PatternMatching {
        public void solve(int testNumber, InputReader s, PrintWriter w) {
            int n = s.nextInt();
            w.print("Case #" + testNumber + ": ");
            char[][] p = new char[n][];
            for (int i = 0; i < n; i++)
                p[i] = s.next().toCharArray();
            boolean pos = true;
            int[] first = new int[n];
            int[] last = new int[n];
            StringBuffer sb = new StringBuffer();
            int max = -1, idx = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < p[i].length; j++) {
                    if (p[i][j] == '*') {
                        first[i] = j;
                        if (max < first[i]) {
                            max = first[i];
                            idx = i;
                        }
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < first[i]; j++) {
                    if (p[i][j] != p[idx][j])
                        pos = false;
                }
            }
            for (int j = 0; j < first[idx]; j++)
                sb.append(p[idx][j]);
            max = -1;
            idx = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < p[i].length; j++) {
                    if (p[i][p[i].length - 1 - j] == '*') {
                        last[i] = j;
                        if (max < last[i]) {
                            max = last[i];
                            idx = i;
                        }
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < last[i]; j++) {
                    if (p[i][p[i].length - 1 - j] != p[idx][p[idx].length - 1 - j])
                        pos = false;
                }
            }
            if (!pos) {
                w.println("*");
                return;
            }
            for (int i = 0; i < n; i++) {
                for (int j = first[i]; j < p[i].length - 1 - last[i]; j++)
                    if (p[i][j] != '*')
                        sb.append(p[i][j]);
            }
            for (int j = 0; j < last[idx]; j++) {
                sb.append(p[idx][p[idx].length - last[idx] + j]);
            }
            w.println(sb);
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

