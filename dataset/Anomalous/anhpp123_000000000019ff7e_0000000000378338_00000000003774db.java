import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            String A = sc.next();
            String B = sc.next();
            out.println("Case #" + tt + ": " + findShortestSupersequence(A, B));
        }
        out.close();
    }

    private static String findShortestSupersequence(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) dp[i][0] = i;
        for (int j = 1; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        int half = (dp[n][m] + 1) / 2;
        Stack<Character> stack = new Stack<>();
        int i0 = n, i1 = m;

        while (i0 > 0 && i1 > 0 && half > 0) {
            if (a[i0 - 1] == b[i1 - 1]) {
                stack.push(a[i0 - 1]);
                i0--;
                i1--;
            } else if (dp[i0][i1] == dp[i0 - 1][i1 - 1] + 1) {
                stack.push(b[i1 - 1]);
                i0--;
                i1--;
                half--;
            } else if (dp[i0][i1] == dp[i0 - 1][i1] + 1) {
                i0--;
                half--;
            } else if (dp[i0][i1] == dp[i0][i1 - 1] + 1) {
                stack.push(b[--i1]);
                half--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < i0; i++) sb.append(a[i]);
        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.toString();
    }

    //-----------MyScanner class for faster input----------
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