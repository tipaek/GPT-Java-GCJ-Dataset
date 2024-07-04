import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = sc.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = sc.next();
            StringBuilder resultBuilder = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int targetDepth = inputString.charAt(i) - '0';

                while (currentDepth < targetDepth) {
                    resultBuilder.append('(');
                    currentDepth++;
                }

                while (currentDepth > targetDepth) {
                    resultBuilder.append(')');
                    currentDepth--;
                }

                resultBuilder.append(inputString.charAt(i));
            }

            while (currentDepth > 0) {
                resultBuilder.append(')');
                currentDepth--;
            }

            out.printf("Case #%d: %s\n", caseNumber, resultBuilder.toString());
        }
        out.close();
    }

    static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastScanner(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        public String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}