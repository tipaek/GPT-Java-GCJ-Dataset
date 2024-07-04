import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader inputReader = new FastReader(System.in);
        int testCaseCount = inputReader.nextInt();
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String inputString = inputReader.next();
            String result = processInput(inputString);
            System.out.println(String.format("Case #%d: %s", testCase, result));
        }
    }

    private static String processInput(String input) {
        StringBuilder resultBuilder = new StringBuilder(input.length() * 3);
        int openBrackets = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = input.charAt(i) - '0';

            while (openBrackets > currentDigit) {
                resultBuilder.append(')');
                openBrackets--;
            }

            while (openBrackets < currentDigit) {
                resultBuilder.append('(');
                openBrackets++;
            }

            resultBuilder.append(input.charAt(i));
        }

        while (openBrackets > 0) {
            resultBuilder.append(')');
            openBrackets--;
        }

        return resultBuilder.toString();
    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}