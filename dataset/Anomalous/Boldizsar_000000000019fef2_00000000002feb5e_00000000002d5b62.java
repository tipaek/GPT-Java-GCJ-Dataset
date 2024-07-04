import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        PrintWriter writer = new PrintWriter(outputStream);
        Solver solver = new Solver();
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, scanner, writer);
        }
        writer.close();
    }

    private static class Solver {
        public void solve(int testCase, Scanner scanner, PrintWriter writer) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            List<Point> jumps = new ArrayList<>();
            Set<Point> visited = new HashSet<>();
            jumps.add(new Point(0, 0, 'X', -1, 0));
            visited.add(new Point(0, 0, 'X', -1, 0));
            int index = 0;
            while (index < jumps.size()) {
                Point current = jumps.get(index);
                long hop = current.hop == 0 ? 1 : current.hop * 2;

                Point[] directions = {
                    new Point(current.x, current.y - hop, 'S', index, hop),
                    new Point(current.x, current.y + hop, 'N', index, hop),
                    new Point(current.x + hop, current.y, 'E', index, hop),
                    new Point(current.x - hop, current.y, 'W', index, hop)
                };

                for (Point direction : directions) {
                    if (direction.x == targetX && direction.y == targetY) {
                        writer.printf("Case #%d: ", testCase);
                        printPath(jumps, index, writer);
                        writer.printf("%s\n", direction.dir);
                        writer.flush();
                        return;
                    }
                    if (isValidJump(direction, targetX, targetY, visited)) {
                        jumps.add(direction);
                        visited.add(direction);
                    }
                }
                index++;
            }
            writer.printf("Case #%d: IMPOSSIBLE\n", testCase);
            writer.flush();
        }

        private void printPath(List<Point> jumps, int index, PrintWriter writer) {
            Point point = jumps.get(index);
            if (point.prevIndex == -1) return;
            printPath(jumps, point.prevIndex, writer);
            writer.printf("%s", point.dir);
            writer.flush();
        }

        private boolean isValidJump(Point point, int targetX, int targetY, Set<Point> visited) {
            return !visited.contains(point) &&
                   (Math.abs(point.x) <= Math.abs(targetX * 10) && Math.abs(point.y) <= Math.abs(targetY * 10)) ||
                   (Math.abs(point.x) <= Math.abs(targetY * 10) && Math.abs(point.y) <= Math.abs(targetX * 10));
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
            return x == point.x && y == point.y && hop == point.hop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}