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
                p[i] = "" + sc.nextLine() + "";
            String r0 = "", r2 = "";
            ArrayList <String> r1 = new ArrayList();
            for(int i = 0; i < n; i++)
            {
                int ind1 = p[i].indexOf("*"), ind2 = p[i].lastIndexOf("*");
                String tmp0 = p[i].substring(0, ind1), tmp1 = p[i].substring(ind1, ind2), tmp2 = p[i].substring(ind2 + 1);

                if( (tmp0.length() <= r0.length() && !r0.startsWith(tmp0)) || (tmp0.length() >= r0.length() && !tmp0.startsWith(r0)))
                {
                    fault = true;
                    break;
                }
                if( (tmp2.length() <= r2.length() && !r2.endsWith(tmp2)) || (tmp2.length() >= r2.length() && !tmp2.endsWith(r2)))
                {
                    fault = true;
                    break;
                }
                if(tmp0.length() > r0.length())
                    r0 = tmp0;
                if(tmp2.length() > r2.length())
                    r2 = tmp2;
                if(tmp1.length() > 0) r1.add(tmp1);

            }
            String res = r0 + f(r1) + r2;
            if(fault) out.println("Case #" + tt + ": " + "*");
            else out.println("Case #" + tt + ": " + res);
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }
    public static String f(List<String> list)
    {
        StringBuilder sb = new StringBuilder();
        for(String s : list)
            sb.append(s);
        return sb.toString().replaceAll("\\*", "");
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