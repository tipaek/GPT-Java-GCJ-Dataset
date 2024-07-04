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
        SecurityUpdate solver = new SecurityUpdate();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SecurityUpdate {
        public void solve(int testNumber, InputReader s, PrintWriter w) {
            int c = s.nextInt();
            ArrayList<Integer>[] ord = new ArrayList[c];
            for (int i = 0; i < c; i++)
                ord[i] = new ArrayList<>();
            int d = s.nextInt();
            int[][] adj = new int[c][c];
            for (int i = 0; i < c; i++)
                Arrays.fill(adj[i], -1);
            int[] x = new int[c];
            ord[0].add(0);
            for (int i = 1; i < c; i++) {
                x[i] = -s.nextInt();
                ord[x[i]].add(i);
            }
            for (int i = 0; i < d; i++) {
                int u = s.nextInt() - 1, v = s.nextInt() - 1;
                adj[v][u] = i;
                adj[u][v] = i;
            }
            int[] res = new int[d];
            Arrays.fill(res, 1000000);
            int[] vis = new int[c];
            vis[0] = 1;
            int[] dist = new int[c];
            int val = 0;
            for (int i = 1; i < c; i++) {
                val = val + 1;
                for (int j : ord[i]) {
                    for (int k = 0; k < c; k++) {
                        if (vis[k] == 1 && adj[j][k] != -1) {
                            val = Math.max(val, dist[k] + 1);
                        }
                    }
                }
                for (int j : ord[i]) {
                    for (int k = 0; k < c; k++) {
                        if (vis[k] == 1 && adj[j][k] != -1) {
                            res[adj[j][k]] = val - dist[k];
                            dist[j] = val;
                            vis[j] = 1;
                            break;
                        }
                    }
                }
            }
            w.print("Case #" + testNumber + ": ");
            for (int i = 0; i < d; i++)
                w.print(res[i] + " ");
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

