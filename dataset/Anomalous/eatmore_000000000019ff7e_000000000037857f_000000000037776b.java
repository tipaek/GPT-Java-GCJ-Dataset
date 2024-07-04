import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    // Discuss this round on Codeforces: https://codeforces.com/blog/entry/78458

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(System.out)) {

            int tests = Integer.parseInt(in.readLine().trim());
            for (int test = 1; test <= tests; test++) {
                solve(in, out, test);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void solve(BufferedReader in, PrintWriter out, int test) throws IOException {
        StringTokenizer tok = new StringTokenizer(in.readLine());
        long k = Long.parseLong(tok.nextToken());
        int n = Integer.parseInt(tok.nextToken());

        long[] x = new long[4 * n];
        tok = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Long.parseLong(tok.nextToken());
            x[i + n] = x[i] + k;
            x[i + 2 * n] = x[i] + 2 * k;
            x[i + 3 * n] = x[i] + 3 * k;
        }

        tok = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            tok.nextToken(); // discard
        }

        int ans = 2 * n;
        for (int start = n; start < 2 * n; start++) {
            int cans = n + 1;
            long l = x[start - 1] - k, r = x[start];
            for (int i = 0; i < n; i++) {
                if (2L * x[start + i] - r >= x[start + i + 1]) {
                    ++ans;
                    l = x[start + i - 1];
                    r = x[start + i];
                }
                long nl = 2L * x[start + i] - r, nr = 2L * x[start + i] - l;
                l = Math.max(nl, x[start + i]);
                r = Math.min(nr, x[start + i + 1]);
            }
            ans = Math.min(ans, cans);
        }

        if (ans == n + 1) {
            if (n % 2 == 0) {
                long s0 = 0, s1 = 0;
                for (int i = 0; i < n; i += 2) {
                    s0 += x[i];
                    s1 += x[i + 1];
                }
                if (2 * (s1 - s0) == k) {
                    ans = n;
                }
            } else {
                long pp = 0;
                for (int i = 0; i < n - 1; i += 2) {
                    pp += x[i];
                    pp -= x[i + 1];
                }
                pp = 2 * (pp + x[n - 1]) + k;
                for (int i = 0; ; i++) {
                    if (i == n) {
                        ans = n;
                        break;
                    }
                    if (pp <= 2 * x[i + n - 1] || pp >= 2 * x[i + n]) {
                        break;
                    }
                    pp = 4 * x[i + n] - pp;
                }
            }
        }

        out.printf("Case #%d: %d%n", test, ans);
    }
}