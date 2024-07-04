import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 0; t < testCases; t++) {
            String input = reader.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = Character.getNumericValue(input.charAt(0));
            int closeBrackets = Character.getNumericValue(input.charAt(input.length() - 1));

            for (int i = 0; i < openBrackets; i++) {
                result.append('(');
            }

            for (int i = 0; i < input.length(); i++) {
                result.append(input.charAt(i));
                int currentNum = Character.getNumericValue(input.charAt(i));
                int nextNum = (i < input.length() - 1) ? Character.getNumericValue(input.charAt(i + 1)) : 0;
                char bracket = (currentNum < nextNum) ? '(' : ')';
                int difference = Math.abs(currentNum - nextNum);

                for (int j = 0; j < difference; j++) {
                    result.append(bracket);
                }
            }

            for (int i = 0; i < closeBrackets; i++) {
                result.append(')');
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}