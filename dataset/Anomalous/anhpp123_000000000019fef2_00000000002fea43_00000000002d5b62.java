import java.io.*;
import java.util.*;

public class Solution {
    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        final long MOD = 1000000007;
        int t = sc.nextInt();
        Solution sol = new Solution();

        for (int tt = 1; tt <= t; tt++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            long pow = 1L, cnt = 0L;

            while (pow <= Math.max(x, y)) {
                pow <<= 1;
                cnt++;
            }
            cnt += 2;

            String res = sol.solve(x, y);
            out.println("Case #" + tt + ": " + res);
        }
        out.close();
    }

    public String solve(int x, int y) {
        for (int i = 1; i <= 32; i++) {
            sb = new StringBuilder();
            if (solvable(x, y, i)) {
                return sb.reverse().toString();
            }
        }
        return "IMPOSSIBLE";
    }

    private boolean solvable(int x, int y, int cnt) {
        if (x == 0 && y == 0) return true;

        int lowx = x & 1;
        int lowy = y & 1;

        if (cnt == 0 || (lowx ^ lowy) != 1) return false;

        if (lowy == 0) {
            if (solvable((x >> 1) + 1, y >> 1, cnt - 1)) {
                sb.append('W');
                return true;
            }
            if (solvable(x >> 1, y >> 1, cnt - 1)) {
                sb.append('E');
                return true;
            }
        } else if (lowx == 0) {
            if (solvable(x >> 1, (y >> 1) + 1, cnt - 1)) {
                sb.append('S');
                return true;
            }
            if (solvable(x >> 1, y >> 1, cnt - 1)) {
                sb.append('N');
                return true;
            }
        }
        return false;
    }

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

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
    //--------------------------------------------------------
}