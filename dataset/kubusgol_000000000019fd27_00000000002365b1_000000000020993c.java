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
        Vestigium solver = new Vestigium();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Vestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int[][] cnt_rows = new int[N + 1][N + 1];
            int[][] cnt_cols = new int[N + 1][N + 1];
            boolean[] dup_row = new boolean[N];
            boolean[] dup_col = new boolean[N];
            int ans_row = 0;
            int ans_col = 0;
            int trace = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int val = in.nextInt();
                    if (r == c) {
                        trace += val;
                    }
                    if (++cnt_rows[r][val] > 1) {
                        if (!dup_row[r]) {
                            ans_row++;
                        }
                        dup_row[r] = true;
                    }
                    if (++cnt_cols[c][val] > 1) {
                        if (!dup_col[c]) {
                            ans_col++;
                        }
                        dup_col[c] = true;
                    }
                }
            }

            out.println("Case #" + testNumber + ": " + trace + " " + ans_row + " " + ans_col);
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

