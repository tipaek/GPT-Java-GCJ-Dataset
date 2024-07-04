import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        solve(fs, out);
        out.flush();
    }

    private static class Edge {
        int u, v, index;
        int ans = 1000000;

        Edge(int u, int v, int index) {
            this.u = u;
            this.v = v;
            this.index = index;
        }
    }

    public void solve(FastScanner fs, PrintWriter out) {
        int T = fs.nextInt();
        for (int i = 1; i <= T; ++i) {
            int C = fs.nextInt(), D = fs.nextInt();
            int[] X = new int[C];
            for (int j = 1; j < C; ++j) X[j] = fs.nextInt();
            List<List<Edge>> graph = new ArrayList<>(C);
            for (int j = 0; j < C; ++j) graph.add(new ArrayList<>());
            for (int j = 0; j < D; ++j) {
                int U = fs.nextInt() - 1, V = fs.nextInt() - 1;
                graph.get(U).add(new Edge(U, V, j));
                graph.get(V).add(new Edge(V, U, j));
            }
            int[] dist = new int[C];
            Arrays.fill(dist, -1);
            dist[0] = 0;

            Queue<Integer> bfs = new ArrayDeque<>();
            bfs.add(0);
            while (!bfs.isEmpty()) {
                int tmp = bfs.poll();
                for (Edge edge : graph.get(tmp)) {
                    if (dist[edge.v] < 0) {
                        dist[edge.v] = dist[tmp] + 1;
                        bfs.add(edge.v);
                    }
                }
            }

            PriorityQueue<Integer> positive = new PriorityQueue<>((l, r) ->
                    (X[l] == X[r] ? Integer.compare(dist[l], dist[r]) : Integer.compare(X[l], X[r])));
            PriorityQueue<Integer> negative = new PriorityQueue<>((l, r) ->
                    (X[l] == X[r] ? Integer.compare(dist[l], dist[r]) : Integer.compare(X[r], X[l])));

            for (int j = 1; j < C; ++j) {
                if (X[j] > 0) positive.add(j);
                else negative.add(j);
            }

            int[] lazy = new int[C];
            Arrays.fill(lazy, 1000001);
            lazy[0] = 0;

            for (int j = 1, count = 1; j <= 1000000; ++j) {
                int tmpCount = 0;
                while (!negative.isEmpty() && X[negative.peek()] == -count) {
                    int tmp = negative.poll();
                    Edge min = null;
                    for (Edge edge : graph.get(tmp)) {
                        if (min == null || lazy[edge.v] < lazy[min.v]) min = edge;
                    }
                    min.ans = j - lazy[min.v];
                    lazy[tmp] = j;
                    ++tmpCount;
                }
                while (!positive.isEmpty() && X[positive.peek()] == j) {
                    int tmp = positive.poll();
                    Edge min = null;
                    for (Edge edge : graph.get(tmp)) {
                        if (min == null || lazy[edge.v] < lazy[min.v]) min = edge;
                    }
                    min.ans = j - lazy[min.v];
                    lazy[tmp] = j;
                    ++tmpCount;
                }
                count += tmpCount;
            }

            int[] ans = new int[D];
            Arrays.fill(ans, 1000000);
            for (List<Edge> edges : graph) {
                for (Edge edge : edges) {
                    ans[edge.index] = Math.min(ans[edge.index], edge.ans);
                }
            }
            out.print("Case #" + i + ":");
            for (int j : ans) out.print(" " + j);
            out.println();
        }
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) return true;
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return buflen > 0;
        }

        private byte readByte() {
            return hasNextByte() ? buffer[ptr++] : -1;
        }

        private static boolean isPrintableChar(byte c) {
            return 32 < c || c < 0;
        }

        private static boolean isNumber(int c) {
            return '0' <= c && c <= '9';
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            byte b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            try {
                byte b = readByte();
                if (b == '-') {
                    while (isNumber(b = readByte())) n = n * 10 + '0' - b;
                    return n;
                } else if (!isNumber(b)) throw new NumberFormatException();
                do n = n * 10 + b - '0'; while (isNumber(b = readByte()));
                return n;
            } catch (NoSuchElementException e) {
                return n;
            }
        }

        public int nextInt() {
            if (!hasNext()) throw new NoSuchElementException();
            int n = 0;
            try {
                byte b = readByte();
                if (b == '-') {
                    while (isNumber(b = readByte())) n = n * 10 + '0' - b;
                    return n;
                } else if (!isNumber(b)) throw new NumberFormatException();
                do n = n * 10 + b - '0'; while (isNumber(b = readByte()));
                return n;
            } catch (NoSuchElementException e) {
                return n;
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}