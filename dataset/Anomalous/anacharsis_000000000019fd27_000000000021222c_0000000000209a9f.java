import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private StringBuilder outputBuffer = new StringBuilder(16384);

    public void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();

        for (int i = 0; i < testCases; i++) {
            outputBuffer.append(String.format("Case #%d: ", i + 1));
            List<String> tokens = tokenize(reader.readLine().trim());

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

    private List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        char previousChar = 0;
        StringBuilder tokenBuffer = new StringBuilder(128);

        for (int i = 0; i < input.length(); i++) {
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

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }

    class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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
            String token = next();
            return token != null ? Integer.parseInt(token) : -1;
        }

        public long nextLong() {
            String token = next();
            return token != null ? Long.parseLong(token) : -1;
        }

        public double nextDouble() {
            String token = next();
            return token != null ? Double.parseDouble(token) : -1;
        }
    }
}