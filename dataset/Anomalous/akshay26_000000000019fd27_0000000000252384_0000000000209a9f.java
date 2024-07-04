import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int testCases = sc.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String inputString = sc.next();
            char[] characters = inputString.toCharArray();
            int length = characters.length;
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();

            for (char c : characters) {
                int digit = c - '0';

                if (digit > currentDepth) {
                    for (int j = currentDepth; j < digit; j++) {
                        result.append("(");
                    }
                } else if (digit < currentDepth) {
                    for (int j = currentDepth; j > digit; j--) {
                        result.append(")");
                    }
                }

                result.append(c);
                currentDepth = digit;
            }

            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }

            System.out.println("Case #" + t + ": " + result);
        }
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