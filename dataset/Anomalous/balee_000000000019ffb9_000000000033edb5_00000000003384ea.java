import java.util.Scanner;

public class Solution {

    private static void debug(String str) {
        // Debugging is disabled, so this method does nothing
    }

    private static String process(Scanner in) {
        long L = in.nextLong();
        long R = in.nextLong();
        long d = Math.abs(L - R);
        long n = (long) ((Math.sqrt(8 * d + 1) - 1) / 2);

        if (L > R) {
            L -= n * (n + 1) / 2;
        } else {
            R -= n * (n + 1) / 2;
        }

        debug("A " + n + " " + L + " " + R);

        if (L > n || R > n) {
            if (L == R) {
                n++;
                L -= n;
                debug("D " + n + " " + L + " " + R);
            }

            long x = Math.max(L, R);
            long k = Math.max(0, (long) (-(n + 2) + Math.sqrt((n + 2) * (n + 2) - 4 * (n + 1 - x))) / 2);

            debug("B " + k);

            if (k > 0) {
                if (L > R) {
                    L -= (k + 1) * (n + 1) + k * (k + 1);
                    R -= (k - 1) * (n + 1) + k * (k - 1);
                } else {
                    R -= (k + 1) * (n + 1) + k * (k + 1);
                    L -= (k - 1) * (n + 1) + k * (k - 1);
                }
                n += 2 * k;
                debug("C " + n + " " + L + " " + R);
            }
        }

        while (L > n || R > n) {
            n++;
            if (L >= R) {
                L -= n;
            } else {
                R -= n;
            }
            debug("E " + n + " " + L + " " + R);
        }

        return n + " " + L + " " + R;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.format("Case #%d: %s\n", i, process(in));
        }
    }
}