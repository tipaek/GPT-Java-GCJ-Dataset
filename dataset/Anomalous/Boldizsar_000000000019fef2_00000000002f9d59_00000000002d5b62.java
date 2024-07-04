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
            jumps.add(new Point(0, 0, ' ', -1, 0));

            for (int i = 0; i < jumps.size(); i++) {
                Point current = jumps.get(i);
                long hop = current.hop == 0 ? 1 : current.hop * 2;

                if (tryJump(jumps, current, targetX, targetY, i, hop, 'S', 0, -hop, writer, testNumber) ||
                    tryJump(jumps, current, targetX, targetY, i, hop, 'N', 0, hop, writer, testNumber) ||
                    tryJump(jumps, current, targetX, targetY, i, hop, 'E', hop, 0, writer, testNumber) ||
                    tryJump(jumps, current, targetX, targetY, i, hop, 'W', -hop, 0, writer, testNumber)) {
                    return;
                }
            }
            writer.printf("Case #%d: IMPOSSIBLE\n", testNumber);
        }

        private boolean tryJump(List<Point> jumps, Point current, int targetX, int targetY, int i, long hop, char direction, long dx, long dy, PrintWriter writer, int testNumber) {
            Point newPoint = new Point(current.x + dx, current.y + dy, direction, i, hop);
            if (newPoint.x == targetX && newPoint.y == targetY) {
                writer.printf("Case #%d: ", testNumber);
                printPath(jumps, i, writer);
                writer.printf("%s\n", direction);
                return true;
            }
            if (Math.abs(newPoint.x) <= Math.abs(targetX) && Math.abs(newPoint.y) <= Math.abs(targetY)) {
                jumps.add(newPoint);
            }
            return false;
        }

        private void printPath(List<Point> jumps, int i, PrintWriter writer) {
            if (i == -1) return;
            printPath(jumps, jumps.get(i).prevIndex, writer);
            writer.printf("%s", jumps.get(i).dir);
        }
    }

    private static class Point {
        long x, y;
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