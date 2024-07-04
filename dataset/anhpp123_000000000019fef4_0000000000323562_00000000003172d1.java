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
        Solution sol = new Solution();
        while(tt++ < t)
        {
            int res = sol.solve(sc);
            out.flush();
            out.println("Case #" + tt + ": " + res);
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }
    public int solve(MyScanner sc){
        int n = sc.nextInt();
        int d = sc.nextInt();
        Long [] A = new Long[n];
        int max = 0;
        long maxA = 0l;
        long minPair = 0x7f7f7f7f7f7f77f7L;
        HashMap<Long, Integer> cnt = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            A[i] = sc.nextLong();
            int tmp = cnt.getOrDefault(A[i], 0) + 1;
            cnt.put(A[i], tmp);
            max = Math.max(max, tmp);
            maxA = Math.max(maxA, A[i]);
            if(tmp >= 2)
                minPair = Math.min(minPair, A[i]);
        }
        if(d == 2)
        {
            return max < 2 ? 1 : 0;
        }
        else if(d == 3)
        {
            if(max >= 3) return 0;
            for(long i : A)
                if(cnt.containsKey(i * 2))
                    return 1;
            if(max == 2 && minPair < maxA) return 1;
            return 2;
        }
        for(int res = 0; res < d; res ++)
        {
            boolean valid = false;
            if(valid)
                return res;
        }
        return d - 1;

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