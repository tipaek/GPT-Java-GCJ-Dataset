import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String input = in.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(input.charAt(i));
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            out.printf("Case #%d: %s%n", t, result.toString());
        }

        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
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

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}