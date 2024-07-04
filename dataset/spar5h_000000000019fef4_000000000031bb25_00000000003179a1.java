import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
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
        Overrandomized solver = new Overrandomized();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Overrandomized {
        public void solve(int testNumber, InputReader s, PrintWriter w) {
            int u = s.nextInt();
            int k = 10000;
            int[] map = new int[26];
            Arrays.fill(map, -1);
            char[] res = new char[10];
            int[] occ = new int[26];
            ArrayList<Character>[] adj = new ArrayList[10];
            for (int i = 1; i <= 9; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 1; i <= k; i++) {
                long q = s.nextInt();
                char[] r = s.next().toCharArray();
                for (char c : r)
                    occ[c - 'A'] = 1;
                if (q >= 10)
                    continue;
                adj[(int) q].add(r[0]);
            }
            for (int i = 1; i <= 9; i++) {
                for (char j : adj[i]) {
                    if (map[j - 'A'] == -1) {
                        res[i] = j;
                        map[j - 'A'] = i;
                    }
                }
            }
            for (int i = 0; i < 26; i++) {
                if (map[i] == -1 && occ[i] == 1) {
                    res[0] = (char) (i + 'A');
                    map[i] = 0;
                }
            }
            w.print("Case #" + testNumber + ": ");
            for (int i = 0; i < 10; i++)
                w.print(res[i]);
            w.println();
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

