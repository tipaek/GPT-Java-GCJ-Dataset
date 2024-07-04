import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int testCount = nextInt();
        for (int test = 1; test <= testCount; test++) {
            out.print("Case #" + test + ": ");
            solve();
        }
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private class Pair {
        int x, y;
        Pair prev;
        String dir;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair(int x, int y, Pair prev, String dir) {
            this.x = x;
            this.y = y;
            this.prev = prev;
            this.dir = dir;
        }
    }

    private void solve() {
        int x = nextInt();
        int y = nextInt();
        String north = y > 0 ? "N" : "S";
        String south = y < 0 ? "N" : "S";
        String east = x > 0 ? "E" : "W";
        String west = x < 0 ? "E" : "W";
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, y));
        Pair result = null;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            x = current.x;
            y = current.y;

            if (x == 0 && y == 0) {
                result = current;
                break;
            }

            if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
                continue;
            }

            if (x % 2 != 0) {
                queue.add(new Pair((x - 1) / 2, y / 2, current, east));
                queue.add(new Pair((x + 1) / 2, y / 2, current, west));
            } else {
                queue.add(new Pair(x / 2, (y - 1) / 2, current, north));
                queue.add(new Pair(x / 2, (y + 1) / 2, current, south));
            }
        }

        if (result == null) {
            out.println("IMPOSSIBLE");
            return;
        }

        StringBuilder path = new StringBuilder();
        while (result.dir != null) {
            path.append(result.dir);
            result = result.prev;
        }
        out.println(path.reverse().toString());
    }
}