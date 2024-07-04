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
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        visited.put(0, set);

        LinkedList<Item> queue = new LinkedList<>();
        queue.add(new Item(0, 0, ""));
        int size = 0;
        int step = 1;
        while (!queue.isEmpty() && size < 1000000) {
            int s = queue.size();
            for (int j = 0; j < s; j++) {
                Item curr = queue.removeFirst();
                CACHE.putIfAbsent(curr.x, new HashMap<>());
                CACHE.get(curr.x).put(curr.y, curr.s);
                // System.out.println(curr.x + "," + curr.y);
                for (int i = 0; i < DIRS.length; i++) {
                    int nx = curr.x + DIRS[i][0] * step, ny = curr.y + DIRS[i][1] * step;
                    // System.out.println(nx + "," + ny);
                    if (visited.containsKey(nx) && visited.get(nx).contains(ny)) {
                        continue;
                    }

                    visited.putIfAbsent(nx, new HashSet<>());
                    visited.get(nx).add(ny);

                    size++;
                    queue.add(new Item(nx, ny, curr.s + SYN.charAt(i)));
                }
            }
            step *= 2;
        }
    }

    private static void solve(int T, int X, int Y) {
        System.out.format("Case #%d: ", T);

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