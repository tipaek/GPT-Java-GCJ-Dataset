import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private String solve2(long l, long r) {
        int k = 1;
        while (l >= k  || r >= k) {
            if (l >= r) {
                l -= k;
            }
            else {
                r -= k;
            }
            k++;
        }
        String s =  (k - 1) + " " + l + " " + r;
        return s;
    }
    private String solve(Scanner in) {
        long l = in.nextLong();
        long r = in.nextLong();
        return solve1(l, r);

    }

    private String solve1(long l, long r) {

        long d = 2*Math.abs(l - r);
        long k = (long) Math.floor(Math.sqrt(d)) - 1;
        while ((k + 1)*(k + 2) <= d) {
            k += 1;
        }
        if (l < r) {
            return solve(l, r, k, true);
        }
        return solve(r, l, k, false);

    }

    private String solve(long l, long r, long k, boolean left) {
        r -= k*(k + 1) / 2;
        if (r == l) {
            left = false;
        }
        long mr = find(r, k, 0);
        r -= mr*mr + mr*k;
        long ml = find(l, k, 1);
        l -= ml*(ml + 1) + ml * k;
        if (!left) {
            long tmp = r;
            r = l;
            l = tmp;
        }
        if (mr == ml) {
            return "" + (k + 2*ml) + " " + l + " " + r;
        }
        return "" + (k + 2*mr - 1) + " " + l + " " + r;
    }

    private long find(long target, long k, int c) {
        long lo = 0;
        long up = (long) Math.sqrt(target) + 1;
        while (lo + 1 < up) {
            long mid = (lo + up) / 2;
            long tmp = mid*(mid + c) + mid * k ;
            if (tmp > target) {
                up = mid;
            }
            else {
                lo = mid;
            }
        }
        return lo;
    }

    private void test() {
        for (int l = 1; l <= 1000; ++l) {
            for(int r = 1; r <= 1000; ++r) {
                System.out.println(l + " " + r);
                String s1 = solve1(l, r);
                String s2 = solve2(l, r);
                if (!s1.equals(s2)) {
                    System.out.println(l + " " + r + " " + s1 + " " + s2);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Solution sol = new Solution();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + sol.solve(in));
        }
    }
}
