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
            int K = sc.nextInt();
            int Q = sc.nextInt();
            String s = sc.nextLine();
            char [] c =  s.toCharArray();
            int [] edge = new int[K];
            Arrays.fill(edge, -1);
            Stack <Integer> stack = new Stack<>();
            for(int i = 0; i < K; i++)
            {
                if(c[i] == '(')
                    stack.push(i);
                else
                {
                    int tmp = stack.pop();
                    edge[tmp] = i;
                    edge[i] = tmp;
                }
            }
            int L[] = new int[K], R[] = new int[K], P[] = new int[K];
            int S[] = new int[Q], E[] = new int[Q];
            int ans = 0;
            for(int i = 0; i < K; i++) L[i] = sc.nextInt();
            for(int i = 0; i < K; i++) R[i] = sc.nextInt();
            for(int i = 0; i < K; i++) P[i] = sc.nextInt();
            for(int i = 0; i < Q; i++) S[i] = sc.nextInt() - 1;
            for(int i = 0; i < Q; i++) E[i] = sc.nextInt() - 1;
            loop : for(int i = 0; i < Q; i++)  // BFS O(K* Q)
            {
                int res = 0;
                if(S[i] == E[i]) continue;
                boolean visited[] = new boolean[K];
                Queue<Integer> q = new LinkedList();
                visited[S[i]] = true;
                q.add(S[i]);
                while(!q.isEmpty())
                {
                    for(int j = q.size(); j > 0; j--)
                    {
                        int cur = q.poll();
                        if(cur == E[i] + 1 || cur == E[i] - 1 || edge[cur] == E[i]) {
                            ans += res + 1;
                            continue loop;
                        }
                        if(cur > 0 && !visited[cur - 1]) q.add(cur - 1);
                        if(cur < K - 1 && !visited[cur + 1]) q.add(cur + 1);
                        if(!visited[edge[cur]]) q.add(edge[cur]);
                    }
                    res++;
                }
            }
            out.println("Case #" + tt + ": " + ans);

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