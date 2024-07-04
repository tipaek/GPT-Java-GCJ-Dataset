import java.io.*;
import java.util.*;

public class Solution {
    private static char[] s;
    private static final int INF = (int) 1e9;
    private static int[][] dp;
    private static StringBuilder sb;

    private static int solve(int idx, int open) {
        if (idx == s.length)
            return open == 0 ? 0 : INF;
        if (open < 0)
            return INF;
        if (dp[idx][open] != -1)
            return dp[idx][open];
        
        int ans = INF;
        if (s[idx] == '#') {
            ans = Math.min(ans, 1 + solve(idx + 1, open + 1));
            ans = Math.min(ans, 1 + solve(idx + 1, open - 1));
            ans = Math.min(ans, solve(idx + 1, open));
        } else if (s[idx] - '0' == open) {
            ans = Math.min(ans, solve(idx + 1, open));
        }
        return dp[idx][open] = ans;
    }

    private static void trace(int idx, int open) {
        if (idx == s.length || open < 0) return;
        
        int ans = solve(idx, open);
        if (s[idx] == '#') {
            if (ans == 1 + solve(idx + 1, open + 1)) {
                sb.append("(");
                trace(idx + 1, open + 1);
            } else if (ans == 1 + solve(idx + 1, open - 1)) {
                sb.append(")");
                trace(idx + 1, open - 1);
            } else if (ans == solve(idx + 1, open)) {
                trace(idx + 1, open);
            }
        } else if (s[idx] - '0' == open && ans == solve(idx + 1, open)) {
            sb.append(s[idx]);
            trace(idx + 1, open);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        int testCases = sc.nextInt();
        
        for (int c = 1; c <= testCases; c++) {
            char[] input = sc.next().toCharArray();
            s = new char[input.length * 2 + 1];
            
            for (int i = 0; i < s.length; i++) {
                s[i] = (i % 2 == 0) ? '#' : input[i / 2];
            }
            
            dp = new int[s.length + 1][s.length + 1];
            for (int i = 0; i <= s.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            
            sb = new StringBuilder();
            trace(0, 0);
            out.printf("Case #%d: %s%n", c, sb.toString());
        }
        
        out.flush();
        out.close();
    }

    static class Scanner {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        String next() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }
    }
}