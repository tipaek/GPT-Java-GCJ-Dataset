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
            return String.format("Point [x=%d, y=%d, d=%c, i=%d]", x, y, d, i);
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
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, ' ', -1, null));

        Set<Point> seen = new HashSet<>();
        String sequence = " IMPOSSIBLE";

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == x && p.y == y) {
                StringBuilder seqBuilder = new StringBuilder();
                for (Point current = p; current != null; current = current.parent) {
                    seqBuilder.insert(0, current.d);
                }
                sequence = seqBuilder.toString();
                break;
            }

            if (Math.abs(p.x) > 100 || Math.abs(p.y) > 100) continue;
            if (!seen.add(p)) continue;

            int delta = (int) Math.pow(2, p.i + 1);
            queue.add(new Point(p.x, p.y + delta, 'N', p.i + 1, p));
            queue.add(new Point(p.x, p.y - delta, 'S', p.i + 1, p));
            queue.add(new Point(p.x + delta, p.y, 'E', p.i + 1, p));
            queue.add(new Point(p.x - delta, p.y, 'W', p.i + 1, p));
        }

        System.out.println("Case #" + tc + ":" + sequence);
    }
}