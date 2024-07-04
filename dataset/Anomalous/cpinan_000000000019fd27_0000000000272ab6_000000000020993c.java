import java.io.*;
import java.util.*;

public class VestigiumCodeJam2020April {

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        PrintStream out = System.out;

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowCount = 0, colCount = 0;

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowDuplicate = false;
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j) trace += matrix[i][j];
                    if (!rowDuplicate && !rowSet.add(matrix[i][j])) {
                        rowCount++;
                        rowDuplicate = true;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colCount++;
                        break;
                    }
                }
            }

            out.printf("Case #%d: %d %d %d%n", t, trace, rowCount, colCount);
        }
        out.close();
    }

    public static void main(String[] args) {
        new VestigiumCodeJam2020April().solve();
    }
}