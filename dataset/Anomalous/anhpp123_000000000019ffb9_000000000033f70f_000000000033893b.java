import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static final int OFFSET = -1000000000;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
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
            
            int[] S = new int[Q];
            for (int i = 0; i < K; i++) sc.nextInt(); // Skip inputs
            for (int i = 0; i < K; i++) sc.nextInt(); // Skip inputs
            for (int i = 0; i < K; i++) sc.nextInt(); // Skip inputs
            for (int i = 0; i < Q; i++) S[i] = sc.nextInt();
            
            int ans = 0;
            Queue<Integer> q = new LinkedList<>();
            
            for (int i = 0; i < Q; i++) {
                int end = sc.nextInt();
                if (S[i] == end) continue;
                
                boolean[] visited = new boolean[K + 10];
                q.clear();
                visited[S[i]] = true;
                q.add(S[i]);
                
                int res = 0;
                outerLoop: while (!q.isEmpty()) {
                    for (int j = q.size(); j > 0; j--) {
                        int cur = q.poll();
                        int neigh = edge[cur];
                        int dist = Math.abs(cur - end);
                        
                        if (dist <= 2) {
                            ans += dist + res;
                            break outerLoop;
                        }
                        
                        if (cur < 1 || cur > K) continue;
                        
                        boolean right = end > cur;
                        boolean rightJump = edge[cur] > cur;
                        
                        if (edge[cur] == end) {
                            ans += res + 1;
                            break outerLoop;
                        }
                        
                        if (!right && !rightJump && end <= neigh) {
                            // No action needed
                        } else if (!visited[cur - 1]) {
                            q.add(cur - 1);
                            visited[cur - 1] = true;
                        }
                        
                        if (right && rightJump && end >= neigh) {
                            // No action needed
                        } else if (!visited[cur + 1]) {
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