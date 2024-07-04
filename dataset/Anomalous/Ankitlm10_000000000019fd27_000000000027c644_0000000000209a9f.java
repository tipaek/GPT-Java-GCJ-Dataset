import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
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
        FastReader sc = new FastReader();
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            String input = sc.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';

                while (openBrackets < currentDigit) {
                    result.append("(");
                    openBrackets++;
                }

                while (openBrackets > currentDigit) {
                    result.append(")");
                    openBrackets--;
                }

                result.append(input.charAt(i));
            }

            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}