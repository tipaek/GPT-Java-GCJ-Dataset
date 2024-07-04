import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static class MyScanner {
        BufferedReader br;

        StringTokenizer st;


        public MyScanner() {
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
        MyScanner scanner = new MyScanner();
        int numCases = scanner.nextInt();
        for (int i = 1; i <= numCases; i++) {
            String s = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            int prev = 0, l = 0, r = 0;
            for (char c : s.toCharArray()) {
                int val = c - '0';
                int diff = val - prev;
                if (diff < 0) {
                    for (int j = 0; j < -diff; j++) sb.append(')');
                    r += -diff;
                }
                else if(diff > 0){
                    for (int j = 0; j < diff; j++) sb.append('(');
                    l += diff;
                }
                sb.append(c);
                prev = val;
            }
            while (r < l) {
                sb.append(')');
                r++;
            }

            System.out.format("Case #%d: %s\n", i, sb.toString());
        }
    }
}
