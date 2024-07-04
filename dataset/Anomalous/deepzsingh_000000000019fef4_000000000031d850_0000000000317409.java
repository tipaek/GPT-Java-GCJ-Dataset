import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
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
            int cntx = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'S') {
                    cntx++;
                    if (cntx == y && x == y) {
                        sb.append(cntx);
                        break;
                    } else if (x != y && x + cntx == y) {
                        sb.append(cntx);
                        break;
                    }
                } else {
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }

            caseNumber++;
            System.out.println("Case #" + caseNumber + ": " + sb.toString());
        }
    }
}