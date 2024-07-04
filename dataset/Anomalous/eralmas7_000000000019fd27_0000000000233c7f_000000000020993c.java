import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

    private static final String CASE_PREFIX = "Case #";
    private static final String COLON = ": ";
    private static final String NEWLINE = "\n";

    public static void main(String[] args) throws IOException {
        try (PrintWriter output = new PrintWriter(System.out);
             Input input = new Input(new BufferedReader(new InputStreamReader(System.in)))) {
            processTestCases(input, output);
        }
    }

    public static void processTestCases(Input input, PrintWriter output) throws IOException {
        int testCaseCount = input.nextInt();
        StringBuilder resultBuilder = new StringBuilder(2500 * testCaseCount);

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            resultBuilder.append(CASE_PREFIX).append(testCase).append(COLON);
            int matrixSize = input.nextInt();
            int diagonalSum = 0, xorSum = 0;

            for (int i = 1; i <= matrixSize; i++) {
                xorSum ^= i;
            }

            int[] rowXors = new int[matrixSize];
            int[] colXors = new int[matrixSize];
            Arrays.fill(rowXors, xorSum);
            Arrays.fill(colXors, xorSum);

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = input.nextInt();
                    rowXors[row] ^= value;
                    colXors[col] ^= value;
                    if (row == col) {
                        diagonalSum += value;
                    }
                }
            }

            int nonZeroRowXors = 0, nonZeroColXors = 0;
            for (int i = 0; i < matrixSize; i++) {
                if (rowXors[i] != 0) nonZeroRowXors++;
                if (colXors[i] != 0) nonZeroColXors++;
            }

            resultBuilder.append(diagonalSum).append(' ')
                         .append(nonZeroRowXors).append(' ')
                         .append(nonZeroColXors).append(NEWLINE);
        }

        output.print(resultBuilder);
    }

    private static class Input implements Closeable {
        private final BufferedReader reader;
        private final StringBuilder tokenBuilder = new StringBuilder();

        public Input(BufferedReader reader) {
            this.reader = reader;
        }

        public String next() throws IOException {
            tokenBuilder.setLength(0);
            int character;
            while ((character = reader.read()) != -1) {
                if (!Character.isWhitespace(character)) {
                    tokenBuilder.append((char) character);
                    break;
                }
            }

            while ((character = reader.read()) != -1) {
                if (Character.isWhitespace(character)) {
                    break;
                }
                tokenBuilder.append((char) character);
            }

            return tokenBuilder.length() == 0 ? null : tokenBuilder.toString();
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