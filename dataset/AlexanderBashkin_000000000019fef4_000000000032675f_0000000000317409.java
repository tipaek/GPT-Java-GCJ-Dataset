
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final int NORM = 1002;
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
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        int[][] distance = new int[NORM*3][NORM*3];
        for (int[] ints : distance) {
            Arrays.fill(ints, -1);
        }
        distance[NORM][NORM] = 0;
        while (!queue.isEmpty()) {
            final Pair p = queue.poll();
            final int dist = distance[p.x + NORM][p.y + NORM];
            if (dist == path.length()) continue;
            for (int[] d : dir) {
                final Pair np = new Pair(p.x + d[0], p.y + d[1]);
                if (distance[np.x + NORM][np.y+NORM] == -1) {
                    distance[np.x + NORM][np.y+NORM] = dist + 1;
                    queue.add(np);
                }
            }
        }
        for (int i = 0; i < path.length(); i++) {
            final char c = path.charAt(i);
            if (c == 'S') y--;
            if (c == 'N') y++;
            if (c == 'W') x--;
            if (c == 'E') x++;
            if (distance[x + NORM][y+NORM] != -1 && distance[x+NORM][y+NORM] <= i+1) {
                System.out.printf("Case #%d: %d\n", t, i+1);
                return;

            }

        }
        System.out.printf("Case #%d: IMPOSSIBLE\n", t);
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
