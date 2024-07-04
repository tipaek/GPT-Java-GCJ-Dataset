import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    private void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= tests; t++) {
            final StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String path = tokenizer.nextToken();
            solve(t, x, y, path);
        }
    }

    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    void solve(int t, int x, int y, String path) {
        Map<Pair, List<Integer>> pathMap = new HashMap<>();
        for (int i = 0; i < path.length(); i++) {
            final char c = path.charAt(i);
            if (c == 'S') y--;
            if (c == 'N') y++;
            if (c == 'W') x--;
            if (c == 'E') x++;
            pathMap.computeIfAbsent(new Pair(x, y), p -> new ArrayList<>()).add(i+1);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        Map<Pair, Integer> distance = new HashMap<>();
        distance.put(new Pair(0,0), 0);
        while (!queue.isEmpty()) {
            final Pair p = queue.poll();
            final Integer dist = distance.get(p);
            if (dist == path.length()) continue;
            for (int[] d : dir) {
                final Pair np = new Pair(p.x + d[0], p.y + d[1]);
                if (!distance.containsKey(np)) {
                    distance.put(np, dist + 1);
                    queue.add(np);
                }
            }
        }
        int ans = -1;
        for (Map.Entry<Pair, List<Integer>> entry : pathMap.entrySet()) {
            if (!distance.containsKey(entry.getKey())) continue;
            final Integer d = distance.get(entry.getKey());
            for (Integer xx : entry.getValue()) {
                if (d <= xx && (ans == -1 || xx < ans)) {
                    ans = xx;
                }
            }
        }
        System.out.printf("Case #%d: %s\n", t, (ans == -1 ? "IMPOSSIBLE" : ""+ans));
    }

    static class Pair {
        final int x, y;
        final String s;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
            s = x+"#"+y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return s.hashCode();
        }

        @Override
        public String toString() {
            return x+","+y;
        }
    }
}
