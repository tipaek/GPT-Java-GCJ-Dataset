import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
            solve(in, testCase);
        }
    }

    static void solve(Scanner in, int testCase) {
        long sx = in.nextLong();
        long sy = in.nextLong();

        long x = (sx < 0) ? -sx : sx;
        long y = (sy < 0) ? -sy : sy;

        if (x == 0 && y == 0) {
            ot(testCase, "");
            return;
        }

        if (x == 0) {
            String res = gm(x, y, 'X', sy > 0 ? 'N' : 'S');
            ot(testCase, res);
            return;
        }
        if (y == 0) {
            String res = gm(x, y, sx > 0 ? 'E' : 'W', 'Y');
            ot(testCase, res);
            return;
        }

        long a = 1;
        while (a < y || ((a & x) > 0)) {
            a <<= 1;
        }
        long aa = a;
        if (a > y)
            a -= y;
        if (((x & y) != 0) && ((x & a) != 0)) {
            ot(testCase, "IMPOSSIBLE");
            return;
        }
        if (((x & y) == 0)) {
            String res = gm(x, y, sx > 0 ? 'E' : 'W', sy > 0 ? 'N' : 'S');
            ot(testCase, res);
            return;
        }
        if (((x & a) == 0)) {
            String res = gm(x, a, sx > 0 ? 'E' : 'W', sy > 0 ? 'S' : 'N');
            ot(testCase, res + ((sy > 0) ? 'N' : 'S'));
            return;
        }
    }

    static void ot(int testCase, String s) {
        System.out.println(String.format("Case #%d: %s", testCase, s));
    }


    static String gm(long x, long y, char cx, char cy) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((x & (1 << i)) > 0) {
                s.append(cx);
            } else if ((y & (1 << i)) > 0) {
                s.append(cy);
            }
        }
        return s.toString();
    }
}