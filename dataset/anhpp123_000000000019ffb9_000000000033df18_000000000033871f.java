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
            out.print("Case #" + tt + ": ");
            int C = sc.nextInt(), D = sc.nextInt();
            HashMap <Integer, ArrayList<Integer>> map = new HashMap<>();
            int order[] = new int[C + 1];
            int time[] = new int[C + 1];
            Arrays.fill(order, -1);
            Arrays.fill(time, -1);
            ArrayList <Integer> times = new ArrayList();
            times.add(0);
            order[1] = time[1] = 0;
            int [] res = new int[D];
            int [] cnt = new int[C + 10];
            int max = 0;
            for(int i = 2; i <= C; i++) {
                int tmp = sc.nextInt();
                if(tmp < 0)
                {
                    order[i] = -tmp;
                    cnt[-tmp]++;
                    if(-tmp > max) max = -tmp;
                }
                else
                {
                    time[i] = tmp;
                    times.add(tmp);
                }
            }

            for(int i = 1; i <= max; i ++)
            {
                if(cnt[i] > 0);
                Collections.sort(times);
                int newTime = times.get(i - 1) + 1;
                for(int j = 0; j < cnt[i]; j++)
                    times.add(newTime);
                for(int j = 1; j <= C; j++)
                    if(order[j] == i)
                        time[j] = newTime;
            }
            for(int i = 0; i < D; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                res[i] = Math.max(1, Math.abs(time[u] - time[v]));
                out.print(res[i] + " ");
            }
            out.println();

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