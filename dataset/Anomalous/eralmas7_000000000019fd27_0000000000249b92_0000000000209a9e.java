import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

class Solution { // Rename class to Solution before submitting

    private static final String CASES = "Case #";
    private static final String COLON = ": ";
    private static final String NEWLINE = "\n";

    public static void solve(final Input input, final PrintStream output) throws IOException {
        final int numberOfTestCases = input.nextInt();
        final int bitCount = input.nextInt();
        final StringBuilder resultBuilder = new StringBuilder(2500 * numberOfTestCases);

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            resultBuilder.append(CASES).append(testCase).append(COLON);
            
            char[] carray = new char[bitCount];
            char[] parray = new char[bitCount];

            for (int i = 0; i < 15; i++) {
                for (int j = 1; j <= 10; j++) {
                    output.println(j);
                    carray[j - 1] = input.nextLine().charAt(0);
                }
                System.arraycopy(carray, 0, parray, 0, carray.length);
            }
            
            output.println(new String(carray));
            char response = input.nextLine().charAt(0);
            if (response == 'N') {
                return;
            }
            resultBuilder.append(NEWLINE);
        }
    }

    public static void main(final String[] args) throws IOException {
        try (final Input input = new Input(new BufferedReader(new InputStreamReader(System.in)))) {
            solve(input, System.out);
        }
    }

    private static class Input implements Closeable {

        private final BufferedReader bufferedReader;
        private final StringBuilder stringBuilder = new StringBuilder();

        public Input(final BufferedReader in) {
            this.bufferedReader = in;
        }

        public String nextLine() throws IOException {
            stringBuilder.setLength(0);
            int c;
            while ((c = bufferedReader.read()) != -1) {
                char ch = (char) c;
                if (ch != '\n' && ch != '\r') {
                    stringBuilder.append(ch);
                    break;
                }
            }
            while ((c = bufferedReader.read()) != -1) {
                char ch = (char) c;
                if (ch == '\n' || ch == '\r') {
                    break;
                }
                stringBuilder.append(ch);
            }
            return stringBuilder.toString();
        }

        public String next() throws IOException {
            stringBuilder.setLength(0);
            int c;
            while ((c = bufferedReader.read()) != -1) {
                char ch = (char) c;
                if (!Character.isWhitespace(ch)) {
                    stringBuilder.append(ch);
                    break;
                }
            }
            while ((c = bufferedReader.read()) != -1) {
                char ch = (char) c;
                if (Character.isWhitespace(ch)) {
                    break;
                }
                stringBuilder.append(ch);
            }
            return stringBuilder.toString();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        @Override
        public void close() throws IOException {
            bufferedReader.close();
        }
    }
}