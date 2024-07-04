import java.io.*;
import java.util.*;

public class Solution {
    private StringBuilder sb = new StringBuilder();
    private static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        final long MOD = 1000000007;
        int t = sc.nextInt();
        Solution sol = new Solution();

        for (int tt = 1; tt <= t; tt++) {
            int R = sc.nextInt();
            int S = sc.nextInt();
            out.println("Case #" + tt + ": " + (R - 1) * (S - 1));
            sol.solve(R, S, sc);
        }

        out.close();
    }

    private void solve(int R, int S, MyScanner sc) {
        for (int i = R; i > 1; i--) {
            for (int j = 1; j < S; j++) {
                out.println(i * j + " " + (i - 1));
            }
        }
    }

    // MyScanner class for faster input
    private static class MyScanner {
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