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
            String A = sc.next(), B = sc.next();
            char[] a = A.toCharArray(), b = B.toCharArray();
            int n = a.length, m = b.length;
            int[][] dp = new int[n + 1][m + 1];
            for(int i = 1; i <= n; i++) dp[i][0] = i;
            for(int j = 1; j <= m; j++) dp[0][j] = j;
            for(int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (a[i - 1] == b[j - 1])
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
            int half = dp[n][m] / 2;
            Stack <Character> stack = new Stack();
            int i0 = n, i1 = m;
            for(; i0 >= 0 && i1 >= 0 && half > 0;)
            {
                int tmp = dp[i0][i1];
                if(i0 == 0)
                {
                    i1--;
                    half--;
                }
                else if(i1 == 0)
                {
                    i0--;
                    half--;
                }
                else if(a[i0 - 1] == b[i1 - 1])
                {
                    stack.add(a[i0 - 1]);
                    i0--;
                    i1--;
                }
                else
                {
                    if(tmp == dp[i0 - 1][i1 - 1] + 1){
                        stack.add(b[i1 - 1]);
                        i0--;
                        i1--;
                    }
                    else if(tmp == dp[i0 - 1][i1] + 1){
                        i0--;
                    }
                    else if(tmp == dp[i0][i1 - 1] + 1){
                        stack.add(b[--i1]);
                    }
                    half--;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= i0; i++) sb.append(a[i - 1]);
            while(!stack.isEmpty()) sb.append(stack.pop());
            out.println("Case #" + tt + ": " + sb.toString());
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