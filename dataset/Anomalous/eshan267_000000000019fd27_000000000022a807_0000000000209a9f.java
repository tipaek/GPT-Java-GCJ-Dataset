import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        FastReader sc = new FastReader();
        StringBuilder result = new StringBuilder();
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            StringBuilder caseResult = new StringBuilder();
            char prevChar = s.charAt(0);
            int prevDigit = prevChar - '0';

            for (int j = 0; j < prevDigit; j++) {
                caseResult.append("(");
            }
            caseResult.append(prevChar);

            for (int k = 1; k < s.length(); k++) {
                char currentChar = s.charAt(k);
                int currentDigit = currentChar - '0';

                if (currentDigit > prevDigit) {
                    for (int j = 0; j < currentDigit - prevDigit; j++) {
                        caseResult.append("(");
                    }
                } else if (currentDigit < prevDigit) {
                    for (int j = 0; j < prevDigit - currentDigit; j++) {
                        caseResult.append(")");
                    }
                }
                caseResult.append(currentChar);
                prevDigit = currentDigit;
            }

            for (int j = 0; j < prevDigit; j++) {
                caseResult.append(")");
            }

            result.append("Case #").append(i + 1).append(": ").append(caseResult).append("\n");
        }
        
        System.out.print(result);
    }
}