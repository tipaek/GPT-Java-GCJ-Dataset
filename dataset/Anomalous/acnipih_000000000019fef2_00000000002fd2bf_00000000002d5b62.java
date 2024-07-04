import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    static final long LIMIT = 1_000_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = findPath(x, y);

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" + "x=" + x + ", y=" + y + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Parent {
        Point point;
        String direction;

        Parent(Point point, String direction) {
            this.point = point;
            this.direction = direction;
        }
    }

    private static List<Parent> getNeighbors(Point point, int step, int targetX, int targetY) {
        int absTargetX = Math.abs(targetX);
        int absTargetY = Math.abs(targetY);
        return Stream.of(
                new Parent(new Point(point.x - step, point.y), "W"),
                new Parent(new Point(point.x + step, point.y), "E"),
                new Parent(new Point(point.x, point.y - step), "S"),
                new Parent(new Point(point.x, point.y + step), "N"))
                .filter(p -> p.point.x >= -absTargetX && p.point.x <= absTargetX && p.point.y >= -absTargetY && p.point.y <= absTargetY)
                .collect(Collectors.toList());
    }

    private static String findPath(int x, int y) {
        Point start = new Point(0, 0);
        Point target = new Point(x, y);
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        Set<Point> visited = new HashSet<>();
        visited.add(start);
        Map<Point, Parent> parents = new HashMap<>();
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                if (current.equals(target)) {
                    return reconstructPath(current, parents, start);
                } else {
                    List<Parent> neighbors = getNeighbors(current, 1 << step, x, y);
                    for (Parent neighbor : neighbors) {
                        if (!visited.contains(neighbor.point)) {
                            visited.add(neighbor.point);
                            queue.offer(neighbor.point);
                            parents.put(neighbor.point, new Parent(current, neighbor.direction));
                        }
                    }
                }
            }
            step++;
        }

        return "IMPOSSIBLE";
    }

    private static String reconstructPath(Point current, Map<Point, Parent> parents, Point start) {
        StringBuilder path = new StringBuilder();
        while (!current.equals(start)) {
            Parent parent = parents.get(current);
            path.append(parent.direction);
            current = parent.point;
        }
        return path.reverse().toString();
    }
}