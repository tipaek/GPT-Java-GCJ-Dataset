import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static final int OFFSET = -1000000000;
    private StringBuilder sb = new StringBuilder();
    private static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();
        Solution sol = new Solution();

        for (int tt = 1; tt <= t; tt++) {
            int K = sc.nextInt();
            int Q = sc.nextInt();
            String s = sc.nextLine();
            char[] c = s.toCharArray();
            int[] edge = new int[K + 1];
            Arrays.fill(edge, -1);
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < K; i++) {
                if (c[i] == '(') {
                    stack.push(i);
                } else {
                    int tmp = stack.pop();
                    edge[tmp + 1] = i + 1;
                    edge[i + 1] = tmp + 1;
                }
            }

            int[] S = new int[Q + 1];
            int ans = 0;

            for (int i = 0; i < K; i++) sc.nextInt();
            for (int i = 0; i < K; i++) sc.nextInt();
            for (int i = 0; i < K; i++) sc.nextInt();
            for (int i = 0; i < Q; i++) S[i] = sc.nextInt();

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < Q; i++) {
                int end = sc.nextInt();
                if (S[i] == end) continue;

                boolean[] visited = new boolean[K + 1];
                q.clear();
                visited[S[i]] = true;
                q.add(S[i]);
                int res = 0;

                while (!q.isEmpty()) {
                    for (int j = q.size(); j > 0; j--) {
                        int cur = q.poll();
                        if (cur == end + 1 || cur == end - 1 || edge[cur] == end) {
                            ans += res + 1;
                            continue;
                        }
                        if (cur > 1 && !visited[cur - 1]) {
                            q.add(cur - 1);
                            visited[cur - 1] = true;
                        }
                        if (cur < K && !visited[cur + 1]) {
                            q.add(cur + 1);
                            visited[cur + 1] = true;
                        }
                        if (!visited[edge[cur]]) {
                            q.add(edge[cur]);
                            visited[edge[cur]] = true;
                        }
                    }
                    res++;
                }
            }
            out.println("Case #" + tt + ": " + ans);
        }
        out.close();
    }

    public int solve(MyScanner sc) {
        return 0;
    }

    public static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
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