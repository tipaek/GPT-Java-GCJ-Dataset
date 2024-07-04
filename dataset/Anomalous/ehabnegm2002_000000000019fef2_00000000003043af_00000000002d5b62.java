import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

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
        return 31 * x + y;
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
        try (Scanner scanner = new Scanner(System.in)) {
            int cases = scanner.nextInt();

            for (int testCase = 1; testCase <= cases; testCase++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                System.out.println("Case #" + testCase + ": " + findPath(x, y));
            }
        }
    }

    private static String findPath(int x, int y) {
        Set<Point> visited = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1, ""));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == x && current.y == y) {
                return current.path;
            }

            if ((current.x - x) % 2 != 0 && (current.y - y) % 2 != 0) {
                continue;
            }

            visited.add(current);
            int stepSize = (int) Math.pow(2, current.steps - 1);

            Point[] nextPoints = {
                new Point(current.x + stepSize, current.y, current.steps + 1, current.path + "E"),
                new Point(current.x, current.y + stepSize, current.steps + 1, current.path + "N"),
                new Point(current.x - stepSize, current.y, current.steps + 1, current.path + "W"),
                new Point(current.x, current.y - stepSize, current.steps + 1, current.path + "S")
            };

            for (Point next : nextPoints) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                }
            }
        }

        return "IMPOSSIBLE";
    }
}