import java.util.Scanner;

import static java.lang.Math.min;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            long l = in.nextLong();
            long r = in.nextLong();
            long d = Math.abs(l - r);
            int a = maxN(1, d);
            if (r > l) {
                r -= f(1, a);
            } else {
                l -= f(1, a);
            }

            int steps = min(maxN2(a + 1, r), maxN2(a + 2, l));
            if (r > l) {
                r -= f2(a + 1, steps);
                l -= f2(a + 2, steps);
            } else {
                l -= f2(a + 1, steps);
                r -= f2(a + 2, steps);
            }
            a += steps * 2;
            long rem = Math.max(l, r);
            int remSteps = maxN2(a + 1, rem);
            if (r > l) {
                r -= f(a + 1, remSteps);
            } else {
                l -= f(a + 1, remSteps);
            }
            a += remSteps;

            System.out.println("Case #" + t + ": " + a + " " + l + " " + r);
        }
    }

    private static long f(int from, int n) {
        return (n * (2 * from + n - 1L)) >> 1;
    }

    private static long f2(int from, int n) {
        return n * (from + n - 1L);
    }

    private static int maxN(int from, long x) {
        // Math.sqrt(1+2*x) - 1 ?
        int bit = 1;
        while (f(from, bit << 1) <= x) {
            bit <<= 1;
        }
        int result = f(from, 1) <= x ? bit : 0;

        while (bit > 0) {
            if (f(from, result | bit) <= x) {
                result |= bit;
            }
            bit >>= 1;
        }
        return result;
    }

    private static int maxN2(int from, long x) {
        int bit = 1;
        while (f2(from, bit << 1) <= x) {
            bit <<= 1;
        }
        int result = f2(from, 1) <= x ? bit : 0;

        while (bit > 0) {
            if (f2(from, result | bit) <= x) {
                result |= bit;
            }
            bit >>= 1;
        }
        return result;
    }
}
