import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner scanner = new FastScanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        VestigiumSolver solver = new VestigiumSolver();
        solver.solve(1, scanner, writer);
        writer.close();
    }

    static class VestigiumSolver {
        public void solve(int testNumber, FastScanner scanner, PrintWriter writer) {
            int numTests = scanner.nextInt();
            for (int test = 1; test <= numTests; test++) {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                int[][] transposedMatrix = new int[n][n];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int value = scanner.nextInt();
                        matrix[i][j] = value;
                        transposedMatrix[j][i] = value;
                    }
                }

                int trace = calculateTrace(matrix, n);
                int rowDuplicates = countDuplicates(matrix, n);
                int colDuplicates = countDuplicates(transposedMatrix, n);

                writer.printf("Case #%d: %d %d %d\n", test, trace, rowDuplicates, colDuplicates);
            }
        }

        private int calculateTrace(int[][] matrix, int n) {
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            return trace;
        }

        private int countDuplicates(int[][] matrix, int n) {
            int duplicateCount = 0;
            for (int[] row : matrix) {
                Arrays.sort(row);
                for (int i = 0; i < n - 1; i++) {
                    if (row[i] == row[i + 1]) {
                        duplicateCount++;
                        break;
                    }
                }
            }
            return duplicateCount;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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