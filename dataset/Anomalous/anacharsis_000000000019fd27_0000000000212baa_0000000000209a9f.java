import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    private StringBuilder outputBuffer = new StringBuilder(16384);

    public static void main(String[] args) throws IOException {
        new Solution().processInput();
    }

    private void processInput() throws IOException {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();

        for (int t = 0; t < testCases; ++t) {
            outputBuffer.append(String.format("Case #%d: ", t + 1));
            List<String> tokens = splitTokens(reader.readLine().trim());

            for (String token : tokens) {
                if (token.charAt(0) == '1') {
                    outputBuffer.append('(').append(token).append(')');
                } else {
                    outputBuffer.append(token);
                }
            }
            outputBuffer.append('\n');
        }
        System.out.print(outputBuffer);
    }

    private List<String> splitTokens(String input) {
        List<String> tokens = new ArrayList<>();
        char previousChar = 0;
        StringBuilder tokenBuffer = new StringBuilder(128);

        for (int i = 0, length = input.length(); i < length; ++i) {
            char currentChar = input.charAt(i);

            if (currentChar != previousChar && tokenBuffer.length() > 0) {
                tokens.add(tokenBuffer.toString());
                tokenBuffer.setLength(0);
            }

            tokenBuffer.append(currentChar);
            previousChar = currentChar;
        }

        if (tokenBuffer.length() > 0) {
            tokens.add(tokenBuffer.toString());
        }

        return tokens;
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String readLine() throws IOException {
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