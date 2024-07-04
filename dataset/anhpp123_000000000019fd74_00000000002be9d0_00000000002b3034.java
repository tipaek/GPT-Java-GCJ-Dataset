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
            String [] p = new String[n];
            boolean fault = false;
            for(int i = 0; i < n; i++)
                p[i] = "#" + sc.nextLine() + "#";
            String r1 = "#", r2 = "#";
            for(int i = 0; i < n; i++)
            {
                String [] tmp = p[i].split("\\*");
                //System.out.println(Arrays.toString(tmp));
                if( (tmp[0].length() <= r1.length() && !r1.startsWith(tmp[0])) || (tmp[0].length() >= r1.length() && !tmp[0].startsWith(r1)))
                {
                    fault = true;
                    break;
                }
                if( (tmp[1].length() <= r2.length() && !r2.endsWith(tmp[1])) || (tmp[1].length() >= r2.length() && !tmp[1].endsWith(r2)))
                {
                    fault = true;
                    break;
                }
                if(tmp[0].length() > r1.length())
                    r1 = tmp[0];
                if(tmp[1].length() > r2.length())
                    r2 = tmp[1];
                if(r1.length() + r2.length() > 10000)
                {
                    fault = true;
                    break;
                }
            }
            String e1 =  "";
            String r0 = r1 + r2;
            if(fault) out.println("Case #" + tt + ": " + "*");
            else out.println("Case #" + tt + ": " + r0.substring(1, r0.length() - 1));
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }
    public String solve(int n, int[] s, int[] e){
        return "";
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