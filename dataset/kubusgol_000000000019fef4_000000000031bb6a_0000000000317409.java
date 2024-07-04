import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        OverexcitedFan solver = new OverexcitedFan();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OverexcitedFan {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int X = in.nextInt();
            int Y = in.nextInt();
            char[] M = in.next().toCharArray();

            String[] path = new String[1 + M.length];

            path[0] = id(X, Y);
            int x = X;
            int y = Y;
            int ans = Integer.MAX_VALUE;
            int dist = Math.abs(X) + Math.abs(Y);

            for (int i = 1; i <= M.length; i++) {
                char dir = M[i - 1];
                if (dir == 'N') {
                    y++;
                } else if (dir == 'S') {
                    y--;
                } else if (dir == 'E') {
                    x++;
                } else {
                    x--;
                }

                dist = Math.abs(x) + Math.abs(y);
                if (dist <= i) {
                    ans = Math.min(ans, i);
                }
            }
            out.println("Case #" + testNumber + ": " + (ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans));
        }

        private String id(int x, int y) {
            return "" + x + "r" + y;
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

