import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            System.out.print("Case #" + caseNumber + ": ");
            
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '1') {
                    System.out.print("(");
                    while (i < input.length() && input.charAt(i) == '1') {
                        System.out.print(input.charAt(i));
                        i++;
                    }
                    System.out.print(")");
                    i--; // Adjust index after inner loop
                } else {
                    System.out.print(input.charAt(i));
                }
            }
            System.out.println();
        }
    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String line = "";
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}