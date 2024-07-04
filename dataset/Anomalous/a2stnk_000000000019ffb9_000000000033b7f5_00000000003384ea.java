import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                System.out.printf("Case #%d: ", i + 1);
                processCase(sc);
            }
        }
    }

    private static void processCase(Scanner sc) {
        long L = sc.nextLong();
        long R = sc.nextLong();
        long[] result = calculate(L, R);
        System.out.printf("%d %d %d%n", result[0], result[1], result[2]);
    }

    private static long[] calculate(long L, long R) {
        long min = 0;
        long max = 2_000_000_000L;
        
        while (min + 1 < max) {
            long mid = (min + max) / 2;
            long served = mid * (mid + 1) / 2;
            if (L >= R) {
                if (L - served >= R) {
                    min = mid;
                } else {
                    max = mid;
                }
            } else {
                if (L < R - served) {
                    min = mid;
                } else {
                    max = mid;
                }
            }
        }

        long n = min;
        if (L >= R) {
            L -= n * (n + 1) / 2;
        } else {
            R -= n * (n + 1) / 2;
            if (R >= n + 1) {
                n++;
                R -= n;
            } else {
                return new long[]{n, L, R};
            }
        }

        min = n;
        max = 2_000_000_000L;
        while (min + 1 < max) {
            long mid = (min + max) / 2;
            long ln = (mid + 1 - n) / 2;
            long rn = mid - n - ln;
            if (L - ln * n - ln * ln >= 0 && R - rn * n - rn * (rn + 1) >= 0) {
                min = mid;
            } else {
                max = mid;
            }
        }

        long ln = (min + 1 - n) / 2;
        long rn = min - n - ln;
        return new long[]{min, L - ln * n - ln * ln, R - rn * n - rn * (rn + 1)};
    }
}