import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            int n = 0;

            // Calculate the initial difference
            if (l > r) {
                int d = l - r;
                n = (int) Math.ceil(0.5 * (-1 + Math.sqrt(1 + 8 * d)));
                l -= n * (n + 1) / 2;
            } else if (r > l) {
                int d = r - l;
                n = (int) Math.ceil(0.5 * (-1 + Math.sqrt(1 + 8 * d)));
                r -= n * (n + 1) / 2;
            }

            // Adjust l and r to be as equal as possible
            if (l > r) {
                adjustValues(l, r, n);
            } else {
                adjustValues(r, l, n);
            }

            System.out.println("Case #" + t + ": " + n + " " + l + " " + r);
        }
        scan.close();
    }

    private static void adjustValues(int primary, int secondary, int n) {
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
    }
}