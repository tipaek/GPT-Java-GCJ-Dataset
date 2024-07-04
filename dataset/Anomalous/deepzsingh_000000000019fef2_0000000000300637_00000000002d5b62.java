import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int dp[];

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
        int t = sc.nextInt();
        int caseNumber = 1;
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            StringBuilder result = new StringBuilder();

            if (Math.abs(x) == Math.abs(y)) {
                result.append("IMPOSSIBLE");
            } else if (x < y) {
                result.append("SEN");
            } else if (x > y) {
                result.append("NWS");
            } else if (x == 0 || (y == 0 && x >= 1)) {
                result.append("EE");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}