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
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int x = in.nextInt();
            int y = in.nextInt();
            solve(tc, x, y);
        }
        in.close();
    }

    private static void solve(int tc, int x, int y) {
        Point origin = new Point(0, 0, ' ', -1, null);
        Queue<Point> queue = new LinkedList<>();
        queue.add(origin);

        Set<Point> seen = new HashSet<>();
        String sequence = " IMPOSSIBLE";

        while (!queue.isEmpty() && seen.size() < 100000) {
            Point current = queue.poll();

            if (current.x == x && current.y == y) {
                StringBuilder path = new StringBuilder();
                for (Point p = current; p != null; p = p.parent) {
                    path.insert(0, p.d);
                }
                sequence = path.toString();
                break;
            }

            if (seen.contains(current)) continue;
            seen.add(current);

            int delta = (int) Math.pow(2, current.i + 1);
            queue.add(new Point(current.x, current.y + delta, 'N', current.i + 1, current));
            queue.add(new Point(current.x, current.y - delta, 'S', current.i + 1, current));
            queue.add(new Point(current.x + delta, current.y, 'E', current.i + 1, current));
            queue.add(new Point(current.x - delta, current.y, 'W', current.i + 1, current));
        }

        System.out.println("Case #" + tc + ":" + sequence);
    }
}