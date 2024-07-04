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
            List<Point> jumps = new ArrayList<>();
            Set<Point> visited = new HashSet<>();
            jumps.add(new Point(0, 0, ' ', -1, 0));
            visited.add(new Point(0, 0, ' ', -1, 0));

            for (int i = 0; i < jumps.size(); i++) {
                Point current = jumps.get(i);
                long hop = current.hop == 0 ? 1 : current.hop * 2;

                for (Direction dir : Direction.values()) {
                    Point next = new Point(current.x + dir.dx * hop, current.y + dir.dy * hop, dir.symbol, i, hop);
                    if (next.x == targetX && next.y == targetY) {
                        writer.printf("Case #%d: ", testNumber);
                        printPath(jumps, i, writer);
                        writer.println(dir.symbol);
                        return;
                    }
                    if (isValidJump(next, targetX, targetY, visited)) {
                        jumps.add(next);
                        visited.add(next);
                    }
                }
            }
            writer.printf("Case #%d: IMPOSSIBLE\n", testNumber);
        }

        private void printPath(List<Point> jumps, int index, PrintWriter writer) {
            if (index == -1) return;
            Point point = jumps.get(index);
            printPath(jumps, point.prevIndex, writer);
            if (point.dir != ' ') writer.print(point.dir);
        }

        private boolean isValidJump(Point point, int targetX, int targetY, Set<Point> visited) {
            return !visited.contains(point) && 
                    (Math.abs(point.x) <= Math.abs(targetX) && Math.abs(point.y) <= Math.abs(targetY));
        }
    }

    private enum Direction {
        NORTH(0, 1, 'N'), 
        SOUTH(0, -1, 'S'), 
        EAST(1, 0, 'E'), 
        WEST(-1, 0, 'W');

        final int dx, dy;
        final char symbol;

        Direction(int dx, int dy, char symbol) {
            this.dx = dx;
            this.dy = dy;
            this.symbol = symbol;
        }
    }

    private static class Point {
        final long x, y;
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
            Point point = (Point) obj;
            return x == point.x && y == point.y && hop <= point.hop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}