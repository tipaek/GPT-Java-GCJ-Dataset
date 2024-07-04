import java.io.*;
import java.util.*;


public class Solution{
    public class Activity{
        int start, end, index;
        Activity(int s, int e, int i)
        {
            start = s;
            end = e;
            index = i;
        }
    }
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
            int [] s = new int[n], e = new int[n];
            for(int i = 0; i < n; i++)
            {
                s[i] = sc.nextInt();
                e[i] = sc.nextInt();
            }
            String res = sol.solve(n, s, e);
            out.println("Case #" + tt + ": " + res);
            //for(int ii = 0; ii <= n; ii++) System.out.println(Arrays.toString(dp[ii]));
        }
        out.close();
    }
    public String solve(int n, int[] s, int[] e){
        Activity [] a = new Activity[n];
        int [] assign = new int[n];
        char [] c = new char[n];
        for(int i = 0; i < n; i++)
            a[i] = new Activity(s[i], e[i], i);
        Arrays.sort(a, (a1, a2) -> a1.end != a2.end ? a1.end - a2.end : a1.start - a2.start);
        int t1 = 0, t2 = 0, sign = 1;
        for(Activity act : a)
        {
            if(act.start >= t2) {
                assign[act.index] = sign;
                t2 = act.end;
            }
            else if(act.start >= t1){
                assign[act.index] = 3 - sign;
                t1 = act.end;
                if(t1 > t2)
                {
                    int tmp = t1;
                    t1 = t2;
                    t2 = tmp;
                    sign = 3 - sign;
                }
            }
            else return "IMPOSSIBLE";
        }
        for(int i = 0; i < n; i++)
            c[i] = assign[i] == 1 ? 'C' : 'J';
        return new String(c);
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