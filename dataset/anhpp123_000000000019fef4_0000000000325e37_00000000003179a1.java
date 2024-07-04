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
            sol.solve(sc);
            out.flush();
            //out.println("Case #" + tt + ": " + res);
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }
    public void solve(MyScanner sc){
        for(int i = -5; i <= 5; i ++ )
        {
            for(int j = -5; j <= 5; j++)
            {
                out.println(i + " " + j);
                out.flush();
                String response = sc.nextLine();
                if(response.equals("CENTER") || response.equals("WRONG")) return;
            }
        }
        int i0 = 0, i1 = 0;
        for(; i0 <= 100; i0 ++ )
        {
                out.println((i0 - off) + " " + 0);
                out.flush();
                String response = sc.nextLine();
                if(response.equals("HIT"))
                {
                    out.println((i0 - off) + " " + -1);
                    out.flush();
                    String res2 = sc.nextLine();
                    out.println((i0 - off) + " " + 1);
                    out.flush();
                    String res3 = sc.nextLine();
                    int a1 = res2.equals("HIT") ? 1 : 0, a2 = res3.equals("HIT") ? 1 : 0;
                    if(a1 == 0 && a2 == 0) {
                        out.println(0 + " " + (i1 - 50));
                        String res4 = sc.nextLine();
                        if(res4.equals("CENTER")) return;
                    }
                    break;
                }
        }
        for(; i1 <= 100; i1 ++ )
        {
            out.println(0 + " " + (i1 - off));
            out.flush();
            String response = sc.nextLine();
            if(response.equals("HIT"))
            {
                out.println(-1 + " " + (i1 - off));
                out.flush();
                String res2 = sc.nextLine();
                out.println(1 + " " + (i1 - off));
                out.flush();
                String res3 = sc.nextLine();
                int a1 = res2.equals("HIT") ? 1 : 0, a2 = res3.equals("HIT") ? 1 : 0;
                if(a1 == 0 && a2 == 0) {
                    out.println(0 + " " + (i1 - 50));
                    String res4 = sc.nextLine();
                    if(res4.equals("CENTER")) return;
                }
                break;
            }
        }
        out.println((i0 - 51) + " " + (i1 - 51));
        String res4 = sc.nextLine();
        if(res4.equals("CENTER")) return;
        out.println(-1234567890 + " " + 1234567890);
        String res3 = sc.nextLine();
        return;
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