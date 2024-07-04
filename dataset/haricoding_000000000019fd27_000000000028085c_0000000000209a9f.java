import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    int openCount;

    public static void main(String[] args) {
        Solution ns = new Solution();
        FastReader reader = new FastReader();
        int count = reader.nextInt();
        for (int test = 1; test <= count; test++) {
            String S = reader.nextLine();
            StringBuilder sb = new StringBuilder();
            int prev = 0;
            for (int i = 0; i < S.length(); i++) {
                int cur = Character.getNumericValue(S.charAt(i));
                ns.addBrackets(sb, cur - prev >= 0, Math.abs(cur - prev));
                sb.append(S.charAt(i));
                prev = cur;
            }
            if (ns.openCount != 0) {
                ns.addBrackets(sb, false, ns.openCount);
            }
            System.out.println("Case #" + test + ": " + sb.toString());
        }
    }

    private void addBrackets(StringBuilder sb, boolean open, int count) {
        for (int i = 0; i < count; i++) {
            if (open) {
                sb.append('(');
                this.openCount++;
            } else {
                sb.append(')');
                this.openCount--;

            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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

