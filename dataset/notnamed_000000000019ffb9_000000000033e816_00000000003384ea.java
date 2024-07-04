import java.util.Scanner;
import java.util.function.Function;

import static java.lang.Math.min;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner("3\n" +
//                "1 2\n" +
//                "2 2\n" +
//                "8 11");
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            long l = in.nextLong();
            long r = in.nextLong();
            long d = Math.abs(l - r);
            int steps = maximize(x -> progrSum(1, x, x), d);

            if (r > l) {
                r -= progrSum(1, steps, steps);
            } else {
                l -= progrSum(1, steps, steps);
            }

            int steps2;
            if (r > l) {
                int rMax = maximize(x -> progrSum(steps + 1, steps + 1 + 2 * (x - 1), x), r);
                int lMax = maximize(x -> progrSum(steps + 2, steps + 2 + 2 * (x - 1), x), l);
                int common = min(rMax, lMax);
                r -= progrSum(steps + 1, steps + 1 + 2 * (common - 1), common);
                l -= progrSum(steps + 2, steps + 2 + 2 * (common - 1), common);
                steps2 = steps + 2 + 2 * (common - 1);
            } else {
                int lMax = maximize(x -> progrSum(steps + 1, steps + 1 + 2 * (x - 1), x), l);
                int rMax = maximize(x -> progrSum(steps + 2, steps + 2 + 2 * (x - 1), x), r);
                int common = min(rMax, lMax);
                l -= progrSum(steps + 1, steps + 1 + 2 * (common - 1), common);
                r -= progrSum(steps + 2, steps + 2 + 2 * (common - 1), common);
                steps2 = steps + 2 + 2 * (common - 1);
            }

            long remainder = Math.max(l, r);
            int remSteps = maximize(x -> progrSum(steps2 + 1, steps2 + x, x), remainder);
            int total = steps2 + remSteps;
            if (r > l) {
                r -= progrSum(steps2 + 1, steps2 + remSteps, remSteps);
            } else {
                l -= progrSum(steps2 + 1, steps2 + remSteps, remSteps);
            }

            System.out.println("Case #" + t + ": " + total   + " " + l + " " + r);
        }
    }

    private static int maximize(Function<Long, Long> f, long maxVal) {
        int res = 0;
        for (long bit = 1L << 31; bit != 0; bit >>= 1) {
            if (f.apply(res | bit) <= maxVal) {
                    res |= bit;
            }
        }
        return res;
    }

    private static long progrSum(long start, long end, long count) {
        return ((start + end) % 2 == 1) ? (start + end) * (count >> 1) : ((start + end) >> 1) * (count);
    }
}
