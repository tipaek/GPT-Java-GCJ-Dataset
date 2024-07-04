package r1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private String solveSimple(long l, long r) {
        int k = 1;
        while (l >= k || r >= k) {
            if (l >= r) {
                l -= k;
            } else {
                r -= k;
            }
            k++;
        }
        return (k - 1) + " " + l + " " + r;
    }

    private String solve(Scanner in) {
        long l = in.nextLong();
        long r = in.nextLong();
        return solveComplex(l, r);
    }

    private String solveComplex(long l, long r) {
        long d = 2 * Math.abs(l - r);
        long k = (long) Math.floor(Math.sqrt(d)) - 1;
        while ((k + 1) * (k + 2) <= d) {
            k += 1;
        }
        if (l < r) {
            return solveWithParams(l, r, k, true);
        }
        return solveWithParams(r, l, k, false);
    }

    private String solveWithParams(long l, long r, long k, boolean left) {
        r -= k * (k + 1) / 2;
        if (r == l) {
            left = false;
        }
        long mr = findMaxR(r, k, 0);
        r -= mr * mr + mr * k;
        long ml = findMaxR(l, k, 1);
        l -= ml * (ml + 1) + ml * k;
        if (!left) {
            long temp = r;
            r = l;
            l = temp;
        }
        if (mr == ml) {
            return (k + 2 * ml) + " " + l + " " + r;
        }
        return (k + 2 * mr - 1) + " " + l + " " + r;
    }

    private long findMaxR(long target, long k, int c) {
        long lo = 0;
        long hi = (long) Math.sqrt(target) + 1;
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            long value = mid * (mid + c) + mid * k;
            if (value > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private void test() {
        for (int l = 1; l <= 1000; ++l) {
            for (int r = 1; r <= 1000; ++r) {
                System.out.println(l + " " + r);
                String result1 = solveComplex(l, r);
                String result2 = solveSimple(l, r);
                if (!result1.equals(result2)) {
                    System.out.println(l + " " + r + " " + result1 + " " + result2);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        Solution sol = new Solution();
        // sol.test();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + sol.solve(in));
        }
    }
}