import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        tc:
        for (int case_ = 1; case_ <= t; ++case_) {
            int x = in.nextInt();
            int y = in.nextInt();

            long mod = 1;
            long xm = x & mod;
            long ym = y & mod;
            String s = null;

            for (int n = 0; n <= 32; n++) {
                s = t(x, y, n);
                if (s != null) break;
            }

            if (s != null)
                System.out.println("Case #" + case_ + ": " + s.trim());
            else
                System.out.println("Case #" + case_ + ": IMPOSSIBLE");

//            for (int i = 0; i < 32; i++) {
//                if (x < mod && y < mod) {
//                }
//                if (xm == ym) {
//                    System.out.println("Case #" + case_ + ": IMPOSSIBLE");
//                    continue tc;
//                } else if (xm != 0) { // move in X dir
//                } else { // move in Y dir
//                }
//
//                mod <<= 1;
//            }
//
//            StringBuilder sb = new StringBuilder();
//
//
//            System.out.println("Case #" + case_ + ":" + sb);
        }
    }

    public static String t(long x, long y, int n) {
        if (n < 0)
            return "";
        long pwr = 1 << n;
        long pwrs = pwr - 1;
        long xx, yy;
        String s;
        if (Math.abs(xx = x - pwr) <= pwrs && Math.abs(yy = y) <= pwrs) {
            if ((s = t(xx, yy, n - 1)) != null) return s + "E";
        }
        if (Math.abs(xx = x + pwr) <= pwrs && Math.abs(yy = y) <= pwrs) {
            if ((s = t(xx, yy, n - 1)) != null) return s + "W";
        }
        if (Math.abs(xx = x) <= pwrs && Math.abs(yy = y - pwr) <= pwrs) {
            if ((s = t(xx, yy, n - 1)) != null) return s + "N";
        }
        if (Math.abs(xx = x) <= pwrs && Math.abs(yy = y + pwr) <= pwrs) {
            if ((s = t(xx, yy, n - 1)) != null) return s + "S";
        }
        return null;
    }

}
