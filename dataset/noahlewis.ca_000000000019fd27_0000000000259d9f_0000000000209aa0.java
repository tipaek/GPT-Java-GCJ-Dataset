import java.io.*;
import java.util.*;

public class Solution {
    public void solve() {
        real();
    }

    private void real() {
        int numberTests = reader.nextInt();

        for (int t = 1; t <= numberTests; t++) {
            int n = reader.nextInt();
            int k = reader.nextInt();

            int[][] a = latinSquare(n, k);
            if (a == null) {
                writer.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                writer.printf("Case #%d: POSSIBLE\n", t);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) writer.printf("%d ", a[i][j]);
                    writer.println();
                }
            }
        }
    }

    private void test() {
        int n = 6;
        int min = n + 2;
        int max = n * n;

        for (int k = min; k <= max; k++) {
            System.out.println("searching: " + k);
            int[][] a = latinSquare(n, k);
            if (a == null) {
                System.out.println("-> not found: " + n + " " + k);
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) System.out.printf("%d ", a[i][j]);
                    System.out.println();
                }
            }
        }
    }

    private int[][] latinSquare(int n, int k) {
        this.n = n;
        this.m = n * n;

        a = new int[n][n];
        hcol = new boolean[n][n + 1];
        hrow = new boolean[n][n + 1];

        row = new int[m];
        col = new int[m];
        int x = 0;

        for (int i = 0; i < n; i++) {
            row[x] = 0;
            col[x] = i;
            x++;
        }

        for (int i = 1; i < n; i++) {
            row[x] = i;
            col[x] = 0;
            x++;
        }

        for (int i = 1; i < n; i++) {
            row[x] = i;
            col[x] = i;
            x++;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i == j) continue;
                row[x] = i;
                col[x] = j;
                x++;
            }
        }

        if (!find(0, n, k)) return null;
        return a;
    }

    private boolean find(int idx, int rem, int sum) {
        if (sum < 0) return false;
        if (rem <= 0 && sum > 0) return false;
        if (idx >= m) return sum == 0;

        int r = row[idx];
        int c = col[idx];

        for (int val = 1; val <= n; val++) {
            if (hrow[r][val] || hcol[c][val]) continue;

            int drem = 0;
            int dsum = 0;
            if (r == c) {
                drem = 1;
                dsum = val;
            }

            a[r][c] = val;
            hrow[r][val] = true;
            hcol[c][val] = true;

            if (find(idx + 1, rem - drem, sum - dsum)) return true;

            a[r][c] = 0;
            hrow[r][val] = false;
            hcol[c][val] = false;
        }

        return false;
    }

    private int n;
    private int m;
    private int[][] a;
    private boolean[][] hcol;
    private boolean[][] hrow;
    private int[] row;
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

