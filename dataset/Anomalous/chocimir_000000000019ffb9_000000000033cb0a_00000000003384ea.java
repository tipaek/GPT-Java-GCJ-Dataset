import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void solve(Scanner in) {
        long l = in.nextLong();
        long r = in.nextLong();
        long d = 2 * Math.abs(l - r);
        long k = (long) Math.floor(Math.sqrt(d));

        while ((k + 1) * (k + 2) <= d) {
            k++;
        }

        if (l < r) {
            solve(l, r, k, true);
        } else {
            solve(r, l, k, false);
        }
    }

    private void solve(long l, long r, long k, boolean left) {
        r -= k * (k + 1) / 2;

        if (r == l) {
            left = false;
        }

        long mr = find(r, k, 0);
        r -= mr * mr + mr * k;
        long ml = find(l, k, 1);
        l -= ml * (ml + 1) + ml * k;

        if (!left) {
            long tmp = r;
            r = l;
            l = tmp;
        }

        if (mr == ml) {
            System.out.println((k + 2 * ml) + " " + l + " " + r);
        } else {
            System.out.println((k + 2 * mr - 1) + " " + l + " " + r);
        }
    }

    private long find(long target, long k, int c) {
        long lo = 0;
        long up = (long) Math.sqrt(target) + 1;

        while (lo + 1 < up) {
            long mid = (lo + up) / 2;
            long tmp = mid * mid + (mid + c) * k;

            if (tmp > target) {
                up = mid;
            } else {
                lo = mid;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        Solution sol = new Solution();

        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": ");
            sol.solve(in);
        }
    }
}