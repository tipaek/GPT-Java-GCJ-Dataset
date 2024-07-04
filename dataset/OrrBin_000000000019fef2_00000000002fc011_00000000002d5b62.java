import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static int targetX, targetY;
    static int MAX_STEPS = 12;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();

            if (x % 2 != 0 && y % 2 != 0) {
                System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
                continue;
            }

            if (x % 2 == 0 && y % 2 == 0) {
                System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
                continue;
            }


            targetX = x;
            targetY = y;


            StringBuffer sb = new StringBuffer();
            // X is odd
            if (x % 2 != 0) {
                String e = rec("E", 1, 0, 1);
                String w = rec("W", -1, 0, 1);

                if (e == null && w == null) {
                    System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
                } else if (e == null) {
                    System.out.println(String.format("Case #%d: %s", i, w));
                } else {
                    System.out.println(String.format("Case #%d: %s", i, e));
                }
            }

            // Y is odd
            else {
                String n = rec("N", 0, 1, 1);
                String s = rec("S", 0, -1, 1);

                if (n == null && s == null) {
                    System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
                } else if (n == null) {
                    System.out.println(String.format("Case #%d: %s", i, s));
                } else {
                    System.out.println(String.format("Case #%d: %s", i, n));
                }

            }
        }
    }

    static String rec(String prevSteps, int x, int y, int step) {

        if (x == targetX && y == targetY) {
            return prevSteps;
        }

        if (step >= MAX_STEPS) {
            return null;
        }

        String e = rec(prevSteps + "E", x + (int) Math.pow(2, step), y, step + 1);

        String w = rec(prevSteps + "W", x - (int) Math.pow(2, step), y, step + 1);

        String n = rec(prevSteps + "N", x, y + (int) Math.pow(2, step), step + 1);

        String s = rec(prevSteps + "S", x, y - (int) Math.pow(2, step), step + 1);

        int eLen = e == null ? Integer.MAX_VALUE : e.length();
        int wLen = w == null ? Integer.MAX_VALUE : w.length();
        int nLen = n == null ? Integer.MAX_VALUE : n.length();
        int sLen = s == null ? Integer.MAX_VALUE : s.length();

        int tmp = Math.min(eLen, Math.min(wLen, Math.min(nLen, sLen)));

        if (tmp == Integer.MAX_VALUE)
            return null;

        if (tmp == eLen)
            return e;
        else if (tmp == wLen)
            return w;
        else if (tmp == nLen)
            return n;
        else
            return s;

    }
}