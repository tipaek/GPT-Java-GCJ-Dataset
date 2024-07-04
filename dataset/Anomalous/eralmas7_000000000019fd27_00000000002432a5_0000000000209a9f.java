import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution { // Rename class to Solution before submitting

    private static final String CASES = "Case #";
    private static final String COLON = ": ";
    private static final String NEWLINE = "\n";

    private static void appendCharacters(int count, StringBuilder sb, char character) {
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
    }

    public static void solve(Input input, PrintWriter output) throws IOException {
        int numberOfTestCases = input.nextInt();
        StringBuilder resultBuilder = new StringBuilder(2500 * numberOfTestCases);
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            resultBuilder.append(CASES).append(testCase).append(COLON);
            String inputString = input.next();
            StringBuilder caseResult = new StringBuilder();
            
            char previousChar = inputString.charAt(0);
            appendCharacters(previousChar - '0', caseResult, '(');
            caseResult.append(previousChar);
            
            for (int i = 1; i < inputString.length(); i++) {
                char currentChar = inputString.charAt(i);
                int difference = previousChar - currentChar;
                
                if (difference < 0) {
                    appendCharacters(-difference, caseResult, '(');
                } else {
                    appendCharacters(difference, caseResult, ')');
                }
                
                caseResult.append(currentChar);
                previousChar = currentChar;
            }
            
            appendCharacters(previousChar - '0', caseResult, ')');
            resultBuilder.append(caseResult).append(NEWLINE);
        }
        
        output.println(resultBuilder);
    }

    public static void main(String[] args) throws IOException {
        try (PrintWriter output = new PrintWriter(System.out);
             Input input = new Input(new BufferedReader(new InputStreamReader(System.in)))) {
            solve(input, output);
        }
    }

    private static class Input implements Closeable {
        private final BufferedReader reader;
        private final StringBuilder sb = new StringBuilder();

        public Input(BufferedReader reader) {
            this.reader = reader;
        }

        public String next() throws IOException {
            sb.setLength(0);
            int c;
            
            while (true) {
                c = reader.read();
                if (c == -1) return null;
                if (!Character.isWhitespace(c)) {
                    sb.append((char) c);
                    break;
                }
            }
            
            while (true) {
                c = reader.read();
                if (c == -1 || Character.isWhitespace(c)) break;
                sb.append((char) c);
            }
            
            return sb.toString();
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