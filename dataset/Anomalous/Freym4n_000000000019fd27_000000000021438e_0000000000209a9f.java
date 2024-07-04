import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        boolean ready() throws IOException {
            return reader.ready() || (tokenizer != null && tokenizer.hasMoreElements());
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int testCases = fr.nextInt();
        StringBuilder result = new StringBuilder();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = fr.next();
            input = "0" + input + "0";
            int length = input.length();
            int[] differences = new int[length];
            char[] digits = input.toCharArray();
            int[] values = new int[length];

            for (int i = 0; i < length - 1; i++) {
                int current = digits[i] - '0';
                int next = digits[i + 1] - '0';
                differences[i] = current - next;
                values[i] = current;
            }

            result.setLength(0); // Clear the result for each test case
            for (int i = 0; i < length - 1; i++) {
                if (differences[i] < 0) {
                    result.append("(".repeat(Math.abs(differences[i])));
                } else {
                    result.append(")".repeat(differences[i]));
                }
                if (i < length - 2) {
                    result.append(values[i + 1]);
                }
            }
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}