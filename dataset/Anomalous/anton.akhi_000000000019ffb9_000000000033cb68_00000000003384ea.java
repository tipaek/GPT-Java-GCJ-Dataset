import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

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
            } catch (Exception e) {
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

    private void solve() {
        int testCount = nextInt();
        for (int test = 1; test <= testCount; test++) {
            out.print("Case #" + test + ": ");
            long l = nextLong();
            long r = nextLong();
            boolean swapped = false;

            if (l < r) {
                long temp = r;
                r = l;
                l = temp;
                swapped = true;
            }

            long initialSkip = calculateFits(l - r);
            l -= initialSkip * (initialSkip + 1) / 2;

            if (l == r) {
                swapped = false;
            }

            long additionalLeft = calculateMaxFits(l, initialSkip + 1);
            long additionalRight = calculateMaxFits(r, initialSkip + 2);

            if (additionalLeft > additionalRight + 1) {
                additionalLeft = additionalRight + 1;
            }

            if (additionalRight > additionalLeft) {
                additionalRight = additionalLeft;
            }

            long result = initialSkip + Math.max(2 * additionalLeft - 1, 2 * additionalRight);
            l -= (initialSkip + 1) * additionalLeft + additionalLeft * (additionalLeft - 1);
            r -= (initialSkip + 2) * additionalRight + additionalRight * (additionalRight - 1);

            if (swapped) {
                long temp = l;
                l = r;
                r = temp;
            }

            out.println(result + " " + l + " " + r);
        }
    }

    private long calculateMaxFits(long value, long start) {
        BigInteger left = BigInteger.ZERO;
        BigInteger right = BigInteger.valueOf(value + 1);

        while (right.subtract(left).compareTo(BigInteger.ONE) > 0) {
            BigInteger mid = left.add(right).divide(BigInteger.TWO);
            BigInteger sum = mid.multiply(BigInteger.valueOf(start)).add(mid.multiply(mid.subtract(BigInteger.ONE)));

            if (sum.compareTo(BigInteger.valueOf(value)) > 0) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left.longValue();
    }

    private long calculateFits(long n) {
        BigInteger left = BigInteger.ZERO;
        BigInteger right = BigInteger.valueOf(n);

        while (right.subtract(left).compareTo(BigInteger.ONE) > 0) {
            BigInteger mid = left.add(right).divide(BigInteger.TWO);
            BigInteger sum = mid.multiply(mid.add(BigInteger.ONE)).divide(BigInteger.TWO);

            if (sum.compareTo(BigInteger.valueOf(n)) > 0) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left.longValue();
    }
}