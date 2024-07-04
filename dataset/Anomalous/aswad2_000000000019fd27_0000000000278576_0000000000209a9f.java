import java.util.*;
import java.io.*;

public class Solution {
    public void run() throws Exception {
        FastReader file = new FastReader();
        int testCases = file.nextInt();
        for (int caseNum = 0; caseNum < testCases; caseNum++) {
            String input = file.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                if (digit > currentDepth) {
                    result.append("(".repeat(digit - currentDepth));
                } else if (digit < currentDepth) {
                    result.append(")".repeat(currentDepth - digit));
                }
                result.append(digit);
                currentDepth = digit;
            }
            result.append(")".repeat(currentDepth));

            System.out.println("Case #" + (caseNum + 1) + ": " + result);
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
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