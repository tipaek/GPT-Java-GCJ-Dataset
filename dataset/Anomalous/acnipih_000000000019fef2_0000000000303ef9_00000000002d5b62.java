import java.util.*;

public class Solution {

    static final long LIMIT = 1_000_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = findPath(x, y);

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    static class Point {
        int x, y;
        String path;

        Point(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y && Objects.equals(path, point.path);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, path);
        }

        @Override
        public String toString() {
            return "Point{" + "x=" + x + ", y=" + y + ", path='" + path + '\'' + '}';
        }
    }

    private static String findPath(int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        Point start = new Point(0, 0, "");
        Queue<Point> queue = new ArrayDeque<>();
        Map<Point, Point> parents = new HashMap<>();
        int step = 0;

        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int diff = 1 << step;

            if (diff > Math.max(absX, absY) * 2) break;

            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                if (current.x == x && current.y == y) {
                    return reconstructPath(current, parents);
                } else {
                    addPointsToQueue(queue, parents, current, diff, x, y);
                }
            }
            step++;
        }
        return "IMPOSSIBLE";
    }

    private static void addPointsToQueue(Queue<Point> queue, Map<Point, Point> parents, Point current, int diff, int targetX, int targetY) {
        List<Point> points = Arrays.asList(
                new Point(current.x - diff, current.y, current.path + "W"),
                new Point(current.x + diff, current.y, current.path + "E"),
                new Point(current.x, current.y - diff, current.path + "S"),
                new Point(current.x, current.y + diff, current.path + "N")
        );

        for (Point p : points) {
            if (p.x == targetX && p.y == targetY) {
                queue.clear();
                queue.offer(p);
                return;
            }
            queue.offer(p);
            parents.put(p, current);
        }
    }

    private static String reconstructPath(Point current, Map<Point, Point> parents) {
        StringBuilder path = new StringBuilder();
        while (current != null && (current.x != 0 || current.y != 0)) {
            path.append(current.path.charAt(current.path.length() - 1));
            current = parents.get(current);
        }
        return path.reverse().toString();
    }
}