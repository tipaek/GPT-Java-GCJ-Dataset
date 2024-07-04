import java.io.*;
import java.util.*;

public class Solution {

    private String generateParentheses(String s) {
        int openCount = 0;
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            int digit = c - '0';

            while (openCount < digit) {
                result.append('(');
                openCount++;
            }
            while (openCount > digit) {
                result.append(')');
                openCount--;
            }
            result.append(digit);
        }

        while (openCount > 0) {
            result.append(')');
            openCount--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader inputReader = new InputReader(inputStream);
        PrintWriter outputWriter = new PrintWriter(outputStream);

        int testCases = inputReader.nextInt();
        for (int i = 0; i < testCases; i++) {
            String inputString = inputReader.next();
            String result = new Solution().generateParentheses(inputString);
            outputWriter.println(String.format("Case #%d: %s", i + 1, result));
        }

        outputWriter.close();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        public double[] nextDoubleArray(int n) {
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextDouble();
            }
            return array;
        }
    }
}