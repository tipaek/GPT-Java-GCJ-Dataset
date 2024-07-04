import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String result = "IMPOSSIBLE";
            Map<Integer, Set<Integer>> visited = new HashMap<>();
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(0, 0));
            int step = 1;
            Point delimiter = new Point(-1, -1);
            queue.add(delimiter);

            outerLoop:
            while (!queue.isEmpty()) {
                while (queue.peek() != delimiter) {
                    Point current = queue.poll();
                    int x = current.x;
                    int y = current.y;

                    visited.computeIfAbsent(x, k -> new HashSet<>()).add(y);

                    if (x == X && y == Y) {
                        result = current.path;
                        break outerLoop;
                    }

                    addNextPoint(queue, visited, x - step, y, current.path + "W", X, Y);
                    addNextPoint(queue, visited, x + step, y, current.path + "E", X, Y);
                    addNextPoint(queue, visited, x, y - step, current.path + "S", X, Y);
                    addNextPoint(queue, visited, x, y + step, current.path + "N", X, Y);
                }

                queue.poll();
                if (!queue.isEmpty()) {
                    queue.add(delimiter);
                }
                step *= 2;
            }
            System.out.println("Case #" + tc + ": " + result);
        }
    }

    private static void addNextPoint(Queue<Point> queue, Map<Integer, Set<Integer>> visited, int x, int y, String path, int X, int Y) {
        if (isValid(X, Y, x, y) && (!visited.containsKey(x) || !visited.get(x).contains(y))) {
            queue.add(new Point(x, y, path));
        }
    }

    private static boolean isValid(int X, int Y, int x, int y) {
        return Math.abs(x) <= Math.abs(X) && Math.abs(y) <= Math.abs(Y);
    }
}

class Point {
    String path;
    int x, y;

    Point(int x, int y) {
        this(x, y, "");
    }

    Point(int x, int y, String path) {
        this.x = x;
        this.y = y;
        this.path = path;
    }
}