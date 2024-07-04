import java.util.*;
import java.io.*;

public class Solution {
    public void run() throws Exception {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        for (int t = 0; t < testCases; t++) {
            String input = reader.next();
            StringBuilder result = new StringBuilder();
            int currentMax = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = Character.getNumericValue(input.charAt(i));
                if (digit > currentMax) {
                    result.append("(".repeat(digit - currentMax));
                    currentMax = digit;
                } else if (digit < currentMax) {
                    result.append(")".repeat(currentMax - digit));
                    currentMax = digit;
                }
                result.append(digit);
            }
            result.append(")".repeat(currentMax));
            System.out.println(result.toString());
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