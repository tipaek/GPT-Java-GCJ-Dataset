
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        for(int i = 0; i < T; i++) {
            solve(i+1, s);
        }

    }

    private static void solve(int cid, Scanner in) {

        long L = in.nextInt();
        long R = in.nextInt();

        long customers = 0;
        if(L > R) {
            long d = bs_all(L - R);
            L -= sum_all(d);            
            customers += d;
        } else if (R > L){
            long d = bs_all(R - L);
            R -= sum_all(d);
            customers += d;
        }

        // System.out.println("Case #" + cid + ": " + customers + " " + L + " " + R);


        if(L >= R) {
            if(customers % 2 == 0) {
                long can_l = bs_odd(L, customers/2);
                long can_r = bs_even(L, customers/2);
                L -= sum_odd(can_l) - sum_odd(customers/2);
                R -= sum_even(can_r) - sum_even(customers/2);
                customers = can_l + can_r;
            } else {
                long can_l = bs_even(L, customers/2);
                long can_r = bs_odd(L, customers/2+1);
                L -= sum_even(can_l) - sum_even(customers);
                R -= sum_odd(can_r) - sum_odd(customers+1);
                customers = can_l + can_r;
            }
        } else {
            if(customers % 2 == 1) {
                long can_l = bs_odd(L, customers/2+1);
                long can_r = bs_even(L, customers/2);
                L -= sum_odd(can_l) - sum_odd(customers+1);
                R -= sum_even(can_r) - sum_even(customers);
                customers += can_l + can_r;
            } else {
                long can_l = bs_even(L, customers/2);
                long can_r = bs_odd(L, customers/2);
                L -= sum_even(can_l) - sum_even(customers+1);
                R -= sum_odd(can_r) - sum_odd(customers);
                customers += can_l + can_r;
            }
        }

        System.out.println("Case #" + cid + ": " + customers + " " + L + " " + R);

    }

    private static long sum_all(long n) {
        return n*(n+1)/2;
    }

    private static long sum_odd(long n) {
        return n*n;
    }

    private static long sum_even(long n) {
        return n*(n+1);
    }

    private static long bs_even(long delta, long start) {
        long l = start;
        long r = 1 << 60;

        while (r >= l) {
            long m = l + (r - l) / 2;

            long v = sum_even(m) - sum_even(start);
            long vplus = sum_even(m+1) - sum_even(start);

            if (v <= delta && vplus > delta) {
                return m;
            } else if (v > delta) {
                r = m;
            } else {
                l = m;
            }
        }

        assert(false);
        return -1;
    }

    private static long bs_odd(long delta, long start) {
        long l = start;
        long r = 1 << 60;

        while (r >= l) {
            long m = l + (r - l) / 2;

            long v = sum_odd(m) - sum_odd(start);
            long vplus = sum_odd(m+1) - sum_odd(start);

            if (v <= delta && vplus > delta) {
                return m;
            } else if (v > delta) {
                r = m;
            } else {
                l = m;
            }
        }

        assert(false);
        return -1;

    }

    private static long bs_all(long delta) {

        long l = 1;
        long r = 1 << 60;

        while (r >= l) {
            long m = l + (r - l) / 2;

            long v = sum_all(m);
            long vminus = sum_all(m-1);

            if (v >= delta && vminus < delta) {
                return m;
            } else if (v < delta) {
                l = m;
            } else {
                r = m;
            }
        }

        assert(false);
        return -1;

    }

}
