import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private StringBuilder resultBuffer = new StringBuilder(16384);

    public void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = reader.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            Set<Integer>[] uniqueValuesTracker = new Set[2 * matrixSize];
            for (int i = 0; i < 2 * matrixSize; i++) {
                uniqueValuesTracker[i] = new HashSet<>();
            }

            long diagonalSum = 0;
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = reader.nextInt();

                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }

                    uniqueValuesTracker[row].add(matrix[row][col]);
                    uniqueValuesTracker[matrixSize + col].add(matrix[row][col]);
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;
            for (int i = 0; i < matrixSize; i++) {
                if (uniqueValuesTracker[i].size() != matrixSize) {
                    duplicateRows++;
                }
                if (uniqueValuesTracker[matrixSize + i].size() != matrixSize) {
                    duplicateCols++;
                }
            }

            resultBuffer.append(String.format("Case #%d: %d %d %d\n", t, diagonalSum, duplicateRows, duplicateCols));
        }

        System.out.print(resultBuffer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }

    static class InputReader {
        private BufferedReader bufferedReader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            bufferedReader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return bufferedReader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    return null;
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}