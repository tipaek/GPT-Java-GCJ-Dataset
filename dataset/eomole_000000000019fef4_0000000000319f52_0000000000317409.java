import java.util.Scanner;

class A {
    public static void main(String... args) throws Exception {
        final int[] dx = new int[128];
        final int[] dy = new int[128];
        dx['N'] = 0;
        dy['N'] = 1;
        dx['S'] = 0;
        dy['S'] = -1;
        dx['E'] = 1;
        dy['E'] = 0;
        dx['W'] = -1;
        dy['W'] = 0;
        try (final Scanner sc = new Scanner(System.in)) {
            final int T = sc.nextInt();
            for (int t = 1; t <= T; t++) {
                final int X = sc.nextInt();
                final int Y = sc.nextInt();
                final char[] M = sc.next().toCharArray();
                int ans = X == 0 && Y == 0 ? 0 : Integer.MAX_VALUE;
                for (int i = 0, x = X, y = Y; i < M.length && ans == Integer.MAX_VALUE; i++) {
                    x += dx[M[i]];
                    y += dy[M[i]];
                    if (Math.abs(x) + Math.abs(y) <= i + 1) {
                        ans = i + 1;
                    }
                }
                System.out.printf("Case #%s: %s\n", t, ans < Integer.MAX_VALUE ? ans : "IMPOSSIBLE");
            }
        }
    }
}
public class Solution {
    public static void main(String...args) throws Exception {
        A.main();
    }
}
