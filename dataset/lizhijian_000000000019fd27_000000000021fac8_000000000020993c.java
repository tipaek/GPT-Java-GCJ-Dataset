import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(in, out);
        out.close();
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int k = 1; k <= t; ++k) {
                int n = in.nextInt();
                int[][] m = new int[n][n];
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) { m[i][j] = in.nextInt(); }
                }
                int sum = 0;
                for (int i = 0; i < n; ++i) { sum += m[i][i]; }
                boolean[] flag = new boolean[n + 1];
                int row = 0;
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j <= n; ++j) { flag[j] = false; }
                    for (int j = 0; j < n; ++j) {
                        if (flag[m[i][j]]) { row += 1; break; }
                        flag[m[i][j]] = true;
                    }
                }
                int col = 0;
                for (int j = 0; j < n; ++j) {
                    for (int i = 0; i <= n; ++i) { flag[i] = false; }
                    for (int i = 0; i < n; ++i) {
                        if (flag[m[i][j]]) { col += 1; break; }
                        flag[m[i][j]] = true;
                    }
                }
                out.printf("Case #%d: %d %d %d\n", k, sum, row, col);
            }
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
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}