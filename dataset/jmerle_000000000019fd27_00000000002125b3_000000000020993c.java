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
 *
 * @author Jasper van Merle
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
            int n = in.nextInt();

            int[][] matrix = new int[n][n];

            for (int y = 0; y < n; y++) {
                matrix[y] = new int[n];
                for (int x = 0; x < n; x++) {
                    matrix[y][x] = in.nextInt();
                }
            }

            int sum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int x = 0, y = 0; x < n; x++, y++) {
                sum += matrix[y][x];
            }

            outer:
            for (int y = 0; y < n; y++) {
                boolean[] rowCache = new boolean[n];

                for (int x = 0; x < n; x++) {
                    int num = matrix[y][x] - 1;

                    if (rowCache[num]) {
                        rowDuplicates++;
                        continue outer;
                    }

                    rowCache[num] = true;
                }
            }

            outer:
            for (int x = 0; x < n; x++) {
                boolean[] colCache = new boolean[n];

                for (int y = 0; y < n; y++) {
                    int num = matrix[y][x] - 1;

                    if (colCache[num]) {
                        colDuplicates++;
                        continue outer;
                    }

                    colCache[num] = true;
                }
            }

            out.println(String.format("Case #%s: %s %s %s", testNumber, sum, rowDuplicates, colDuplicates));
        }

    }

    static class InputReader {
        private BufferedReader br;
        private StringTokenizer st;

        public InputReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

