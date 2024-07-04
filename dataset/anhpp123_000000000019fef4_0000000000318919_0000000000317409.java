import java.io.*;
import java.util.*;


public class Solution{
    StringBuilder sb = new StringBuilder();
    static HashMap <Character, Integer> map = new HashMap();
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int off = -1000000000;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -------------------------------------
        long MOD = 1000000007;
        int t = sc.nextInt();
        int tt = 0;
        map.put('N', 0);
        map.put('E', 1);
        map.put('S', 2);
        map.put('W', 3);
        Solution sol = new Solution();
        while(tt++ < t)
        {
            String res = sol.solve(sc);
            out.flush();
            out.println("Case #" + tt + ": " + res);
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }
    public String solve(MyScanner sc){
        int x = sc.nextInt(), y = sc.nextInt();
        String path = sc.next();
        int cnt = 1;
        for(char c : path.toCharArray())
        {
            int tmp = map.get(c);
            x += dir[tmp][0];
            y += dir[tmp][1];
            if(Math.abs(x) + Math.abs(y) <= cnt)
                return cnt + "";
            cnt++;
        }
        return "IMPOSSIBLE";
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