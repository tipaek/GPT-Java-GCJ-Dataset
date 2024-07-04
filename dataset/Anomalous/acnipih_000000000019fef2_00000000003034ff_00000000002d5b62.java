import java.util.*;

public class Solution {

    static long limit = 1_000_000_000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String res = findPath(x, y);

            System.out.println("Case #" + caseNum + ": " + res);
        }
    }

    static class Point {
        int x, y;
        String d;

        public Point(int x, int y, String d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && Objects.equals(d, point.d);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, d);
        }

        @Override
        public String toString() {
            return "Point{" + "x=" + x + ", y=" + y + ", d='" + d + '\'' + '}';
        }
    }

    private static String findPath(int x, int y) {
        int n = Math.abs(x);
        int m = Math.abs(y);
        Point start = new Point(0, 0, "");
        ArrayDeque<Point> queue = new ArrayDeque<>();
        Map<Point, Point> parents = new HashMap<>();
        int step = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int diff = 1 << step;
            if (diff > Math.max(n, m)) break;

            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                if (current.x == x && current.y == y) {
                    return reconstructPath(current, parents);
                } else {
                    List<Point> neighbors = Arrays.asList(
                            new Point(current.x - diff, current.y, current.d + "W"),
                            new Point(current.x + diff, current.y, current.d + "E"),
                            new Point(current.x, current.y - diff, current.d + "S"),
                            new Point(current.x, current.y + diff, current.d + "N")
                    );

                    for (Point p : neighbors) {
                        if (p.x == x && p.y == y) {
                            return p.d;
                        }
                        if (!parents.containsKey(p)) {
                            queue.offer(p);
                            parents.put(p, current);
                        }
                    }
                }
            }
            step++;
        }
        return "IMPOSSIBLE";
    }

    private static String reconstructPath(Point current, Map<Point, Point> parents) {
        StringBuilder path = new StringBuilder();
        while (current != null && (current.x != 0 || current.y != 0)) {
            path.append(current.d.charAt(current.d.length() - 1));
            current = parents.get(current);
        }
        return path.reverse().toString();
    }
}