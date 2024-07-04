import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter printWriter = new PrintWriter(System.out);
        Solver solver = new Solver();
        int testCount = scanner.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, scanner, printWriter);
        }
        printWriter.close();
    }

    private static class Solver {
        public void solve(int testNumber, Scanner scanner, PrintWriter printWriter) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            List<Point> pointsToVisit = new ArrayList<>();
            Set<Point> visitedPoints = new HashSet<>();
            pointsToVisit.add(new Point(0, 0, ' ', -1, 0));
            visitedPoints.add(new Point(0, 0, ' ', -1, 0));
            int index = 0;

            while (index < pointsToVisit.size()) {
                Point currentPoint = pointsToVisit.get(index);
                long nextHop = currentPoint.hop == 0 ? 1 : currentPoint.hop * 2;

                for (Direction direction : Direction.values()) {
                    Point nextPoint = direction.move(currentPoint, nextHop);
                    if (nextPoint.x == targetX && nextPoint.y == targetY) {
                        printWriter.printf("Case #%d: ", testNumber);
                        printPath(pointsToVisit, index, printWriter);
                        printWriter.printf("%s\n", direction.symbol);
                        printWriter.flush();
                        return;
                    }
                    if (isValidJump(nextPoint, targetX, targetY, visitedPoints)) {
                        pointsToVisit.add(nextPoint);
                        visitedPoints.add(nextPoint);
                    }
                }
                index++;
            }
            printWriter.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            printWriter.flush();
        }
    }

    private static void printPath(List<Point> pointsToVisit, int index, PrintWriter printWriter) {
        Point point = pointsToVisit.get(index);
        if (point.prevIndex == -1) return;
        printPath(pointsToVisit, point.prevIndex, printWriter);
        printWriter.printf("%s", point.direction);
        printWriter.flush();
    }

    private static boolean isValidJump(Point point, int targetX, int targetY, Set<Point> visitedPoints) {
        return !visitedPoints.contains(point) &&
               (Math.abs(point.x) <= Math.abs(targetX * 100) && Math.abs(point.y) <= Math.abs(targetY * 100));
    }

    static class Point {
        long x, y;
        char direction;
        int prevIndex;
        long hop;

        public Point(long x, long y, char direction, int prevIndex, long hop) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.prevIndex = prevIndex;
            this.hop = hop;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point other = (Point) obj;
            return x == other.x && y == other.y && hop < other.hop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private enum Direction {
        NORTH('N', 0, 1),
        SOUTH('S', 0, -1),
        EAST('E', 1, 0),
        WEST('W', -1, 0);

        final char symbol;
        final int dx, dy;

        Direction(char symbol, int dx, int dy) {
            this.symbol = symbol;
            this.dx = dx;
            this.dy = dy;
        }

        Point move(Point currentPoint, long hop) {
            return new Point(currentPoint.x + dx * hop, currentPoint.y + dy * hop, symbol, currentPoint.prevIndex, hop);
        }
    }
}