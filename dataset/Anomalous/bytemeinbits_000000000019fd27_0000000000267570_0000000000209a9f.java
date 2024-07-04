import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
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
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        for (int test = 1; test <= t; test++) {
            String s = fr.nextLine();
            StringBuilder res = new StringBuilder();
            boolean isLeftOpen = false;

            for (char c : s.toCharArray()) {
                if (c == '1' && !isLeftOpen) {
                    res.append('(');
                    isLeftOpen = true;
                } else if (c == '0' && isLeftOpen) {
                    res.append(')');
                    isLeftOpen = false;
                }
                res.append(c);
            }

            if (s.endsWith("1") && isLeftOpen) {
                res.append(')');
            }

            System.out.println("Case #" + test + ": " + res);
        }
    }
}