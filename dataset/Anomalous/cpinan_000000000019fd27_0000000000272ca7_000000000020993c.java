import java.io.*;
import java.util.*;

public class VestigiumCodeJam2020April {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

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

    private void solve() {
        InputReader in = new InputReader(System.in);
        PrintStream out = System.out;

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int K = 0, R = 0, C = 0;
            int[][] matrix = new int[N][N];

            for (int y = 0; y < N; y++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowDuplicate = false;
                for (int x = 0; x < N; x++) {
                    matrix[y][x] = in.nextInt();
                    if (x == y) {
                        K += matrix[y][x];
                    }
                    if (!rowDuplicate && !rowSet.add(matrix[y][x])) {
                        R++;
                        rowDuplicate = true;
                    }
                }
            }

            for (int x = 0; x < N; x++) {
                Set<Integer> colSet = new HashSet<>();
                for (int y = 0; y < N; y++) {
                    if (!colSet.add(matrix[y][x])) {
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
        new VestigiumCodeJam2020April().solve();
    }
}