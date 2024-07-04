import java.io.*;
import java.util.*;

public class Solution {
    public void solve() {
        int numberTests =reader.nextInt();
        for (int t = 1; t <= numberTests; t++) {
            int n = reader.nextInt();
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = reader.nextInt();
                }
            }

            int[] res = compute(n, a);
            writer.printf("Case #%d: %d %d %d\n", t, res[0], res[1], res[2]);
        }
    }

    private int[] compute(int n, int[][] a) {
        boolean[] existed = new boolean[n + 1];

        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < n; i++) {
            trace += a[i][i];
            Arrays.fill(existed, false);

            for (int j = 0; j < n; j++) {
                int val = a[i][j];

                if (existed[val]) {
                    duplicateRows++;
                    break;
                }

                existed[val] = true;
            }
        }

        for (int j = 0; j < n; j++) {
            Arrays.fill(existed, false);

            for (int i = 0; i < n; i++) {
                int val = a[i][j];

                if (existed[val]) {
                    duplicateCols++;
                    break;
                }

                existed[val] = true;
            }
        }

        return new int[]{trace, duplicateRows, duplicateCols};
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