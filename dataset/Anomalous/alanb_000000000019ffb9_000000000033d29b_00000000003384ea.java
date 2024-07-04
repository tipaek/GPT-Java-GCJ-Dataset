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

            if (l != r) {
                int d = Math.abs(l - r);
                n = (int) Math.floor(0.001 + 0.5 * (-1 + Math.sqrt(1 + 4 * 2 * d)));
                if (l > r) {
                    l -= n * (n + 1) / 2;
                } else {
                    r -= n * (n + 1) / 2;
                }
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

    private static int adjustValues(int n, int primary, int secondary, boolean isPrimaryL) {
        int n0 = n + 1;
        int nf = (int) Math.floor(0.001 + 2 * (-0.5 + Math.sqrt(0.25 - (-primary - n0 * n0 / 4.0 + n0 / 2.0))));
        
        if (nf >= n0) {
            n += (nf - n0) / 2 + 1;
            primary -= (n0 + nf) * ((nf - n0) / 2 + 1) / 2;
        }

        n0 += 1;
        nf = (int) Math.floor(0.001 + 2 * (-0.5 + Math.sqrt(0.25 - (-secondary - n0 * n0 / 4.0 + n0 / 2.0))));
        
        if (nf >= n0) {
            n += (nf - n0) / 2 + 1;
            secondary -= (n0 + nf) * ((nf - n0) / 2 + 1) / 2;
        }

        if (isPrimaryL) {
            return n;
        } else {
            int temp = primary;
            primary = secondary;
            secondary = temp;
            return n;
        }
    }
}