import java.util.*;
import java.io.*;

// Round 1A 2020: Problem B - 
//
public class Solution {
    public static int[][] solve(int target) {
        // Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        Point start = new Point(1, 1);
        LinkedList<Point> path = new LinkedList<>();
        if (!dfs(start, visited, target, path)) return null;

        int n = path.size();
        int[][] res = new int[n][2];
        for (int i = n - 1; i >= 0; i--) {
            Point p = path.pollLast();
            res[i] = new int[]{p.x, p.y};
        }
        return res;
    }

    private static final int[][] MOVES = {{0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {1, 0}, {1, 1}};

    private static boolean dfs(Point cur, Set<Point> visited, int remain, LinkedList<Point> path) {
        path.offerLast(cur);
        if (!visited.add(cur)) return false;

        int x = cur.x;
        int y = cur.y;
        int v = getValue(x, y);
        remain -= v;
        if (remain < 0) return false;
        if (remain == 0) {
            // System.err.println(visited);
            // System.err.println("path is "+path);
            return true; 
        }

        for (int[] move : MOVES) {
            int nx = x + move[0];
            int ny = y + move[1];
            if (nx < 1 || ny < 1) continue;
            if (ny > nx) continue;
            
            Point p = new Point(nx, ny); 
            if (dfs(p, visited, remain, path)) return true;
            // visited.remove(p);
            path.pollLast();
        }
        return false;
    }

    private static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Point) {
                Point p = (Point)other;
                return x == p.x && y == p.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        public String toString() {
            return x+","+y;
        }
    }

    private static int getValue(int x, int y) {
        List<Integer> row = getRow(x - 1);
        return row.get(y - 1);
    }

    static Map<Integer, List<Integer>> cached = new HashMap<>();
    private static List<Integer> getRow(int rowIndex) {
        List<Integer> res = cached.get(rowIndex);
        if (res != null) return res;

        res = new ArrayList<>(rowIndex + 1);
        cached.put(rowIndex, res);
        res.add(1);
        for (int i = 1; i <= (rowIndex + 1) / 2; i++) {
            res.add((int)((long)res.get(i - 1) * (rowIndex - i + 1) / i));
        }
        for (int i = (rowIndex + 1) / 2 + 1; i <= rowIndex; i++) {
            res.add(res.get(rowIndex - i));
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner in =
            new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int N = in.nextInt();
            out.format("Case #%d:", i);
            out.println();
            for (int[] res : solve(N)) {
                out.println(res[0] + " " + res[1]);
            }
        }
    }
}
