import java.util.*;
import java.io.*;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            String input = next();
            char[] characters = input.toCharArray();
            int[] openBrackets = new int[characters.length];
            int[] closeBrackets = new int[characters.length + 1];
            boolean isOpen = false;

            for (int j = 0; j < characters.length; j++) {
                if (characters[j] == '0') {
                    characters[j] = '-';
                }
            }

            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < characters.length; j++) {
                    if (characters[j] == '-' && isOpen) {
                        isOpen = false;
                        closeBrackets[j]++;
                    }
                    if (characters[j] != '-' && !isOpen) {
                        isOpen = true;
                        openBrackets[j]++;
                    }
                    if (characters[j] == (char) (i + '0')) {
                        characters[j] = '-';
                    }
                }
                if (isOpen) {
                    closeBrackets[characters.length]++;
                    isOpen = false;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < characters.length; i++) {
                for (int j = 0; j < closeBrackets[i]; j++) {
                    result.append(')');
                }
                for (int j = 0; j < openBrackets[i]; j++) {
                    result.append('(');
                }
                result.append(input.charAt(i));
            }
            for (int i = 0; i < closeBrackets[characters.length]; i++) {
                result.append(')');
            }
            
            System.out.println("Case #" + caseNumber++ + ": " + result);
        }
    }

    private static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}