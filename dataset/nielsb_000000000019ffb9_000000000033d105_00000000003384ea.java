import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            String solution = new Solution(scanner).solve();
            System.out.println("Case #" + t + ": " + solution);
        }
    }

    final long L, R;
    long high, low;
    boolean sw;

    public Solution(Scanner scanner) {
        L = scanner.nextLong();
        R = scanner.nextLong();
        sw = L < R;
        high = sw ? R : L;
        low = sw ? L : R;
    }

    private String solve() {
        long n = firstSet(high - low);
        high -= (n * (n + 1)) / 2;

        if (high == low) {
            sw = false;
        }

        long n2 = secondSet(high, n - 1, 0, high);
        long n3 = secondSet(low, n, 0, low);

        if (n2 - n3 > 1 || n3 - n2 > 1)
            throw new RuntimeException();

        long total = n + n2 + n3;
        high -= (n + n2) * n2;
        low -= (n + n3 + 1) * n3;


        return "" + total + " " + (sw ? low : high) + " " + (sw ? high : low);
    }

    private long firstSet(long s) {
        long t = (long) Math.sqrt(2 * s);
        if (t * (t + 1) <= 2 * s) {
            return t;
        } else {
            return t - 1;
        }
    }

    private long secondSet(long stack, long n, long min, long max) {
        if (min + 1 == max) {
            return min;
        }
        long a = min + (max - min) / 2;
        if (Long.MAX_VALUE / a < n + a) {
            return secondSet(stack, n, min, a);
        }
        if ((n + a + 1) * a <= stack) {
            return secondSet(stack, n, a, max);
        } else {
            return secondSet(stack, n, min, a);
        }
    }


}
