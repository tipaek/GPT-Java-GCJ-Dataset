import java.io.*;
import java.util.StringTokenizer;

public class Vestigium {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    static class Solver {

        private static final int NMax = 100;
        private InputReader in;
        private PrintWriter out;

        public void solve(InputReader in, PrintWriter out) {
            this.in = in;
            this.out = out;

            int[][] matrix = new int[NMax][NMax];
            int testCases = in.readInt();

            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                int n = in.readInt();
                readMatrix(n, n, matrix);

                int trace = 0;
                int rowDuplicates = 0;
                int colDuplicates = 0;

                for (int i = 0; i < n; i++) {
                    trace += matrix[i][i];
                    if (!hasAllDistinct(matrix, n, i, 0, 0, 1)) rowDuplicates++;
                    if (!hasAllDistinct(matrix, n, 0, 1, i, 0)) colDuplicates++;
                }

                out.printf("Case #%d: %d %d %d%n", caseNum, trace, rowDuplicates, colDuplicates);
            }
        }

        private void readMatrix(int rows, int cols, int[][] matrix) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = in.readInt();
                }
            }
        }

        private boolean hasAllDistinct(int[][] matrix, int n, int x, int dx, int y, int dy) {
            boolean[] seen = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                int value = matrix[x][y];
                if (seen[value]) return false;
                seen[value] = true;
                x += dx;
                y += dy;
            }
            return true;
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(next());
        }

        public long readLong() {
            return Long.parseLong(next());
        }
    }
}