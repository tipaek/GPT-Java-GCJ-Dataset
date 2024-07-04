import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;
            int previousDigit = 0;
            
            for (char currentChar : input.toCharArray()) {
                int currentDigit = currentChar - '0';
                int difference = currentDigit - previousDigit;
                
                if (difference > 0) {
                    for (int i = 0; i < difference; i++) {
                        result.append('(');
                    }
                } else if (difference < 0) {
                    for (int i = 0; i < -difference; i++) {
                        result.append(')');
                    }
                }
                
                result.append(currentChar);
                openParentheses += difference;
                previousDigit = currentDigit;
            }
            
            for (int i = 0; i < openParentheses; i++) {
                result.append(')');
            }
            
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
    
    static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        FastScanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
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
    }
}