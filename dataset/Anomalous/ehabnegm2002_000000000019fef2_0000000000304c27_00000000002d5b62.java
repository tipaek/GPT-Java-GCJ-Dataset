import java.util.*;

class Point {
    int x, y, steps;
    String path;

    Point(int x, int y, int steps, String path) {
        this.x = x;
        this.y = y;
        this.steps = steps;
        this.path = path;
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
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int testCase = 1; testCase <= cases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Case #" + testCase + ": " + findPath(x, y));
        }
        scanner.close();
    }

    private static String findPath(int x, int y) {
        Set<Point> visited = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        Point origin = new Point(0, 0, 1, "");
        Point target = new Point(x, y, 0, "");

        if ((Math.abs(origin.x - target.x) % 2 != 0) && (Math.abs(origin.y - target.y) % 2 != 0)) {
            return "IMPOSSIBLE";
        }

        queue.offer(origin);

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == target.x && current.y == target.y) {
                return current.path;
            }

            visited.add(current);

            int stepSize = (int) Math.pow(2, current.steps - 1);

            Point[] nextPoints = {
                new Point(current.x + stepSize, current.y, current.steps + 1, current.path + "E"),
                new Point(current.x, current.y + stepSize, current.steps + 1, current.path + "N"),
                new Point(current.x - stepSize, current.y, current.steps + 1, current.path + "W"),
                new Point(current.x, current.y - stepSize, current.steps + 1, current.path + "S")
            };

            for (Point nextPoint : nextPoints) {
                if (!visited.contains(nextPoint)) {
                    queue.offer(nextPoint);
                }
            }
        }

        return "IMPOSSIBLE";
    }
}