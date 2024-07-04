import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        PrintWriter writer = new PrintWriter(outputStream);
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
            List<Point> pointsQueue = new ArrayList<>();
            Set<Point> visitedPoints = new HashSet<>();
            pointsQueue.add(new Point(0, 0, ' ', -1, 0));
            visitedPoints.add(new Point(0, 0, ' ', -1, 0));
            int index = 0;

            while (index < pointsQueue.size()) {
                Point currentPoint = pointsQueue.get(index);
                long nextHop = currentPoint.hop == 0 ? 1 : currentPoint.hop * 2;

                for (Direction direction : Direction.values()) {
                    Point newPoint = direction.move(currentPoint, nextHop);
                    if (newPoint.x == targetX && newPoint.y == targetY) {
                        writer.printf("Case #%d: ", testNumber);
                        printPath(pointsQueue, index, writer);
                        writer.printf("%s\n", direction.symbol);
                        writer.flush();
                        return;
                    }
                    if (isValidJump(newPoint, targetX, targetY, visitedPoints)) {
                        pointsQueue.add(newPoint);
                        visitedPoints.add(newPoint);
                    }
                }

                index++;
            }
            writer.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            writer.flush();
        }

        private void printPath(List<Point> pointsQueue, int index, PrintWriter writer) {
            Point point = pointsQueue.get(index);
            if (point.prevIndex == -1) return;
            printPath(pointsQueue, point.prevIndex, writer);
            writer.printf("%s", point.dir);
            writer.flush();
        }

        private boolean isValidJump(Point point, int targetX, int targetY, Set<Point> visitedPoints) {
            return !visitedPoints.contains(point) &&
                   (Math.abs(point.x) <= targetX && Math.abs(point.y) <= targetY ||
                    Math.abs(point.x) <= targetY && Math.abs(point.y) <= targetX);
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

        Point move(Point current, long hop) {
            return new Point(current.x + dx * hop, current.y + dy * hop, symbol, current.prevIndex, hop);
        }
    }

    private static class Point {
        long x;
        long y;
        char dir;
        int prevIndex;
        long hop;

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
            return x == point.x && y == point.y && hop < point.hop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}