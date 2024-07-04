import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        IncrementalHouseOfPancakes solver = new IncrementalHouseOfPancakes();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class IncrementalHouseOfPancakes {
        String smart(long L, long R) {
            long li = 0;
            long ri = 2000000000L;
            long sm = Math.min(L, R);
            long gm = Math.max(L, R);
            while (li < ri - 1) {
                long m = (li + ri) / 2;
                long sum = m * (m + 1) / 2;
                if (sm <= gm - sum) {
                    li = m;
                } else {
                    ri = m;
                }
            }
            if (L < R) {
                R -= li * (li + 1) / 2;
            } else {
                L -= li * (li + 1) / 2;
            }

            long st = ri;
            ri = 2000000000L;
            sm = Math.min(L, R);
            gm = Math.max(L, R);
            while (li < ri - 1) {
                long m = (li + ri) / 2;

                long grcnt = (m - st + 2) / 2;
                long lscnt = (m - st + 1) / 2;
                long gsum = (st + st + 2 * (grcnt - 1)) * grcnt / 2;
                long lsum = (st + 1 + st + 1 + 2 * (lscnt - 1)) * lscnt / 2;

                if (gm >= gsum && sm >= lsum) {
                    li = m;
                } else {
                    ri = m;
                }
            }
            long grcnt = (li - st + 2) / 2;
            long lscnt = (li - st + 1) / 2;
            long gsum = (st + st + 2 * (grcnt - 1)) * grcnt / 2;
            long lsum = (st + 1 + st + 1 + 2 * (lscnt - 1)) * lscnt / 2;
            if (L >= R) {
                L -= gsum;
                R -= lsum;
            } else {
                R -= gsum;
                L -= lsum;
            }

            return li + " " + L + " " + R;
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long L = in.nextLong();
            long R = in.nextLong();

            out.println("Case #" + testNumber + ": " + smart(L, R));
        }

    }
}

