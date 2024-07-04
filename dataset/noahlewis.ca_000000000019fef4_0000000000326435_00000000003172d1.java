import java.io.*;
import java.util.*;

public class Solution {

    public void solve() {
        int ntest = reader.nextInt();

        for (int test = 1; test <= ntest; test++) {
            int n = reader.nextInt();
            int d = reader.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = reader.nextLong();

            long answer = find(n, d, a);
            writer.printf("Case #%d: %d\n", test, answer);
        }
    }

    private long find(int n, int d, long[] a) {
        long res = d - 1;

        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= d-2; c++) {
                int p = c + 1;
                int want = d - p;

                Item[] items = new Item[n];
                int idx = 0;

                for (int j = 0; j < n; j++) {
                    if (j == i) continue;

                    long val = a[j] * p;
                    long pieces = val / a[i];
                    long cuts = (val % a[i] == 0) ? pieces - 1 : pieces;

                    idx++;
                    items[idx] = new Item(pieces, cuts);
                }

                long cnt = c + minCuts(want, items, n-1);
                res = Math.min(res, cnt);
            }
        }

        return res;
    }

    private long minCuts(int p, Item[] a, int n) {
        if (n == 0) return Integer.MAX_VALUE;

        long[][] dp = new long[n + 1][p + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= p; j++) {
                dp[i][j] = dp[i-1][j];

                for (int k = 1; k <= j && k < a[i].pieces; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k] + k);
                }

                int k = (int)Math.max(j - a[i].pieces, 0);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + a[i].cuts);
            }
        }

        return dp[n][p];
    }

    private static class Item {
        long pieces;
        long cuts;

        public Item(long pieces, long cuts) {
            this.pieces = pieces;
            this.cuts = cuts;
        }
    }

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

