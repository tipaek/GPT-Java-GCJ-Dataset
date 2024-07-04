import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTests = sc.nextInt();

        for (int i = 0; i < numberOfTests; i++) {
            String line = sc.nextToken();
            List<Character> openBrackets = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < line.length(); j++) {
                int currentDigit = line.charAt(j) - '0';
                int openCount = currentDigit - openBrackets.size();

                for (int k = 0; k < openCount; k++) {
                    openBrackets.add('(');
                    result.append('(');
                }

                result.append(line.charAt(j));

                int closeCount = currentDigit;
                if (j < line.length() - 1) {
                    closeCount = currentDigit - (line.charAt(j + 1) - '0');
                }

                if (closeCount > 0) {
                    for (int k = 0; k < closeCount; k++) {
                        result.append(')');
                        openBrackets.remove(openBrackets.size() - 1);
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}