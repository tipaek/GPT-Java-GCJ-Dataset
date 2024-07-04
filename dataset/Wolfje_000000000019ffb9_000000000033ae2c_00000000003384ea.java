import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution problem = new Solution();
        problem.run(in);
    }

    public void run(Scanner in) {
        int tests = in.nextInt();
        for ( int t = 1; t <= tests; t++) {
            long left = in.nextLong();
            long right = in.nextLong();
            long[] result = solve(left, right);
            System.out.printf("Case #%d: %d %d %d\n", t, result[0], result[1], result[2]);
        }
    }

    private long[] solve(long left, long right) {
        long n = 0;
        long delta = Math.abs(left - right);
        long k0 = maxK0(delta);
        long fk0 = k0*(k0+1)/2;
        n += k0;
        if ( left > right ) left -= fk0;
        else right -= fk0;
        if ( left <= right ) {
            long k1Left = maxK1(left, k0+1);
            left -= fK1(k1Left, k0+1);
            long k1Right = maxK1(right, k0+2);
            right -= fK1(k1Right, k0+2);
            n += k1Left + k1Right;
        } else {
            long k1Left = maxK1(left, k0+2);
            left -= fK1(k1Left, k0+2);
            long k1Right = maxK1(right, k0+1);
            right -= fK1(k1Right, k0+1);
            n += k1Left + k1Right;
        }
        return new long[]{n, left, right};
    }

    public long maxK0(long x) {
        long lb = 0;
        long ub = 2_000_000_000L;
        while ( lb + 1 < ub ) {
            long mid = (lb + ub)/2;
            if ( mid*(mid+1)/2 <= x ) lb = mid;
            else ub = mid;
        }
        return lb;
    }

    public long maxK1(long x, long first) {
        long lb = 0;
        long ub = 2_000_000_000L;
        while ( lb + 1 < ub ) {
            long mid = (lb + ub)/2;
            if ( fK1(mid, first) <= x) lb = mid;
            else ub = mid;
        }
        return lb;
    }

    public long fK1(long k, long first) {
        return first*k + k*(k-1);
    }


}
