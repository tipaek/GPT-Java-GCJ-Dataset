import java.io.*;
import java.util.*;


public class Solution{
    StringBuilder sb = new StringBuilder();
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
            int x = sc.nextInt(), y = sc.nextInt();
            long pow = 1l, cnt = 0l;
            while(pow <= Math.max(x, y)){
                pow <<= 1;
                cnt++;
            }
            cnt += 2;
            String res = sol.solve(x, y);
            out.println("Case #" + tt + ": " + res);
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }
    public String solve(int x, int y){
        for(int i = 1; i <= 32; i ++)
        {
            sb = new StringBuilder();
            boolean done = solvable(x, y, i);
            if(done) return sb.reverse().toString();
        }
        return "IMPOSSIBLE";
    }
    public boolean solvable(int x, int y, int cnt)
    {
        if(x == 0 && y == 0) return true;
        int lowx = x & 1, lowy = y & 1;
        if(cnt == 0 || (lowx ^ lowy) != 1)
            return false;
        if(lowy == 0)
        {
            if(solvable((x >> 1) + 1, y >> 1, cnt - 1))
            {
                sb.append('W');
                return true;
            }
            if(solvable(x >> 1, y >> 1, cnt - 1))
            {
                sb.append('E');
                return true;
            }
        }
        else if(lowx == 0)
        {
            if(solvable(x >> 1, (y >> 1) + 1, cnt - 1))
            {
                sb.append('S');
                return true;
            }
            if(solvable(x >> 1, y >> 1, cnt - 1))
            {
                sb.append('N');
                return true;
            }
        }
        return false;
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