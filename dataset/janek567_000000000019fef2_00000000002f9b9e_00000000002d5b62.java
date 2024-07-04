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
            String res = gm(y, sy > 0 ? 'N' : 'S');
            ot(testCase, res);
            return;
        }
        if (y == 0) {
            String res = gm(x, sx > 0 ? 'E' : 'W');
            ot(testCase, res);
            return;
        }

        long a = 1;
        while (a < y) {
            a <<= 1;
        }
        if (a > y)
            a -= y;
        if (((x & y) != 0) && ((x & a) != 0)) {
            ot(testCase, "IMPOSSIBLE");
            return;
        }
        if (((x & y) == 0)) {
            String res1 = gm(y, sy > 0 ? 'N' : 'S');
            String res2 = gm(x, sx > 0 ? 'E' : 'W');
            ot(testCase, res1 + res2);
            return;
        }
        if (((x & a) == 0)) {
            String res1 = gm(a, sy > 0 ? 'N' : 'S');
            String res2 = gm(x, sx > 0 ? 'E' : 'W');
            ot(testCase, res1 + res2 + ((sy > 0) ? 'S' : 'N'));
            return;
        }
    }

    static void ot(int testCase, String s) {
        System.out.println(String.format("Case #%d: %s", testCase, s));
    }


    static String gm(long a, char c) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((a & (1 << i)) > 0) {
                s.append(c);
            }
        }
        return s.toString();
    }
}