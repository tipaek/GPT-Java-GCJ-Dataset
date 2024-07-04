import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        IHOP solver = new IHOP();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class IHOP {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long L = in.nextLong();
            long R = in.nextLong();

            long res = 0;
            long n = maxN(1, 1, Math.abs(L - R));
            long s = n * (n + 1) / 2;
            res += n;
            if (L > R) {
                L -= s;
            } else if (R > L) {
                R -= s;
            }

            long nl, nr;
            if (L >= R) {
                nl = maxN(n + 1, 2, L);
                L -= aSum(n + 1, 2, nl);
                nr = maxN(n + 2, 2, R);
                R -= aSum(n + 2, 2, nr);
            } else {
                nr = maxN(n + 1, 2, R);
                R -= aSum(n + 1, 2, nr);
                nl = maxN(n + 2, 2, L);
                L -= aSum(n + 2, 2, nl);
            }
            res += nl + nr;

            out.println(String.format("Case #%d: %d %d %d", testNumber, res, L, R));
        }

        private long maxN(long a1, int d, long maxSum) {
            if (maxSum < a1) {
                return 0;
            }
            long low = 1, high = Integer.MAX_VALUE;
            while (low < high) {
                long mid = (low + high) / 2;
                long sum = aSum(a1, d, mid);
                if (sum == maxSum) {
                    return mid;
                } else if (sum < maxSum) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            long t = aSum(a1, d, low);
            if (t > maxSum) return low - 1;
            return low;
        }

        private long aSum(long a1, int d, long n) {
            return n * (2 * a1 + (n - 1) * d) / 2;
        }

    }
}

