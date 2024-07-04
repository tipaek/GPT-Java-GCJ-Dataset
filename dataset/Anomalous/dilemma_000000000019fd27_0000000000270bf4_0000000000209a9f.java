import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int testCases = in.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String inputString = in.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : inputString.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            out.printf("Case #%d: %s%n", caseNum, result.toString());
        }

        out.close();
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(File file) throws FileNotFoundException {
            reader = new BufferedReader(new FileReader(file));
        }

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
    }
}