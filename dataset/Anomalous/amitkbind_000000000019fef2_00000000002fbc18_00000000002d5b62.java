import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            String result = "IMPOSSIBLE";
            Map<Integer, Set<Integer>> visited = new HashMap<>();
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(0, 0));
            Point delimiter = new Point(-1, -1);
            queue.add(delimiter);
            int step = 1;

            while (!queue.isEmpty()) {
                while (queue.peek() != delimiter) {
                    Point point = queue.poll();
                    int x = point.x;
                    int y = point.y;
                    visited.computeIfAbsent(x, k -> new HashSet<>()).add(y);

                    if (x == targetX && y == targetY) {
                        result = point.path;
                        break;
                    }

                    if (isValid(targetX, targetY, x - step, y) && !visited.getOrDefault(x - step, Collections.emptySet()).contains(y)) {
                        queue.add(new Point(x - step, y, point.path + "W"));
                    }
                    if (isValid(targetX, targetY, x + step, y) && !visited.getOrDefault(x + step, Collections.emptySet()).contains(y)) {
                        queue.add(new Point(x + step, y, point.path + "E"));
                    }
                    if (isValid(targetX, targetY, x, y - step) && !visited.getOrDefault(x, Collections.emptySet()).contains(y - step)) {
                        queue.add(new Point(x, y - step, point.path + "S"));
                    }
                    if (isValid(targetX, targetY, x, y + step) && !visited.getOrDefault(x, Collections.emptySet()).contains(y + step)) {
                        queue.add(new Point(x, y + step, point.path + "N"));
                    }
                }

                queue.poll();
                if (!queue.isEmpty()) {
                    queue.add(delimiter);
                }
                step *= 2;
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    static boolean isValid(int targetX, int targetY, int x, int y) {
        return Math.abs(x) <= Math.abs(2 * targetX) && Math.abs(y) <= Math.abs(2 * targetY);
    }
}

class Point {
    String path;
    int x, y;

    Point(int x, int y) {
        this(x, y, "");
    }

    Point(int x, int y, String path) {
        this.path = path;
        this.x = x;
        this.y = y;
    }
}