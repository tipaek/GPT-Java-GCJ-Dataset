import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private static final BigInteger TWO = BigInteger.valueOf(2);

    private void solve() {
        int testn = nextInt();
        for (int test = 1; test <= testn; test++) {
            out.print("Case #" + test + ": ");
            long l = nextLong();
            long r = nextLong();
            boolean swap = false;

            if (l < r) {
                long temp = r;
                r = l;
                l = temp;
                swap = true;
            }

            long skip = fits(l - r);
            l -= skip * (skip + 1) / 2;

            if (l == r) {
                swap = false;
            }

            long moreLeft = maxFits(l, skip + 1);
            long moreRight = maxFits(r, skip + 2);

            if (moreLeft > moreRight + 1) {
                moreLeft = moreRight + 1;
            }
            if (moreRight > moreLeft) {
                moreRight = moreLeft;
            }

            long ans = skip + Math.max(2 * moreLeft - 1, 2 * moreRight);
            l -= (skip + 1) * moreLeft + moreLeft * (moreLeft - 1);
            r -= (skip + 2) * moreRight + moreRight * (moreRight - 1);

            if (swap) {
                long temp = l;
                l = r;
                r = temp;
            }

            out.println(ans + " " + l + " " + r);
        }
    }

    private long maxFits(long value, long start) {
        BigInteger left = BigInteger.ZERO;
        BigInteger right = BigInteger.valueOf(value + 1);

        while (right.subtract(left).compareTo(BigInteger.ONE) > 0) {
            BigInteger mid = left.add(right).divide(TWO);
            BigInteger sum = mid.multiply(BigInteger.valueOf(start)).add(mid.multiply(mid.subtract(BigInteger.ONE)));

            if (sum.compareTo(BigInteger.valueOf(value)) > 0) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left.longValue();
    }

    private long fits(long n) {
        BigInteger left = BigInteger.ZERO;
        BigInteger right = BigInteger.valueOf(n + 1);

        while (right.subtract(left).compareTo(BigInteger.ONE) > 0) {
            BigInteger mid = left.add(right).divide(TWO);
            BigInteger sum = mid.multiply(mid.add(BigInteger.ONE)).divide(TWO);

            if (sum.compareTo(BigInteger.valueOf(n)) > 0) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left.longValue();
    }
}