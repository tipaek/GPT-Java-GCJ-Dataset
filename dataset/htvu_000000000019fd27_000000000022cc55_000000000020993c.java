import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author htvu
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Vestigium solver = new Vestigium();
        solver.solve(1, in, out);
        out.close();
    }

    static class Vestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            int N = 110;
            int[][] grid = new int[N][N];

            for (int test = 1; test <= T; ++test) {
                int n = in.nextInt();
                for (int i = 0; i < n; ++i)
                    for (int j = 0; j < n; ++j)
                        grid[i][j] = in.nextInt();

                int r = 0, c = 0;
                boolean[] seen = new boolean[N];
                for (int i = 0; i < n; ++i) {
                    Arrays.fill(seen, false);
                    for (int j = 0; j < n; ++j) {
                        if (seen[grid[i][j]]) {
                            r++;
                            break;
                        }
                        seen[grid[i][j]] = true;
                    }
                }

                for (int j = 0; j < n; ++j) {
                    Arrays.fill(seen, false);
                    for (int i = 0; i < n; ++i) {
                        if (seen[grid[i][j]]) {
                            c++;
                            break;
                        }
                        seen[grid[i][j]] = true;
                    }
                }

                int sum = 0;
                for (int i = 0; i < n; ++i)
                    sum += grid[i][i];

                out.printf("Case #%d: %d %d %d\n", test, sum, r, c);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

