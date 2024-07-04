import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int T = scan.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            int n = 0;

            if (l > r) {
                int d = l - r;
                n = (int) Math.ceil(0.5 * (-1 + Math.sqrt(1 + 8 * d)));
                l -= n * (n + 1) / 2;
            } else if (r > l) {
                int d = r - l;
                n = (int) Math.ceil(0.5 * (-1 + Math.sqrt(1 + 8 * d)));
                r -= n * (n + 1) / 2;
            }

            System.out.println(n + " " + l + " " + r);

            if (l > r) {
                n = adjustValues(n, l, r, true);
            } else {
                n = adjustValues(n, r, l, false);
            }

            System.out.println("Case #" + t + ": " + n + " " + l + " " + r);
        }
        
        scan.close();
    }

    private static int adjustValues(int n, int major, int minor, boolean isLeftMajor) {
        int n0 = n + 1;
        int nf = (int) Math.floor(0.001 + 2 * (-0.5 + Math.sqrt(0.25 - (-major - n0 * n0 / 4.0 + n0 / 2.0))));
        
        if (nf >= n0) {
            n += (nf - n0) / 2 + 1;
            major -= (n0 + nf) * ((nf - n0) / 2 + 1) / 2;
        }

        n0 = n0 + 1;
        nf = (int) Math.floor(0.001 + 2 * (-0.5 + Math.sqrt(0.25 - (-minor - n0 * n0 / 4.0 + n0 / 2.0))));
        
        if (nf >= n0) {
            n += (nf - n0) / 2 + 1;
            minor -= (n0 + nf) * ((nf - n0) / 2 + 1) / 2;
        }

        if (isLeftMajor) {
            return n;
        } else {
            return n;
        }
    }
}