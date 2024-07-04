import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Queue;
import java.io.BufferedReader;
import java.util.LinkedList;
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
        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int X = in.nextInt();
            int Y = in.nextInt();
            char[] M = in.next().toCharArray();

            String[] path = new String[1 + M.length];

            path[0] = id(X, Y);
            int x = X;
            int y = Y;
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
                path[i] = id(x, y);
            }

            Queue<String> bst = new LinkedList<>();
            Map<String, Integer> dist = new HashMap<>();
            String start = id(0, 0);
            bst.add(start);
            if ((X + Y) % 2 != 0) {
                dist.put(start, 1);
            } else {
                dist.put(start, 0);
            }

            while (!bst.isEmpty()) {
                String node = bst.poll();
                int t = dist.get(node);
                int[] cor = cor(node);
                x = cor[0];
                y = cor[1];
                if (path[t].equals(node)) {
                    out.println("Case #" + testNumber + ": " + t);
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    String id = id(nx, ny);
                    if (!dist.containsKey(id) && t + 1 <= M.length) {
                        dist.put(id, t + 1);
                        bst.add(id);
                    }
                }
            }

            out.println("Case #" + testNumber + ": IMPOSSIBLE");
        }

        private int[] cor(String node) {
            String[] tokens = node.split("r");
            return new int[]{Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])};
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

