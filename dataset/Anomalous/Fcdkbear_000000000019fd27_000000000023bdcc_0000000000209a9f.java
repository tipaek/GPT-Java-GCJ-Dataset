import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastInput in = new FastInput(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = in.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String input = in.next();
            StringBuilder output = new StringBuilder();
            int currentBalance = 0;
            
            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                if (digit > currentBalance) {
                    output.append("(".repeat(digit - currentBalance));
                } else if (digit < currentBalance) {
                    output.append(")".repeat(currentBalance - digit));
                }
                output.append(ch);
                currentBalance = digit;
            }
            output.append(")".repeat(currentBalance));
            out.printf("Case #%d: %s\n", t, output.toString());
        }
        out.close();
    }

    static class FastInput {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastInput(InputStream stream) {
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