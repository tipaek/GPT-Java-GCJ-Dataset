import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        Solution sol = new Solution();

        for (int tt = 1; tt <= t; tt++) {
            int K = sc.nextInt();
            int Q = sc.nextInt();
            char[] c = sc.nextLine().toCharArray();
            int[] edge = new int[K];
            Arrays.fill(edge, -1);

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < K; i++) {
                if (c[i] == '(') {
                    stack.push(i);
                } else {
                    int tmp = stack.pop();
                    edge[tmp] = i;
                    edge[i] = tmp;
                }
            }

            int[] L = new int[K], R = new int[K], P = new int[K];
            int[] S = new int[Q], E = new int[Q];
            for (int i = 0; i < K; i++) L[i] = sc.nextInt();
            for (int i = 0; i < K; i++) R[i] = sc.nextInt();
            for (int i = 0; i < K; i++) P[i] = sc.nextInt();
            for (int i = 0; i < Q; i++) S[i] = sc.nextInt() - 1;
            for (int i = 0; i < Q; i++) E[i] = sc.nextInt() - 1;

            int ans = 0;
            for (int i = 0; i < Q; i++) {
                if (S[i] == E[i]) continue;
                boolean[] visited = new boolean[K];
                Queue<Integer> q = new LinkedList<>();
                visited[S[i]] = true;
                q.add(S[i]);
                int res = 0;

                while (!q.isEmpty()) {
                    for (int j = q.size(); j > 0; j--) {
                        int cur = q.poll();
                        if (cur == E[i] + 1 || cur == E[i] - 1 || edge[cur] == E[i]) {
                            ans += res + 1;
                            continue;
                        }
                        if (cur > 0 && !visited[cur - 1]) q.add(cur - 1);
                        if (cur < K - 1 && !visited[cur + 1]) q.add(cur + 1);
                        if (!visited[edge[cur]]) q.add(edge[cur]);
                    }
                    res++;
                }
            }

            out.println("Case #" + tt + ": " + ans);
        }
        out.close();
    }

    private static class MyScanner {
        private final BufferedReader br;
        private StringTokenizer st;

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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}