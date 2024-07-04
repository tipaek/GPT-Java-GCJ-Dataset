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
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        for (int j = 1; j <= T; j++) {
            String s = sc.nextLine();
            StringBuilder ans = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';

                while (currentDepth < digit) {
                    ans.append('(');
                    currentDepth++;
                }

                while (currentDepth > digit) {
                    ans.append(')');
                    currentDepth--;
                }

                ans.append(digit);
            }

            while (currentDepth > 0) {
                ans.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + j + ": " + ans);
        }
    }

    static class Pair {
        int x, y, z;

        public Pair(int a, int b, int c) {
            this.x = a;
            this.y = b;
            this.z = c;
        }
    }
}