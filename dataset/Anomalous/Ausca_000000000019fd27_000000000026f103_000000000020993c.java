import java.io.*;
import java.util.StringTokenizer;

public class Main {
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
        int sentinel = 1;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            int[] seen = new int[101];
            for (int t = 1; t <= T; t++) {
                int N = in.nextInt();
                int[][] matrix = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = in.nextInt();
                    }
                }
                int trace = 0, rowRep = 0, colRep = 0;
                for (int i = 0; i < N; i++) {
                    trace += matrix[i][i];
                }
                for (int row = 0; row < N; row++) {
                    boolean[] rowSeen = new boolean[101];
                    for (int col = 0; col < N; col++) {
                        if (rowSeen[matrix[row][col]]) {
                            rowRep++;
                            break;
                        }
                        rowSeen[matrix[row][col]] = true;
                    }
                }
                for (int col = 0; col < N; col++) {
                    boolean[] colSeen = new boolean[101];
                    for (int row = 0; row < N; row++) {
                        if (colSeen[matrix[row][col]]) {
                            colRep++;
                            break;
                        }
                        colSeen[matrix[row][col]] = true;
                    }
                }
                out.printf("Case #%d: %d %d %d%n", t, trace, rowRep, colRep);
            }
        }
    }

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
}