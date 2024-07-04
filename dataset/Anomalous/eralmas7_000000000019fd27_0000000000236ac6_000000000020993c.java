import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {

    private static final String CASE_PREFIX = "Case #";
    private static final String COLON = ": ";
    private static final String NEWLINE = "\n";

    public static void solve(final Input input, final PrintWriter output) throws IOException {
        final int numberOfTestCases = input.nextInt();
        final StringBuilder resultBuilder = new StringBuilder(2000 * numberOfTestCases);
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            resultBuilder.append(CASE_PREFIX).append(testCase).append(COLON);
            int n = input.nextInt();
            int diagonalSum = 0;
            int xorSum = 0;

            for (int i = 1; i <= n; i++) {
                xorSum ^= i;
            }

            int[] rowXor = new int[n];
            int[] colXor = new int[n];
            Arrays.fill(rowXor, xorSum);
            Arrays.fill(colXor, xorSum);

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int num = input.nextInt();
                    rowXor[r] ^= num;
                    colXor[c] ^= num;
                    if (r == c) {
                        diagonalSum += num;
                    }
                }
            }

            int rowErrors = 0;
            int colErrors = 0;
            for (int i = 0; i < n; i++) {
                if (rowXor[i] != 0) rowErrors++;
                if (colXor[i] != 0) colErrors++;
            }

            resultBuilder.append(diagonalSum).append(' ').append(rowErrors).append(' ').append(colErrors).append(NEWLINE);
        }
        output.println(resultBuilder);
    }

    public static void main(final String[] args) throws IOException {
        try (final PrintWriter output = new PrintWriter(System.out);
             final Input input = new Input(new BufferedReader(new InputStreamReader(System.in)))) {
            solve(input, output);
        }
    }

    private static class Input implements Closeable {

        private final BufferedReader reader;
        private final StringBuilder tokenBuilder = new StringBuilder();

        public Input(final BufferedReader reader) {
            this.reader = reader;
        }

        public String next() throws IOException {
            tokenBuilder.setLength(0);
            while (true) {
                int character = reader.read();
                if (character == -1) {
                    return null;
                }
                if (!Character.isWhitespace(character)) {
                    tokenBuilder.append((char) character);
                    break;
                }
            }
            while (true) {
                int character = reader.read();
                if (character == -1 || Character.isWhitespace(character)) {
                    break;
                }
                tokenBuilder.append((char) character);
            }
            return tokenBuilder.toString();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        @Override
        public void close() throws IOException {
            reader.close();
        }
    }
}