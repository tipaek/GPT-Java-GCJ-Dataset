import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            final String res = recurse("", x, y, 1, x, y);
            System.out.println("Case #" + i + ": " + (res.isEmpty() ? "IMPOSSIBLE" : res));
        }
    }

    private static String recurse(String s, int x, int y, int cur, int x0, int y0) {
        if (x==0 && y==0) {
            return s;
        }
        if (cur>Math.pow(2,30)) {
            return "";
        }
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        if (Math.abs(2*x0)>Math.abs(x+cur)) {
            s1 = recurse(s + "W", x + cur, y, cur * 2, x0, y0);
        }
        if (Math.abs(2*x0)>Math.abs(x-cur)) {
            s2 = recurse(s + "E", x - cur, y, cur * 2, x0, y0);
        }
        if (Math.abs(2*y0)>Math.abs(y+cur)) {
            s3 = recurse(s + "S", x, y + cur, cur * 2, x0, y0);
        }
        if (Math.abs(2*y0)>Math.abs(y-cur)) {
            s4 = recurse(s + "N", x, y - cur, cur * 2, x0, y0);
        }
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty() && s4.isEmpty()) {
            return s4;
        }
        int l1 = s1.isEmpty() ? Integer.MAX_VALUE : s1.length();
        int l2 = s2.isEmpty() ? Integer.MAX_VALUE : s2.length();
        int l3 = s3.isEmpty() ? Integer.MAX_VALUE : s3.length();
        int l4 = s4.isEmpty() ? Integer.MAX_VALUE : s4.length();
        if (l1<l2 && l1<l3 && l1<l4) {
            return s1;
        }
        if (l2<l1 && l2<l3 && l2<l4) {
            return s2;
        }
        if (l3<l1 && l3<l2 && l3<l4) {
            return s3;
        }
        return s4;
    }
}