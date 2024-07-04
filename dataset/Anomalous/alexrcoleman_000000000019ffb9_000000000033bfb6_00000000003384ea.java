import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            long L = scanner.nextLong();
            long R = scanner.nextLong();
            long low = 0, high = (long) 2e9;

            while (low < high) {
                long mid = (low + high + 1) / 2;
                long max = Math.max(L, R) - sum(mid);
                long min = Math.min(L, R);

                if (max < min) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }

            if (L >= R) {
                L -= sum(low);
            } else {
                R -= sum(low);
            }

            long base = low;
            low = 0;
            high = (long) 4e9;
            long ansL = L, ansR = R;

            while (low < high) {
                long mid = (low + high + 1) / 2;
                long stepsBig = (mid + 1) / 2;
                long stepsSmall = mid / 2;

                long sumBig = (base + 1) * stepsBig + 2 * sum(stepsBig - 1);
                long sumSmall = (base + 2) * stepsSmall + 2 * sum(stepsSmall - 1);

                if (Math.max(L, R) - sumBig < 0 || Math.min(L, R) - sumSmall < 0) {
                    high = mid - 1;
                } else {
                    low = mid;
                    ansL = (L >= R) ? L - sumBig : L - sumSmall;
                    ansR = (L < R) ? R - sumBig : R - sumSmall;
                }
            }

            long n = base + low;
            System.out.printf("Case #%d: %d %d %d\n", t, n, ansL, ansR);
        }
    }

    static long sum(long n) {
        return n * (n + 1) / 2;
    }
}