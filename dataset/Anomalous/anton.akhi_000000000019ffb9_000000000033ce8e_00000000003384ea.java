import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Cake {
    public static void main(String[] args) {
        new Cake().run();
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

    private static final BigInteger TWO = BigInteger.valueOf(2);

    private void solve() {
        int testCases = nextInt();
        for (int test = 1; test <= testCases; test++) {
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

            long skip = calculateFits(l - r);
            l -= skip * (skip + 1) / 2;

            if (l == r) {
                swapped = false;
            }

            long additionalLeft = calculateMaxFits(l, skip + 1);
            long additionalRight = calculateMaxFits(r, skip + 2);

            if (additionalLeft > additionalRight + 1) {
                additionalLeft = additionalRight + 1;
            }

            if (additionalRight > additionalLeft) {
                additionalRight = additionalLeft;
            }

            long result = skip + Math.max(2 * additionalLeft - 1, 2 * additionalRight);
            l -= (skip + 1) * additionalLeft + additionalLeft * (additionalLeft - 1);
            r -= (skip + 2) * additionalRight + additionalRight * (additionalRight - 1);

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

    private long calculateFits(long n) {
        BigInteger left = BigInteger.ZERO;
        BigInteger right = BigInteger.valueOf(n);

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