import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static final int OFFSET = -1000000000;
    private static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            String A = sc.next();
            String B = sc.next();
            String result = computeEditDistance(A, B);
            out.println("Case #" + tt + ": " + result);
        }

        out.close();
    }

    private static String computeEditDistance(String A, String B) {
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

        return reconstructPath(a, b, dp);
    }

    private static String reconstructPath(char[] a, char[] b, int[][] dp) {
        int n = a.length;
        int m = b.length;
        int half = dp[n][m] / 2;
        Stack<Character> stack = new Stack<>();
        int i = n, j = m;

        while (i > 0 && j > 0 && half > 0) {
            if (a[i - 1] == b[j - 1]) {
                stack.push(a[i - 1]);
                i--;
                j--;
            } else {
                int current = dp[i][j];
                if (current == dp[i - 1][j - 1] + 1) {
                    stack.push(b[j - 1]);
                    i--;
                    j--;
                } else if (current == dp[i - 1][j] + 1) {
                    i--;
                } else if (current == dp[i][j - 1] + 1) {
                    stack.push(b[--j]);
                }
                half--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < i; k++) {
            sb.append(a[k]);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    // MyScanner class for faster input
    public static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
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