import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             PrintWriter writer = new PrintWriter(System.out)) {
            Solver solver = new Solver();
            int testCount = scanner.nextInt();
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, scanner, writer);
            }
        }
    }

    private static class Solver {
        public void solve(int testNumber, Scanner scanner, PrintWriter writer) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            List<Point> points = new ArrayList<>();
            Set<Point> visited = new HashSet<>();
            points.add(new Point(0, 0, ' ', -1, 0));
            visited.add(new Point(0, 0, ' ', -1, 0));
            int index = 0;

            while (index < points.size()) {
                Point current = points.get(index);
                long hopDistance = current.hop == 0 ? 1 : current.hop * 2;

                for (Direction direction : Direction.values()) {
                    Point nextPoint = direction.move(current, hopDistance);

                    if (nextPoint.x == targetX && nextPoint.y == targetY) {
                        writer.printf("Case #%d: ", testNumber);
                        printPath(points, index, writer);
                        writer.println(direction.symbol);
                        return;
                    }

                    if (isValidJump(nextPoint, targetX, targetY, visited)) {
                        points.add(nextPoint);
                        visited.add(nextPoint);
                    }
                }
                index++;
            }
            writer.printf("Case #%d: IMPOSSIBLE\n", testNumber);
        }

        private void printPath(List<Point> points, int index, PrintWriter writer) {
            if (index == -1) return;
            Point point = points.get(index);
            printPath(points, point.prevIndex, writer);
            if (point.dir != ' ') {
                writer.print(point.dir);
            }
        }

        private boolean isValidJump(Point point, int targetX, int targetY, Set<Point> visited) {
            return !visited.contains(point) &&
                    (Math.abs(point.x) <= Math.abs(targetX * 10) && Math.abs(point.y) <= Math.abs(targetY * 10));
        }
    }

    private enum Direction {
        NORTH('N', 0, 1),
        SOUTH('S', 0, -1),
        EAST('E', 1, 0),
        WEST('W', -1, 0);

        final char symbol;
        final int dx;
        final int dy;

        Direction(char symbol, int dx, int dy) {
            this.symbol = symbol;
            this.dx = dx;
            this.dy = dy;
        }

        Point move(Point current, long hopDistance) {
            return new Point(current.x + dx * hopDistance, current.y + dy * hopDistance, symbol, current.prevIndex, hopDistance);
        }
    }

    private static class Point {
        final long x;
        final long y;
        final char dir;
        final int prevIndex;
        final long hop;

        Point(long x, long y, char dir, int prevIndex, long hop) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.prevIndex = prevIndex;
            this.hop = hop;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point other = (Point) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}