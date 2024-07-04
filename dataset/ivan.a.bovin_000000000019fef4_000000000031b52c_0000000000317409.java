import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int T = input.nextInt();
        for (long t = 1; t <= T; ++t) {
            final int X = input.nextInt();
            final int Y = input.nextInt();
            final String M = input.next();
            final boolean zero = X == 0 && Y == 0;

            int x = X;
            int y = Y;

            Integer x2 = zero ? X : null;
            Integer y2 = zero ? Y : null;

            int minutes = 0;

            if (!zero)
                for (minutes = 1; minutes <= M.length(); ++minutes) {
                    char s = M.charAt(minutes - 1);
                    if (s == 'N') {
                        ++y;
                    } else if (s == 'W') {
                        --x;
                    } else if (s == 'S') {
                        --y;
                    } else if (s == 'E') {
                        ++x;
                    }
                    if (distance(x, y) <= minutes) {
                        x2 = x;
                        y2 = y;
                        break;
                    }
                }

            if (x2 == null) {
                System.out.format("Case #%d: IMPOSSIBLE\n", t);
            } else {
                System.out.format("Case #%d: %d\n", t, minutes);
            }
        }
    }

    private static int distance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}
