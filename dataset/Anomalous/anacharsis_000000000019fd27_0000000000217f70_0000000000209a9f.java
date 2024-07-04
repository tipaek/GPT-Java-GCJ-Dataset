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
        new Solution().solve();
    }

    public void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();

        for (int t = 0; t < testCases; t++) {
            outputBuffer.append(String.format("Case #%d: ", t + 1));
            List<String> tokens = tokenize(reader.readLine().trim());

            String previousToken = null;
            for (String token : tokens) {
                int currentLevel = token.charAt(0) - '0';

                if (previousToken == null) {
                    appendCharacters('(', currentLevel);
                } else {
                    int previousLevel = previousToken.charAt(0) - '0';

                    if (previousLevel < currentLevel) {
                        appendCharacters('(', currentLevel - previousLevel);
                    } else {
                        appendCharacters(')', previousLevel - currentLevel);
                    }
                }

                outputBuffer.append(token);
                previousToken = token;
            }

            appendCharacters(')', previousToken.charAt(0) - '0');
            outputBuffer.append('\n');
        }

        System.out.print(outputBuffer);
    }

    private void appendCharacters(char character, int count) {
        for (int i = 0; i < count; i++) {
            outputBuffer.append(character);
        }
    }

    private List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        char lastChar = 0;
        StringBuilder tokenBuffer = new StringBuilder(128);

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar != lastChar && tokenBuffer.length() > 0) {
                tokens.add(tokenBuffer.toString());
                tokenBuffer.setLength(0);
            }

            tokenBuffer.append(currentChar);
            lastChar = currentChar;
        }

        if (tokenBuffer.length() > 0) {
            tokens.add(tokenBuffer.toString());
        }

        return tokens;
    }

    class InputReader {
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