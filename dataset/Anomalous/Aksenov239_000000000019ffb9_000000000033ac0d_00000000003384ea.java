import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private void solve(long l, long r) throws IOException {
        boolean swapped = false;
        if (l < r) {
            long temp = l;
            l = r;
            r = temp;
            swapped = true;
        }

        long A = 0;
        if (l > r) {
            long L = 0;
            long R = 20_000_000_000L;
            while (L < R - 1) {
                long M = (L + R) / 2;
                if (M * (M + 1) / 2 <= l - r) {
                    L = M;
                } else {
                    R = M;
                }
            }
            l -= L * (L + 1) / 2;
            A += L;
        }

        while (true) {
            long L = 0;
            long R = 20_000_000_000L;
            while (L < R - 1) {
                long M = (L + R) / 2;
                long DL = (A + 1) * M + M * (M - 1);
                long DR = (A + 1) * M + M * M;
                if (DL <= l && DR <= r && l - DL - (A + 2 * M) <= r - DR) {
                    L = M;
                } else {
                    R = M;
                }
            }

            l -= (A + 1) * L + L * (L - 1);
            r -= (A + 1) * L + L * L;
            A += 2 * L;
            while (l >= r && l >= A + 1) {
                l -= A + 1;
                A++;
            }
            if (l < A + 1 && r < A + 1) {
                break;
            }
            if (l < r) {
                long temp = l;
                l = r;
                r = temp;
                swapped = !swapped;
            }
        }

        if (swapped) {
            out.println(A + " " + r + " " + l);
        } else {
            out.println(A + " " + l + " " + r);
        }
    }

    private void solve() throws IOException {
        long l = nextLong();
        long r = nextLong();
        solve(l, r);
    }

    private void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            int t = nextInt();
            for (int i = 0; i < t; i++) {
                out.print(String.format("Case #%d: ", i + 1));
                solve();
            }

            for (int i = 1; i < 1000; i++) {
                solve(1_000_000_000_000_000_000L, 999_999_999_999_999_999L);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}