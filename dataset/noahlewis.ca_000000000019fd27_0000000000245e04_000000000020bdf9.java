import java.io.*;
import java.util.*;

public class Solution {
    public void solve() {
        int numberTests = reader.nextInt();

        for (int t = 1; t <= numberTests; t++) {
            int n = reader.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];

            for (int i = 0; i < n; i++) {
                start[i] = reader.nextInt();
                end[i] = reader.nextInt();
            }

            String res = schedule(n, start, end);
            writer.printf("Case #%d: %s\n", t, res);
        }
    }

    private String schedule(int n, int[] start, int[] end) {
        adj = new List[n];
        for (int v = 0; v < n; v++) adj[v] = new ArrayList<>();

        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                if (overlap(start[u], end[u], start[v], end[v])) {
                    adj[u].add(v);
                    adj[v].add(u);
                }
            }
        }

        col = new int[n];
        Arrays.fill(col, 0);

        for (int u = 0; u < n; u++) {
            if (col[u] == 0) {
                if (!color(u, 1)) return "IMPOSSIBLE";
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int u = 0; u < n; u++) {
            String who = (col[u] == 1 ? "C" : "J");
            sb.append(who);
        }

        return sb.toString();
    }

    private boolean color(int u, int c) {
        col[u] = c;

        for (int v : adj[u]) {
            if (col[v] == 0) {
                if (!color(v, 3 - c)) return false;
                continue;
            }

            if (col[v] == c) return false;
        }

        return true;
    }

    private boolean overlap(int s1, int e1, int s2, int e2) {
        if (s2 >= e1) return false;
        if (e2 <= s1) return false;
        return true;
    }

    private List<Integer>[] adj;
    private int[] col;

    private InputReader reader;
    private PrintWriter writer;

    public Solution(InputReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        Solution solution = new Solution(reader, writer);
        solution.solve();

        writer.flush();
    }

    static class InputReader {
        private static final int BUFFER_SIZE = 1 << 20;

        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), BUFFER_SIZE);
            tokenizer = null;
        }

        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }
    }
}