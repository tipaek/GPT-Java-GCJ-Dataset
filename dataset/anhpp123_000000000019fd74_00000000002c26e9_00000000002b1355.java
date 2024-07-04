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
            int n = sc.nextInt(), m = sc.nextInt();
            int [][] s = new int[n + 2][m + 2];
            for(int i = 0; i < n + 2; i ++)
                s[i][0] = s[i][m + 1] = -1;
            for(int j = 0; j < m + 2; j ++)
                s[0][j] = s[n + 1][j] = -1;
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= m; j++)
                    s[i][j] = sc.nextInt();
            TreeSet <Integer> row = new TreeSet();
            for(int i = 0; i < m + 2; i ++) row.add(i);
            TreeSet <Integer> col = new TreeSet();
            for(int i = 0; i < n + 2; i ++) col.add(i);
            TreeSet<Integer>[] rows = new TreeSet[n + 2];
            for(int i = 0; i < n + 2; i ++) rows[i] = (TreeSet)row.clone();
            TreeSet<Integer>[] cols = new TreeSet[m + 2];
            for(int j = 0; j < m + 2; j ++) cols[j] = (TreeSet)col.clone();
            long cnt = 1l, res = 0l, ans = 0l;
            while(cnt > 0)
            {
                cnt = 0l;
                boolean del [][] = new boolean[n + 1][m + 1];
                for(int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (s[i][j] == -1) continue;
                        ans += s[i][j];
                        int nei = 0, sum = 0;
                        int[][] neis = new int[][]{{i, rows[i].higher(j)}, {i, rows[i].lower(j)}, {cols[j].higher(i), j}, {cols[j].lower(i), j}};
                        for (int[] nnn : neis) {
                            if (s[nnn[0]][nnn[1]] != -1) {
                                nei++;
                                sum += s[nnn[0]][nnn[1]];
                            }
                        }
                        if (sum > s[i][j] * nei) {
                            del[i][j] = true;
                            cnt++;
                        }
                    }
                }
                for(int i = 1; i <= n; i++)
                    for(int j = 1; j <= m; j++)
                        if(del[i][j])
                        {
                            s[i][j] = -1;
                            rows[i].remove(j);
                            cols[j].remove(i);
                        }

            }
            out.println("Case #" + tt + ": " + ans);
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