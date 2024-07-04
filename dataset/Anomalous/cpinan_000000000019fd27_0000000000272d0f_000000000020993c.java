import java.io.*;
import java.util.*;

/**
 * Created by cpinan on 6/16/17.
 */
public class Solution {

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

    private void solve() {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        PrintStream out = System.out;

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int K = 0;
            int R = 0;
            int C = 0;
            int[][] matrix = new int[N][N];

            for (int y = 0; y < N; y++) {
                Set<Integer> row = new HashSet<>();
                boolean rowDuplicate = false;
                for (int x = 0; x < N; x++) {
                    matrix[y][x] = in.nextInt();
                    if (x == y) K += matrix[y][x];
                    if (!rowDuplicate && !row.add(matrix[y][x])) {
                        R++;
                        rowDuplicate = true;
                    }
                }
            }

            for (int x = 0; x < N; x++) {
                Set<Integer> col = new HashSet<>();
                for (int y = 0; y < N; y++) {
                    if (!col.add(matrix[y][x])) {
                        C++;
                        break;
                    }
                }
            }

            out.printf("Case #%d: %d %d %d%n", t, K, R, C);
        }
        out.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}