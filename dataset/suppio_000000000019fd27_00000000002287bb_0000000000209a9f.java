import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private static class FastReader {
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

    public static void main(final String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            StringBuilder sb = new StringBuilder();
            String s = in.next();
            int previous = 0;
            int current = 0;

            for (int j = 0; j < s.length(); j++) {
                current = Integer.valueOf(s.charAt(j) - '0');
                if (current > previous) {
                    while (previous < current) {
                        sb.append('(');
                        previous++;
                    }
                    sb.append(current);
                } else if (current < previous) {
                    while (previous > current) {
                        sb.append(')');
                        previous--;
                    }
                    sb.append(current);
                } else {
                    sb.append(current);
                }
            }
            while (current > 0) {
                sb.append(')');
                current--;
            }
            out.println(sb.toString());
        }
    }
}
