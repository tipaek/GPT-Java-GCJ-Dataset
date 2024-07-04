import java.io.*;
import java.util.*;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            solve(sc);
        } finally {
            sc.close();
        }
    }

    private static void solve(Scanner sc) {
        int T = sc.nextInt();

        traverse();
        for (int i = 1; i <= T; i++) {
            int X = sc.nextInt(), Y = sc.nextInt();
            solve(i, X, Y);
        }
    }

    private static final int[][] DIRS = {
        {1,0},{0,1},{-1,0},{0,-1}
    };
    private static final String SYN = "ENWS";

    private static final Map<Integer, Map<Integer, String>> CACHE = new HashMap<>();

    private static void traverse() {
        Map<Integer, Map<Integer, String>>[] dp = (Map<Integer, Map<Integer, String>>[]) new HashMap[32];
        for (int i = 0; i < 32; i++) {
            dp[i] = new HashMap<>();
        }
        Map<Integer, String> tmp = new HashMap<>();
        tmp.put(0, "");
        dp[0].put(0, tmp);

        for (int j = 0; j < 8; j++) {
            Map<Integer, Map<Integer, String>> m = dp[j];
            int step = (int) Math.pow(2, j);
            for (int x : dp[j].keySet()) {
                for (int y : dp[j].get(x).keySet()) {
                    if (!m.get(x).containsKey(y)) continue;

                    for (int k = 0; k < DIRS.length; k++) {
                        int nx = x + DIRS[k][0] * step, ny = y + DIRS[k][1] * step;
                        dp[j + 1].putIfAbsent(nx, new HashMap<>());
                        dp[j + 1].get(nx).put(ny, m.get(x).get(y) + SYN.charAt(k));
                        if (!CACHE.containsKey(nx)) {
                            CACHE.put(nx, new HashMap<>());
                        }
                        CACHE.get(nx).putIfAbsent(ny, dp[j + 1].get(nx).get(ny));
                    }
                }
            }
            // System.out.println(m);
        }
    }

    private static void solve(int T, int X, int Y) {
        System.out.format("Case #%d: ", T);

        // System.out.format("(%d,%d)", X, Y);
        if (CACHE.containsKey(X) && CACHE.get(X).containsKey(Y)) {
            System.out.println(CACHE.get(X).get(Y));
            return;
        }
        System.out.println("IMPOSSIBLE");
    }

    private static class Item {
        int x;
        int y;
        String s;
        Item(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }

    }

}