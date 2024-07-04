import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        Solution sol = new Solution();
        
        for (int tt = 1; tt <= t; tt++) {
            long l = sc.nextLong(), r = sc.nextLong();
            long diff = Math.abs(l - r);
            long n = (long) (Math.sqrt(2 * diff + 0.25) - 0.5);
            
            if (l >= r) {
                l -= (n * (n + 1)) / 2;
            } else {
                r -= (n * (n + 1)) / 2;
            }
            
            if (l >= r) {
                long[] result = calculateLR(n, l, r, true);
                l = result[0];
                r = result[1];
                n = result[2];
                out.println("Case #" + tt + ": " + n + " " + l + " " + r);
            } else {
                long[] result = calculateLR(n, l, r, false);
                l = result[0];
                r = result[1];
                n = result[2];
                out.println("Case #" + tt + ": " + n + " " + l + " " + r);
            }
        }
        out.close();
    }
    
    private static long[] calculateLR(long n, long l, long r, boolean isLGreater) {
        long L, R;
        if (isLGreater) {
            L = (long) (Math.ceil(Math.sqrt(l + n * n / 4.0) - n / 2.0) - 10);
            R = L - 10;
        } else {
            R = (long) (Math.ceil(Math.sqrt(l + n * n / 4.0) - n / 2.0) - 10);
            L = R - 10;
        }
        
        L = Math.max(L, 0);
        R = Math.max(R, 0);
        
        for (; L < R + 50; L++) {
            if (isLGreater ? L * n + L * L > l : L * n + L * L + L > l) {
                break;
            }
        }
        
        for (; R <= L + 50; R++) {
            if (isLGreater ? R * n + R * R + R > r : R * n + R * R > r) {
                break;
            }
        }
        
        L--;
        R--;
        
        if (isLGreater) {
            l -= L * n + L * L;
            r -= R * n + R * R + R;
        } else {
            l -= L * n + L * L + L;
            r -= R * n + R * R;
        }
        
        n += L + R;
        return new long[]{l, r, n};
    }

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        private final BufferedReader br;
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
}