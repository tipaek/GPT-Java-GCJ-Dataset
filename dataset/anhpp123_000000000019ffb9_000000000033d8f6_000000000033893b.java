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
            int [] edge = new int[K + 1];
            Arrays.fill(edge, -1);
            Stack <Integer> stack = new Stack<>();
            for(int i = 0; i < K; i++)
            {
                if(c[i] == '(')
                    stack.push(i);
                else
                {
                    int tmp = stack.pop();
                    edge[tmp + 1] = i + 1;
                    edge[i + 1] = tmp + 1;
                }
            }
            int ttt = 0;
            //int L[] = new int[K + 1], R[] = new int[K + 1], P[] = new int[K + 1];
            int S[] = new int[Q + 1];//, E[] = new int[Q + 1];
            int ans = 0;
            /*
            for(int i = 0; i < K; i++) L[i] = sc.nextInt();
            for(int i = 0; i < K; i++) R[i] = sc.nextInt();
            for(int i = 0; i < K; i++) P[i] = sc.nextInt();*/
            for(int i = 0; i < K; i++) ttt = sc.nextInt();
            for(int i = 0; i < K; i++) ttt = sc.nextInt();
            for(int i = 0; i < K; i++) ttt = sc.nextInt();
            for(int i = 0; i < Q; i++) S[i] = sc.nextInt();
            //for(int i = 0; i < Q; i++) E[i] = sc.nextInt() - 1;
            Queue<Integer> q = new LinkedList();
            loop : for(int i = 0; i < Q; i++)  // BFS O(K* Q)
            {
                int end = sc.nextInt();
                int res = 0;
                if(S[i] == end) continue;
                boolean visited[] = new boolean[K + 1];
                q.clear();
                visited[S[i]] = true;
                q.add(S[i]);
                while(!q.isEmpty())
                {
                    for(int j = q.size(); j > 0; j--)
                    {
                        int cur = q.poll();
                        if(cur == end + 1 || cur == end - 1 || edge[cur] == end) {
                            ans += res + 1;
                            continue loop;
                        }
                        if(cur > 1 && !visited[cur - 1])
                        {
                            q.add(cur - 1);
                            visited[cur - 1] = true;
                        }
                        if(cur < K && !visited[cur + 1])
                        {
                            q.add(cur + 1);
                            visited[cur + 1] = true;
                        }
                        if(!visited[edge[cur]])
                        {
                            q.add(edge[cur]);
                            visited[edge[cur]] = true;
                        }
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