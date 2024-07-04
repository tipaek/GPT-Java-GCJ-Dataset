import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        int caseNumber = 1;
        StringBuilder output = new StringBuilder();

        while (t-- > 0) {
            String n = fr.next() + "$";
            char[] chars = n.toCharArray();
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();

            for (char c : chars) {
                int digit = c - '0';
                if (digit == 0) {
                    appendClosingBrackets(result, currentDepth);
                    result.append(0);
                    currentDepth = 0;
                } else if (digit > currentDepth) {
                    appendOpeningBrackets(result, digit - currentDepth);
                    result.append(digit);
                    currentDepth = digit;
                } else if (digit < currentDepth) {
                    appendClosingBrackets(result, currentDepth - digit);
                    result.append(digit);
                    currentDepth = digit;
                } else {
                    result.append(digit);
                }
            }

            output.append("Case #").append(caseNumber).append(": ").append(result).append('\n');
            caseNumber++;
        }

        System.out.print(output);
    }

    private static void appendOpeningBrackets(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append('(');
        }
    }

    private static void appendClosingBrackets(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(')');
        }
    }
}