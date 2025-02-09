import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static final int READ_FROM_FILE = 0;
    private static final int WRITE_TO_FILE = 0;
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "A-large.out";

    private String repeat(char c, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(c);
        }
        return result.toString();
    }

    private void run(InputReader in, PrintWriter out) {
        StringBuilder result = new StringBuilder();
        String inputString = in.next();
        int previousDigit = 0;
        
        for (int i = 0; i < inputString.length(); i++) {
            int currentDigit = inputString.charAt(i) - '0';
            if (currentDigit >= previousDigit) {
                result.append(repeat('(', currentDigit - previousDigit));
            } else {
                result.append(repeat(')', previousDigit - currentDigit));
            }
            result.append(inputString.charAt(i));
            previousDigit = currentDigit;
        }
        
        if (previousDigit > 0) {
            result.append(repeat(')', previousDigit));
        }
        
        out.print(result.toString());
    }

    public static void main(String[] args) {
        InputReader in;
        PrintWriter out;
        
        try {
            if (READ_FROM_FILE == 1) {
                in = new InputReader(new FileInputStream(INPUT_FILE));
            } else {
                in = new InputReader(System.in);
            }
            
            if (WRITE_TO_FILE == 1) {
                out = new PrintWriter(OUTPUT_FILE);
            } else {
                out = new PrintWriter(System.out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Solution solution = new Solution();
        int numberOfCases = in.nextInt();
        
        for (int i = 1; i <= numberOfCases; i++) {
            out.print("Case #" + i + ": ");
            solution.run(in, out);
            out.println();
        }

        out.flush();
        out.close();
    }

    private static class InputReader {
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

        public char nextCharacter() {
            return next().charAt(0);
        }
    }
}