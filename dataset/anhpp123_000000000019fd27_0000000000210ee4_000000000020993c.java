import java.io.*;
import java.util.*;


public class Solution{
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
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();
            String res = sol.solve(n, a);
            out.println("Case #" + tt + ": " + res);
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }
    public String solve(int n, int[][] a){
        int k = 0, r = 0, c = 0;
        for(int i = 0; i < n; i++) k += a[i][i];
        for(int i = 0; i < n; i++)
        {
            boolean [] set = new boolean[n + 1];
            for(int j = 0; j < n; j++)
            {
                if(set[a[i][j] - 1])
                {
                    r++;
                    break;
                }
                set[a[i][j] - 1] = true;
            }
        }
        for(int i = 0; i < n; i++)
        {
            boolean [] set = new boolean[n + 1];
            for(int j = 0; j < n; j++)
            {
                if(set[a[j][i] - 1])
                {
                    c++;
                    break;
                }
                set[a[j][i] - 1] = true;
            }
        }
        return k + " " + r + " " + c;
    }
    public long gcd(long a, long b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
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