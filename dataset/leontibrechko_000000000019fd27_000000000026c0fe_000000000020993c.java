import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Liavontsi Brechka
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
        InputReader in;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.in = in;

            int n = in.nextInt();
            int[][] grid = in.nextIntTable(n, n);
            boolean[][] rows = new boolean[n][n];
            boolean[][] cols = new boolean[n][n];
            long sum = 0;
            Set<Integer> r = new HashSet<>();
            Set<Integer> c = new HashSet<>();


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int next = grid[i][j] - 1;

                    if (i == j) sum += grid[i][j];

                    if (rows[i][next]) r.add(i);
                    else rows[i][next] = true;

                    if (cols[j][next]) c.add(j);
                    else cols[j][next] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", testNumber, sum, r.size(), c.size());
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int[][] nextIntTable(int rows, int columns) {
            int[][] table = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    table[i][j] = nextInt();
                }
            }
            return table;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}

