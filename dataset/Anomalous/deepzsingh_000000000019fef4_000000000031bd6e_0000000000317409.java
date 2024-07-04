import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static Integer n, arr[];
    static final long MOD = 998244353;

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
        int caseNumber = 0;

        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            StringBuilder sb = new StringBuilder();

            if (s.length() == 1 && y > x) {
                sb.append(y - x);
            } else {
                boolean appended = false;
                for (int i = 0; i < s.length() - 1; i++) {
                    if (x == y && s.charAt(i) == s.charAt(i + 1)) {
                        sb.append(x);
                        appended = true;
                        break;
                    } else if (y > x && s.charAt(i) == s.charAt(i + 1)) {
                        sb.append(y - x);
                        appended = true;
                        break;
                    }
                }
                if (!appended) {
                    sb.append("IMPOSSIBLE");
                }
            }

            caseNumber++;
            System.out.println("Case #" + caseNumber + ": " + sb.toString());
        }
    }
}