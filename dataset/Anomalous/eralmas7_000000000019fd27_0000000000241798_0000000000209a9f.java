import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

    private static final String CASE_PREFIX = "Case #";
    private static final String COLON = ": ";
    private static final String NEWLINE = "\n";

    private static void appendCharacters(int count, StringBuilder sb, char ch) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }

    public static void solve(final Input input, final PrintWriter output) throws IOException {
        final int numberOfTestCases = input.nextInt();
        final StringBuilder resultBuilder = new StringBuilder(2500 * numberOfTestCases);

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            resultBuilder.append(CASE_PREFIX);
            resultBuilder.append(testCase);
            resultBuilder.append(COLON);

            String inputString = input.next();
            StringBuilder caseResult = new StringBuilder();
            char previousChar = inputString.charAt(0);

            appendCharacters(previousChar - '0', caseResult, '(');
            caseResult.append(previousChar);

            for (int i = 1; i < inputString.length(); i++) {
                char currentChar = inputString.charAt(i);
                if (currentChar == previousChar) {
                    caseResult.append(currentChar);
                } else {
                    appendCharacters(previousChar - '0', caseResult, ')');
                    if (currentChar != '0') {
                        appendCharacters(currentChar - '0', caseResult, '(');
                    }
                    caseResult.append(currentChar);
                }
                previousChar = currentChar;
            }

            appendCharacters(previousChar - '0', caseResult, ')');
            resultBuilder.append(caseResult);
            resultBuilder.append(NEWLINE);
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
                int c = reader.read();
                if (c == -1) {
                    return null;
                }
                if (!Character.isWhitespace(c)) {
                    tokenBuilder.append((char) c);
                    break;
                }
            }
            while (true) {
                int c = reader.read();
                if (c == -1 || Character.isWhitespace(c)) {
                    break;
                }
                tokenBuilder.append((char) c);
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