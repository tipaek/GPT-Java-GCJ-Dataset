import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int testCases = io.getInt();
        
        for (int t = 1; t <= testCases; t++) {
            String input = io.getWord();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int digit = Character.getNumericValue(input.charAt(i));
                
                if (digit > currentDepth) {
                    for (int j = 0; j < digit - currentDepth; j++) {
                        result.append("(");
                    }
                } else if (digit < currentDepth) {
                    for (int j = 0; j < currentDepth - digit; j++) {
                        result.append(")");
                    }
                }
                result.append(digit);
                currentDepth = digit;
            }
            
            for (int j = 0; j < currentDepth; j++) {
                result.append(")");
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    private static class Kattio extends PrintWriter {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public Kattio(InputStream input) {
            super(new BufferedOutputStream(System.out));
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public Kattio(InputStream input, OutputStream output) {
            super(new BufferedOutputStream(output));
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }

        private String peekToken() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) return null;
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return tokenizer.nextToken();
        }

        private String nextToken() {
            String token = peekToken();
            tokenizer = null;
            return token;
        }
    }
}