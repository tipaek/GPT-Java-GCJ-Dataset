import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        Solver solver = new Solver();
        int testCount = scanner.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, scanner, writer);
        }
        writer.close();
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

                Point[] directions = {
                    new Point(current.x, current.y - hopDistance, 'S', index, hopDistance),
                    new Point(current.x, current.y + hopDistance, 'N', index, hopDistance),
                    new Point(current.x + hopDistance, current.y, 'E', index, hopDistance),
                    new Point(current.x - hopDistance, current.y, 'W', index, hopDistance)
                };

                for (Point next : directions) {
                    if (next.x == targetX && next.y == targetY) {
                        writer.printf("Case #%d: ", testNumber);
                        printPath(points, index, writer);
                        writer.printf("%s\n", next.dir);
                        writer.flush();
                        return;
                    }
                    if (Math.abs(next.x) <= Math.abs(targetX) && Math.abs(next.y) <= Math.abs(targetY) && !visited.contains(next)) {
                        points.add(next);
                        visited.add(next);
                    }
                }
                index++;
            }
            writer.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            writer.flush();
        }

        private void printPath(List<Point> points, int index, PrintWriter writer) {
            Point point = points.get(index);
            if (point.prevIndex == -1) return;
            printPath(points, point.prevIndex, writer);
            writer.printf("%s", point.dir);
            writer.flush();
        }
    }

    static class Point {
        long x, y;
        char dir;
        int prevIndex;
        long hop;

        public Point(long x, long y, char dir, int prevIndex, long hop) {
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
            return x == point.x && y == point.y && hop < point.hop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}