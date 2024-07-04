import java.util.Scanner;
import java.io.FileNotFoundException;

public class Solution {
    static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(System.in);
        final int T = scan.nextInt();

        for (int t = 1; t <= T; t++) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            int n = 0;

            // Adjust l and r to be within one value of n away from each other
            if (l > r) {
                int d = l - r;
                n = (int) Math.floor(0.001 + 0.5 * (-1 + Math.sqrt(1 + 4 * 2 * d)));
                l -= n * (n + 1) / 2;
            } else if (r > l) {
                int d = r - l;
                n = (int) Math.floor(0.001 + 0.5 * (-1 + Math.sqrt(1 + 4 * 2 * d)));
                r -= n * (n + 1) / 2;
            }

            if (l >= r) {
                n = adjustValues(n, l, r, true);
            } else {
                n = adjustValues(n, r, l, false);
            }

            System.out.println("Case #" + t + ": " + n + " " + l + " " + r);
        }

        scan.close();
    }

    private static int adjustValues(int n, int larger, int smaller, boolean isLargerFirst) {
        int n0 = n + 1;
        int nf = (int) Math.floor(0.001 + 2 * (-0.5 + Math.sqrt(0.25 - (-larger - n0 * n0 / 4.0 + n0 / 2.0))));

        if (nf % 2 != n0 % 2) {
            nf--;
        }

        if (nf >= n0) {
            n += (nf - n0) / 2 + 1;
            larger -= (n0 + nf) * ((nf - n0) / 2 + 1) / 2;
        }

        n0 = n0 + 1;
        nf = (int) Math.floor(0.001 + 2 * (-0.5 + Math.sqrt(0.25 - (-smaller - n0 * n0 / 4.0 + n0 / 2.0))));

        if (nf % 2 != n0 % 2) {
            nf--;
        }

        if (nf >= n0) {
            n += (nf - n0) / 2 + 1;
            smaller -= (n0 + nf) * ((nf - n0) / 2 + 1) / 2;
        }

        if (isLargerFirst) {
            return n;
        } else {
            return n;
        }
    }
}