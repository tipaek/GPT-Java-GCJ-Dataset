import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    private StringBuilder resultBuffer = new StringBuilder(16384);

    public static void main(String[] args) throws IOException {
        new Solution().execute();
    }

    private void execute() throws IOException {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = reader.nextInt();
            int[][] matrix = new int[size][size];
            Set<Integer>[] uniqueElements = new Set[2 * size];

            for (int i = 0; i < 2 * size; i++) {
                uniqueElements[i] = new HashSet<>();
            }

            long trace = 0;
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = reader.nextInt();

                    if (row == col) {
                        trace += matrix[row][col];
                    }

                    uniqueElements[row].add(matrix[row][col]);
                    uniqueElements[size + col].add(matrix[row][col]);
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;
            for (int i = 0; i < size; i++) {
                if (uniqueElements[i].size() != size) {
                    duplicateRows++;
                }
                if (uniqueElements[size + i].size() != size) {
                    duplicateCols++;
                }
            }

            resultBuffer.append(String.format("Case #%d: %d %d %d\n", t, trace, duplicateRows, duplicateCols));
        }

        System.out.print(resultBuffer);
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
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