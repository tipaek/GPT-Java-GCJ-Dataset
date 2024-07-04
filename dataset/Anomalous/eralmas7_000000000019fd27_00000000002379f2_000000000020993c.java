import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

    private static final String CASE_PREFIX = "Case #";
    private static final String COLON = ": ";
    private static final String NEWLINE = "\n";

    public static void solve(Input input, PrintWriter output) throws IOException {
        int numberOfTestCases = input.nextInt();
        StringBuilder resultBuilder = new StringBuilder(2000 * numberOfTestCases);
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            resultBuilder.append(CASE_PREFIX).append(testCase).append(COLON);
            int n = input.nextInt();
            int trace = 0;
            int[][] rows = new int[n][n];
            int[][] cols = new int[n][n];
            
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int num = input.nextInt();
                    rows[r][num - 1]++;
                    cols[c][num - 1]++;
                    if (r == c) {
                        trace += num;
                    }
                }
            }

            int duplicateRows = 0, duplicateCols = 0;
            for (int r = 0; r < n; r++) {
                boolean rowDuplicateFound = false, colDuplicateFound = false;
                for (int c = 0; c < n; c++) {
                    if (rows[r][c] > 1 && !rowDuplicateFound) {
                        duplicateRows++;
                        rowDuplicateFound = true;
                    }
                    if (cols[r][c] > 1 && !colDuplicateFound) {
                        duplicateCols++;
                        colDuplicateFound = true;
                    }
                }
            }

            resultBuilder.append(trace).append(' ').append(duplicateRows).append(' ').append(duplicateCols).append(NEWLINE);
        }

        output.print(resultBuilder);
    }

    public static void main(String[] args) throws IOException {
        try (PrintWriter output = new PrintWriter(System.out);
             Input input = new Input(new BufferedReader(new InputStreamReader(System.in)))) {
            solve(input, output);
        }
    }

    private static class Input implements Closeable {
        private final BufferedReader reader;
        private final StringBuilder tokenBuilder = new StringBuilder();

        public Input(BufferedReader reader) {
            this.reader = reader;
        }

        public String next() throws IOException {
            tokenBuilder.setLength(0);
            int c;
            while ((c = reader.read()) != -1) {
                if (!Character.isWhitespace(c)) {
                    tokenBuilder.append((char) c);
                    break;
                }
            }
            while ((c = reader.read()) != -1 && !Character.isWhitespace(c)) {
                tokenBuilder.append((char) c);
            }
            return tokenBuilder.length() > 0 ? tokenBuilder.toString() : null;
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