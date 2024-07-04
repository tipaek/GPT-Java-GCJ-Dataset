import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static boolean rev_x = false;
    static boolean rev_y = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            rev_x = (x0 < 0);
            rev_y = (y0 < 0);
            x0 = Math.abs(x0);
            y0 = Math.abs(y0);

            int[] x = bits(x0);
            int[] y = bits(y0);

            String sol = solve(x, y, 0, 0, 0, "");
            if (sol == null) {
                sol = "IMPOSSIBLE";
            }

            System.out.printf("Case #%d: %s%n", i + 1, sol);
        }

    }

    private static String solve(int[] x, int[] y, int i, int carry_x, int carry_y, String ans) {
        if (x.length <= i && y.length <= i && carry_x == 0 && carry_y == 0) {
            return ans;
        }
        int x0 = i < x.length ? x[i] : 0;
        int y0 = i < y.length ? y[i] : 0;

        if ((x0 + carry_x == 1) == (y0 + carry_y == 1)) {
            return null;
        }

        if (x0 + carry_x == 1) {
            String c1 = solve(x, y, i+1, 0, carry_y, ans + (rev_x ? "W" : "E"));
            if (c1 != null) {
                return c1;
            }
            return solve(x, y, i+1, 1, carry_y, ans + (rev_x ? "E" : "W"));
        } else if (y0 + carry_y == 1) {
            String c1 = solve(x, y, i+1, carry_x, 0, ans + (rev_y ? "S" : "N"));
            if (c1 != null) {
                return c1;
            }
            return solve(x, y, i+1, carry_x, 1, ans + (rev_y ? "N" : "S"));
        }
        return null;
    }

    static int[] bits(int x) {
        ArrayList<Integer> out = new ArrayList<>();
        while (x > 0) {
            out.add(x % 2);
            x /= 2;
        }
        return out.stream().mapToInt(a -> a).toArray();
    }
}
