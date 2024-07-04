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
            String S = sc.nextLine();
            String res = sol.solve(S);
            out.println("Case #" + tt + ": " + res);
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }
    public String solve(String S){
        int cur = 0;
        char cc[] = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : cc)
        {
            int depth =  c - '0';
            if(depth >= cur)
            {
                for(int i = cur; i < depth; i++)
                    sb.append('(');
            }
            else
            {
                for(int i = cur; i > depth; i--)
                    sb.append(')');
            }
            cur = depth;
            sb.append(c);
        }
        for(int i = cur; i > 0; i--)
            sb.append(')');
        return sb.toString();
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