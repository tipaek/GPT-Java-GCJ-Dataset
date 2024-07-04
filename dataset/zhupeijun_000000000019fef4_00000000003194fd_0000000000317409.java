
import java.util.*;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);

    private static final Map<Character, int[]> DIR;

    static  {
        DIR = new HashMap<>();
        DIR.put('S', new int[] { 0, -1 });
        DIR.put('N', new int[] { 0, 1 });
        DIR.put('W', new int[] { -1, 0 });
        DIR.put('E', new int[] { 1, 0 });
    }

    private int need(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    private void solve() {
        int cx = sc.nextInt();
        int cy = sc.nextInt();

        if (need(cx, cy) == 0) {
            System.out.println(0);
            return;
        }

        String path = sc.next();
        int m = path.length();
        for (int i = 0; i < m; ++i) {
            int[] d = DIR.get(path.charAt(i));
            cx += d[0];
            cy += d[1];

            if (need(cx, cy) <= i + 1) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private void run() {
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            System.out.print(String.format("Case #%d: ", t));
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}