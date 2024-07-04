import java.util.*;
import java.io.*;

public class Solution {

    static class Point {
        int x, y, i;
        char d;
        Point parent;

        public Point(int x, int y, char d, int i, Point parent) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.i = i;
            this.parent = parent;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point other = (Point) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + ", d=" + d + ", i=" + i + "]";
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            for (int tc = 1; tc <= t; tc++) {
                int x = in.nextInt();
                int y = in.nextInt();
                solve(tc, x, y);
            }
        }
    }

    private static void solve(int tc, int x, int y) {
        Point origin = new Point(0, 0, ' ', -1, null);
        Queue<Point> queue = new LinkedList<>();
        queue.add(origin);
        Set<Point> visited = new HashSet<>();
        String sequence = " IMPOSSIBLE";

        while (!queue.isEmpty() && visited.size() < 100000) {
            Point p = queue.poll();
            if (p.x == x && p.y == y) {
                StringBuilder seqBuilder = new StringBuilder();
                for (Point c = p; c != null; c = c.parent) {
                    seqBuilder.insert(0, c.d);
                }
                sequence = seqBuilder.toString();
                break;
            }
            visited.add(p);
            int delta = (int) Math.pow(2, p.i + 1);
            queue.add(new Point(p.x, p.y + delta, 'N', p.i + 1, p));
            queue.add(new Point(p.x, p.y - delta, 'S', p.i + 1, p));
            queue.add(new Point(p.x + delta, p.y, 'E', p.i + 1, p));
            queue.add(new Point(p.x - delta, p.y, 'W', p.i + 1, p));
        }
        System.out.println("Case #" + tc + ":" + sequence);
    }
}