import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

        private static BufferedReader br;
        private static StringTokenizer st;

        private static void solve() throws IOException {
            int t = readInt();
            for (int i = 1; i <= t; ++i) {
                String s = next();
                int curr = 0;
                StringBuilder out = new StringBuilder();
                for (char c : s.toCharArray()) {
                    int n = c - '0';
                    if (curr < n) {
                        int curr2 = curr;
                        for (int j = 0; j < n-curr2; ++j, ++curr)
                            out.append('(');
                    }
                    else if (curr > n) {
                        int curr2 = curr;
                        for (int j = 0; j < curr2 - n; ++j, --curr)
                            out.append(')');
                    }
                    out.append(c);
                }
                for (int j = 0; j < curr; ++j)
                    out.append(')');
                System.out.println("Case #" + i + ": " + out);
            }
        }

        public static void main(String[] args) throws IOException {

            br = new BufferedReader(new InputStreamReader(System.in));
            solve();
        }

        static String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
            return st.nextToken();
        }

        static long readLong() throws IOException {
            return Long.parseLong(next());
        }

        static int readInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double readDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static char readCharacter() throws IOException {
            return next().charAt(0);
        }

        static String readLine() throws IOException {
            return br.readLine().trim();
        }
    }
