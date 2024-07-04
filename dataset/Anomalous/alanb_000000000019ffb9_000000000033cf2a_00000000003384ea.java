import java.util.Scanner;

public class Solution {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        final int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int n = 0;

            // Adjust l and r to be within one value of n away from each other
            if (l > r) {
                n = adjustValues(l, r);
                l -= n * (n + 1) / 2;
            } else if (r > l) {
                n = adjustValues(r, l);
                r -= n * (n + 1) / 2;
            }

            // Further adjust l and r based on the current value of n
            if (l >= r) {
                n = furtherAdjustValues(l, n);
                l = updateValue(l, n);
                n++;
                n = furtherAdjustValues(r, n);
                r = updateValue(r, n);
            } else {
                n = furtherAdjustValues(r, n);
                r = updateValue(r, n);
                n++;
                n = furtherAdjustValues(l, n);
                l = updateValue(l, n);
            }

            System.out.println("Case #" + t + ": " + n + " " + l + " " + r);
        }
        scanner.close();
    }

    private static int adjustValues(int a, int b) {
        int d = a - b;
        return (int) Math.ceil(0.5 * (-1 + Math.sqrt(1 + 4 * 2 * d)));
    }

    private static int furtherAdjustValues(int value, int n) {
        int n0 = n + 1;
        int nf = (int) Math.floor(0.001 + 2 * (-0.5 + Math.sqrt(0.25 - (-value - n0 * n0 / 4.0 + n0 / 2.0))));
        if (nf >= n0) {
            n += (nf - n0) / 2 + 1;
        }
        return n;
    }

    private static int updateValue(int value, int n) {
        int n0 = n + 1;
        int nf = (int) Math.floor(0.001 + 2 * (-0.5 + Math.sqrt(0.25 - (-value - n0 * n0 / 4.0 + n0 / 2.0))));
        if (nf >= n0) {
            value -= (n0 + nf) * ((nf - n0) / 2 + 1) / 2;
        }
        return value;
    }
}