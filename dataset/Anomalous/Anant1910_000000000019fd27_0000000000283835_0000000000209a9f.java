import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

class Solution {
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
        FastReader input = new FastReader();
        int T = input.nextInt();

        for (int t = 1; t <= T; t++) {
            String s = input.nextLine();
            StringBuilder result = new StringBuilder();
            int n = s.length();
            int openBrackets = 0;

            for (int i = 0; i < n; i++) {
                int currentDigit = Character.getNumericValue(s.charAt(i));

                while (openBrackets < currentDigit) {
                    result.append("(");
                    openBrackets++;
                }

                while (openBrackets > currentDigit) {
                    result.append(")");
                    openBrackets--;
                }

                result.append(currentDigit);
            }

            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}