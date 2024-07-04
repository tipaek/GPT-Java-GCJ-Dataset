import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();
        Solution sol = new Solution();

        for (int tt = 0; tt < t; tt++) {
            sol.solve(sc);
        }

        out.close();
    }

    public void solve(MyScanner sc) {
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                out.println(i + " " + j);
                out.flush();
                String response = sc.nextLine();
                if (response.equals("CENTER") || response.equals("WRONG")) {
                    return;
                }
            }
        }
    }

    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
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
}