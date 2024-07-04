import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Point {
        int x, y;
        String path = "";

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = findPath(new Point(x, y));
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String findPath(Point target) {
        int[] deltaX = {1, 0, 0, -1};
        int[] deltaY = {0, 1, -1, 0};
        String[] directions = {"E", "N", "S", "W"};
        Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();

        Point start = new Point(0, 0);
        queue.offer(start);
        visited.add(start);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (exceedsSize(target, level)) break;

            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nextX = current.x + deltaX[j] * (1 << level);
                    int nextY = current.y + deltaY[j] * (1 << level);

                    if (nextX == target.x && nextY == target.y) {
                        return current.path + directions[j];
                    }

                    Point next = new Point(nextX, nextY);
                    if (visited.contains(next)) continue;

                    next.path = current.path + directions[j];
                    queue.offer(next);
                    visited.add(next);
                }
            }
            level++;
        }

        return "IMPOSSIBLE";
    }

    static boolean exceedsSize(Point target, int level) {
        int maxDistance = (Math.abs(target.x) + Math.abs(target.y)) * 20;
        return maxDistance < (1 << level);
    }
}