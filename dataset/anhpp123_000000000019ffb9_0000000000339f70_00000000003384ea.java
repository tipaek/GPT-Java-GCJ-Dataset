import java.io.*;
import java.util.*;


public class Solution{
    StringBuilder sb = new StringBuilder();
    int off = -1000000000;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -------------------------------------
        long MOD = 1000000007;
        int t = sc.nextInt();
        int tt = 0;
        Solution sol = new Solution();
        while(tt++ < t)
        {
            long l = sc.nextLong(), r = sc.nextLong();
            int LR = l >= r ? 0 : 1;
            long diff = Math.abs(l - r);
            long n = (long) (Math.pow(2 * diff + 0.25, 0.5) - 0.5);
            if(LR == 0) l -= (n * n + n) / 2;
            else r -= (n * n + n) / 2;
            LR = l >= r ? 0 : 1;
            if(l >= r) {
                long L = (long) (Math.ceil(Math.pow(l + n * n / 4.0, 0.5) - n / 2.0) - 5);
                long R = L - 10;
                if(L < 0) L = 0L;
                if(R < 0) R = 0L;
                for (; L < R + 10; L++)
                    if (L * n + L * L > l)
                        break;
                for (; R <= L + 10; R++)
                    if (R * n + R * R + R > r)
                        break;
                L--;
                R--;
                l -= L * n + L * L;
                r -= R * n + R * R + R;
                n += L + R;
                out.println("Case #" + tt + ": " + n + " " + l + " " + r);
            }
            else
            {
                long R = (long) (Math.ceil(Math.pow(l + n * n / 4.0, 0.5) - n / 2.0) - 5);
                long L = R - 10;
                if(L < 0) L = 0L;
                if(R < 0) R = 0L;
                for (; L < R + 10; L++)
                    if (L * n + L * L + L> l)
                        break;
                for (; R <= L + 10; R++)
                    if (R * n + R * R > r)
                        break;
                L--;
                R--;
                l -= L * n + L * L + L;
                r -= R * n + R * R;
                n += L + R;
                out.println("Case #" + tt + ": " + n + " " + l + " " + r);
            }
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }
    public int solve(MyScanner sc){
        int res = 0;
        return res;
    }
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
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
        String nextLine(){
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