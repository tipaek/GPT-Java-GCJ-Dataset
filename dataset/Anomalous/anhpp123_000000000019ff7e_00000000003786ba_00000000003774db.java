import java.io.*;
import java.util.*;

public class Solution {
    private StringBuilder sb = new StringBuilder();
    private static final int OFFSET = -1000000000;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        final long MOD = 1000000007;
        int t = sc.nextInt();
        int caseNumber = 0;
        Solution solution = new Solution();

        while (caseNumber++ < t) {
            String A = sc.next();
            String B = sc.next();
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

            int half = dp[n][m] / 2;
            Stack<Character> stack = new Stack<>();
            int i0 = n, i1 = m;

            while (i0 >= 0 && i1 >= 0 && half > 0) {
                int tmp = dp[i0][i1];
                if (i0 == 0) {
                    i1--;
                    half--;
                } else if (i1 == 0) {
                    i0--;
                    half--;
                } else {
                    if (tmp == dp[i0 - 1][i1 - 1] + 1) {
                        stack.add(b[i1 - 1]);
                        i0--;
                        i1--;
                        half--;
                    } else if (tmp == dp[i0 - 1][i1] + 1) {
                        i0--;
                        half--;
                    } else if (tmp == dp[i0][i1 - 1] + 1) {
                        stack.add(b[--i1]);
                        half--;
                    } else {
                        stack.add(a[i0 - 1]);
                        i0--;
                        i1--;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= i0; i++) result.append(a[i - 1]);
            while (!stack.isEmpty()) result.append(stack.pop());

            out.println("Case #" + caseNumber + ": " + result.toString());
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