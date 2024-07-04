
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Throwable {

        Scanner sc = new Scanner();
        PrintWriter pw = new PrintWriter(System.out);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean ok = false;
            int[][] ans = new int[n][n];
            if (k % n == 0 && k / n <= n) {
                ok = true;
                int x = k / n;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        ans[(i + j) % n][j] = x;
                    }
                    x = x + 1;
                    if (x > n)
                        x = 1;
                }
            } else if (k == (n * (n + 1) / 2) && n > 2) {
                ok = true;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        ans[(i + n - j) % n][j] = i + 1;
                    }
                }
            }

            pw.printf("Case #%d: %s\n", tc, ok ? "POSSIBLE" : "IMPOSSIBLE");
            if (ok) {
                for (int i = 0; i < n; i++) {
                    for (int x : ans[i])
                        pw.print(x + " ");
                    pw.println();
                }
            }
        }

        pw.close();
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String s) throws Throwable {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() throws Throwable {
            if (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws Throwable {
            return Integer.parseInt(next());
        }

        long nextLong() throws Throwable {
            return Long.parseLong(next());
        }

    }

}