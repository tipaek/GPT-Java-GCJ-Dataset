import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
    }

    private void solve() {
        InputReader inputReader = new InputReader(System.in);
        PrintStream output = System.out;

        int testCases = inputReader.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String inputString = inputReader.next();
            StringBuilder resultBuilder = new StringBuilder();

            int openParentheses = 0;
            for (char character : inputString.toCharArray()) {
                int value = Character.getNumericValue(character);
                if (value == 0) {
                    if (openParentheses > 0) {
                        addClosingParentheses(openParentheses, resultBuilder);
                        openParentheses = 0;
                    }
                } else {
                    if (value >= openParentheses) {
                        addOpeningParentheses(value - openParentheses, resultBuilder);
                    } else {
                        addClosingParentheses(openParentheses - value, resultBuilder);
                    }
                    openParentheses = value;
                }
                resultBuilder.append(value);
            }
            addClosingParentheses(openParentheses, resultBuilder);

            output.print("Case #" + testCase + ": ");
            output.println(resultBuilder.toString());
            output.println();
        }
        output.close();
    }

    private void addOpeningParentheses(int count, StringBuilder builder) {
        for (int i = 0; i < count; i++) {
            builder.append('(');
        }
    }

    private void addClosingParentheses(int count, StringBuilder builder) {
        for (int i = 0; i < count; i++) {
            builder.append(')');
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}