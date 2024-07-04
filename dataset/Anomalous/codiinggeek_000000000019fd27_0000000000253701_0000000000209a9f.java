import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            String input = reader.next();
            int openBrackets = 0;
            StringBuilder result = new StringBuilder();

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';

                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    result.append(')');
                    openBrackets--;
                }

                result.append(digit);
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
    }
}