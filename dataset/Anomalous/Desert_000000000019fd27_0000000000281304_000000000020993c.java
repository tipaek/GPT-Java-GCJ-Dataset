import java.io.*;
import java.util.*;

public class Solution {

    private String calculateResult(int[][] matrix) {
        int duplicateRows = 0;
        int duplicateCols = 0;
        int diagonalSum = 0;

        int n = matrix.length;

        // Calculate duplicate rows
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (seen[value]) {
                    duplicateRows++;
                    break;
                }
                seen[value] = true;
            }
        }

        // Calculate duplicate columns
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                int value = matrix[j][i];
                if (seen[value]) {
                    duplicateCols++;
                    break;
                }
                seen[value] = true;
            }
        }

        // Calculate diagonal sum
        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
        }

        return diagonalSum + " " + duplicateRows + " " + duplicateCols;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int testCount = in.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                matrix[j] = in.nextIntArray(n);
            }

            writeTestCase(out, i + 1, new Solution().calculateResult(matrix));
        }

        out.close();
    }

    static void writeTestCase(PrintWriter writer, int testCaseNumber, String result) {
        writer.printf("Case #%d: %s%n", testCaseNumber, result);
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }
    }
}