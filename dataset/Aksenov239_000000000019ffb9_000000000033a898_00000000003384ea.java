import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by vaksenov on 04.04.2020.
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public void solve() throws IOException {
        int l = nextInt();
        int r = nextInt();

        boolean swap = false;
        if (l < r) {
            int q = l;
            l = r;
            r = q;
            swap = true;
        }

        long A = 0;
        if (l > r) {
            long L = 0;
            long R = (long)Math.sqrt(2 * (l - r));
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
            long R = (long)Math.sqrt(2 * l);
            while (L < R - 1) {
                long M = (L + R) / 2;
                long DL = (A + 1) * M + M * (M - 1);
                long DR = (A + 1) * M + M * M;
                if (DL <= l &&
                        DR <= r &&
                        l - DL - (A + 2 * M) <= r - DR) {
                    L = M;
                } else {
                    R = M;
                }
            }

            l -= (A + 1) * L + L * (L - 1);
            r -= (A + 1) * L + L * L;
            A += 2 * L;
            while (l > r && l >= A + 1) {
                l -= A + 1;
                A++;
            }
            if (l < A + 1 && r < A + 1) {
                break;
            }
            if (l < r) {
                int q = l;
                l = r;
                r = q;
                swap = !swap;
            }
        }

        if (swap) {
            out.println(A + " " + r + " " + l);
        } else {
            out.println(A + " " + l + " " + r);
        }
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            int t = nextInt();
            for (int i = 0; i < t; i++) {
                out.print(String.format("Case #%d: ", i + 1));
                solve();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
