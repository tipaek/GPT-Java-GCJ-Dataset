import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            long left = scanner.nextLong();
            long right = scanner.nextLong();
            long n = 0;

            if (left > right) {
                long difference = left - right;
                n = (long) Math.floor(0.001 + 0.5 * (-1 + Math.sqrt(1 + 4 * 2 * difference)));
                left -= n * (n + 1) / 2;
            } else if (right > left) {
                long difference = right - left;
                n = (long) Math.floor(0.001 + 0.5 * (-1 + Math.sqrt(1 + 4 * 2 * difference)));
                right -= n * (n + 1) / 2;
            }

            if (left >= right) {
                n = adjustValues(n, left, right, true);
            } else {
                n = adjustValues(n, right, left, false);
            }

            System.out.println("Case #" + t + ": " + n + " " + left + " " + right);
        }

        scanner.close();
    }

    private static long adjustValues(long n, long primary, long secondary, boolean isLeftPrimary) {
        long n0 = n + 1;
        long nf = calculateNf(n0, primary);

        if (nf % 2 != n0 % 2) {
            nf--;
        }
        if (nf >= n0) {
            n += (nf - n0) / 2 + 1;
            primary -= (n0 + nf) * ((nf - n0) / 2 + 1) / 2;
        }

        n0++;
        nf = calculateNf(n0, secondary);

        if (nf % 2 != n0 % 2) {
            nf--;
        }
        if (nf >= n0) {
            n += (nf - n0) / 2 + 1;
            secondary -= (n0 + nf) * ((nf - n0) / 2 + 1) / 2;
        }

        if (isLeftPrimary) {
            return n;
        } else {
            return n;
        }
    }

    private static long calculateNf(long n0, long value) {
        return (long) Math.floor(0.001 + 2 * (-0.5 + Math.sqrt(0.25 - (-value - n0 * n0 / 4.0 + n0 / 2.0))));
    }
}