import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = reader.next();
            int length = input.length();

            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (int i = 0; i < length; i++) {
                int digit = input.charAt(i) - '0';

                while (openParentheses < digit) {
                    result.append('(');
                    openParentheses++;
                }

                while (openParentheses > digit) {
                    result.append(')');
                    openParentheses--;
                }

                result.append(digit);
            }

            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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