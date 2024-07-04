import java.util.*;

public class Solution {

    static String best = null;
    static Set<String> set = null;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            sovle(i, x, y);
        }
    }

    private static void sovle(int t, int x, int y) {
        best = null;
        set = new HashSet<>();
        dfs(x, y, 0, 0, 0, "");
        if (best != null) {
            System.out.println("Case #" + t + ": " + best);
        } else {
            System.out.println("Case #" + t + ": IMPOSSIBLE");
        }
    }

    private static void dfs(long x, long y, long a, long b, long k, String path) {
//        if (set.contains(a + " " + b)) return;
//        set.add(a + " " + b);
        if (a < -1_000 || a > 1_000 || b < -1_000 || b > 1_000) return;
        if (x == a && y == b) {
            if (best == null || best.length() > path.length()) {
                best = path;
            }
            return;
        }
//        System.out.println(path + " " + k);
        long d = 1L << k;
        dfs(x, y, a, b + d, k + 1, path + "N");
        dfs(x, y, a, b - d, k + 1, path + "S");
        dfs(x, y, a + d, b, k + 1, path + "E");
        dfs(x, y, a - d, b, k + 1, path + "W");
    }

}