import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        int testCount = in.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    private static class Solver {

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int x = in.nextInt();
            int y = in.nextInt();
            List<Point> jumps = new ArrayList<>();
            Set<Point> visited = new HashSet<>();
            Point startPoint = new Point(0, 0, 'x', -1, 0);
            jumps.add(startPoint);
            visited.add(startPoint);
            int i = 0;

            while (i < jumps.size()) {
                Point current = jumps.get(i);
                long hopDistance = current.hop == 0 ? 1 : current.hop * 2;

                if (processDirection(jumps, visited, current, x, y, 'S', 0, -hopDistance, i, hopDistance, testNumber, out)) return;
                if (processDirection(jumps, visited, current, x, y, 'N', 0, hopDistance, i, hopDistance, testNumber, out)) return;
                if (processDirection(jumps, visited, current, x, y, 'E', hopDistance, 0, i, hopDistance, testNumber, out)) return;
                if (processDirection(jumps, visited, current, x, y, 'W', -hopDistance, 0, i, hopDistance, testNumber, out)) return;

                ++i;
            }
            out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            out.flush();
        }

        private boolean processDirection(List<Point> jumps, Set<Point> visited, Point current, int targetX, int targetY, char direction, long dx, long dy, int prevIndex, long hopDistance, int testNumber, PrintWriter out) {
            Point nextPoint = new Point(current.x + dx, current.y + dy, direction, prevIndex, hopDistance);
            if (nextPoint.x == targetX && nextPoint.y == targetY) {
                out.printf("Case #%d: ", testNumber);
                printPath(jumps, prevIndex, out);
                out.printf("%c\n", direction);
                out.flush();
                return true;
            }
            if (canJump(nextPoint, targetX, targetY, visited)) {
                jumps.add(nextPoint);
                visited.add(nextPoint);
            }
            return false;
        }

        private void printPath(List<Point> jumps, int index, PrintWriter out) {
            if (index == -1) return;
            Point point = jumps.get(index);
            printPath(jumps, point.prevIndex, out);
            out.printf("%c", point.dir);
            out.flush();
        }

        private boolean canJump(Point point, int targetX, int targetY, Set<Point> visited) {
            return !visited.contains(point) &&
                    (Math.abs(point.x) <= Math.abs(targetX * 2) && Math.abs(point.y) <= Math.abs(targetY * 2));
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && hop < point.hop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}