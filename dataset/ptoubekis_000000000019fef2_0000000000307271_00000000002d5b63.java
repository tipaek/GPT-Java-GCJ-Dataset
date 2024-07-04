import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private final static int L = 1000000000;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            foo(a);
        }
    }

    private static void foo(final int rad) {
        int u = (L - rad) * 2;
        int r = u;
        int d = -u;
        int l = d;
        String s;
        s = ask(0, -L + rad);
        boolean bottom;
        if (s.equals("CENTER")) {
            return;
        } else if (s.equals("HIT")) {
            bottom = true;
        } else {
            bottom = false;
        }
        boolean right;
        s = ask(L - rad, 0);
        if (s.equals("CENTER")) {
            return;
        } else if (s.equals("HIT")) {
            right = true;
        } else {
            right = false;
        }
        boolean top;
        s = ask(0, L - rad);
        if (s.equals("CENTER")) {
            return;
        } else if (s.equals("HIT")) {
            top = true;
        } else {
            top = false;
        }
        boolean left;
        s = ask(0, -L + rad);
        if (s.equals("CENTER")) {
            return;
        } else if (s.equals("HIT")) {
            left = true;
        } else {
            left = false;
        }
        if (bottom) {
            u -= rad;
        } else {
            d += rad / 10;
        }
        if (top) {
            d += rad;
        } else {
            u -= rad / 10;
        }
        if (right) {
            l += rad;
        } else {
            r -= rad / 10;
        }
        if (left) {
            r -= rad;
        } else {
            l += rad / 10;
        }
        for (int x = l; x <= r; x++) {
            for (int y = d; y <= u; y++) {
                s = ask(x, y);
                if (s.equals("CENTER")) {
                    return;
                }
            }
        }
    }

    private static String ask(int x, int y) {
        System.out.println(x + " " + y);
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        return in.next();
    }

}
