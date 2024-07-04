import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final long INF = (long) 1e18 + 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int tt = 1; tt <= cases; tt++) {
            long l = in.nextInt();
            long r = in.nextInt();
            System.out.println("Case #" + tt + ": " + foo(l, r));
        }
    }

    private static long f(long n) {
        return n * (n + 1) / 2;
    }

    private static long g(long a, long n) {
        return (n + 1) * (a + n);
    }

    private static String foo(long left, long right) {
        long d = Math.abs(left - right);
        long lo = 0, hi = (long) 1e9 + 5;
        long fi = 0;
        while (lo <= hi) {
            long k = lo + (hi - lo) / 2;
            long f = f(k);
            if (f <= d) {
                fi = k;
                lo = k + 1;
            } else {
                hi = k - 1;
            }
        }
        long a = fi + 1;
        //System.out.println("fi=" + fi);
        long a1 = a + 1;
        //System.out.println("a=" + a);
        //System.out.println("a1=" + a1);
        if (left >= right) {
            left -= f(fi);
        } else {
            right -= f(fi);
        }
        long max = left >= right ? left : right;
        long aa = 0;
        lo = 0;
        hi = (long) 1e9 + 5;
        while (lo <= hi) {
            long k = lo + (hi - lo) / 2;
            long g = g(a, k);
            if (g <= max) {
                aa = k + 1;
                lo = k + 1;
            } else {
                hi = k - 1;
            }
        }
        //System.out.println("aa=" + aa);
        long min = left >= right ? right : left;
        //System.out.println("min=" + min);
        long bb = 0;
        lo = 0;
        hi = (long) 1e9 + 5;
        while (lo <= hi) {
            long k = lo + (hi - lo) / 2;
            long g = g(a1, k);
            /*System.out.println("k = " + k);
            System.out.println("g = " + g);*/
            if (g <= min) {
                bb = k + 1;
                lo = k + 1;
            } else {
                hi = k - 1;
            }
        }
        //System.out.println("bb=" + bb);
        if (left >= right) {
            left -= g(a, aa - 1);
            right -= g(a1, bb - 1);
        } else {
            right -= g(a, aa - 1);
            left -= g(a1, bb - 1);
        }

        return (fi + aa + bb) + " " + left + " " + right;
    }

}
