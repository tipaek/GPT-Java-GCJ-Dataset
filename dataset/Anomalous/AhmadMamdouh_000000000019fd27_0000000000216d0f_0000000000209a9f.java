import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();
        int testCaseNumber = 1;

        while (testCases-- > 0) {
            char[] inputChars = reader.next().toCharArray();
            int[] digits = new int[inputChars.length];
            for (int i = 0; i < inputChars.length; i++) {
                digits[i] = inputChars[i] - '0';
            }

            StringBuilder output = new StringBuilder();
            int openParentheses = 0;

            for (int i = 0; i < digits.length; i++) {
                while (openParentheses < digits[i]) {
                    output.append('(');
                    openParentheses++;
                }
                while (openParentheses > digits[i]) {
                    output.append(')');
                    openParentheses--;
                }
                output.append(digits[i]);
            }

            while (openParentheses > 0) {
                output.append(')');
                openParentheses--;
            }

            System.out.printf("Case #%d: %s\n", testCaseNumber++, output.toString());
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}