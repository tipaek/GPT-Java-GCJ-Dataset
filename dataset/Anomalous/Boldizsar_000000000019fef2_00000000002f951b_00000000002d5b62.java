import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {
            Solver solver = new Solver();
            int testCount = in.nextInt();
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, in, out);
            }
        }
    }

    private static class Solver {

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int x = in.nextInt();
            int y = in.nextInt();
            List<Point> jumps = new ArrayList<>();
            Set<Point> visited = new HashSet<>();
            jumps.add(new Point(0, 0, ' ', -1, 0));
            visited.add(new Point(0, 0, ' ', -1, 0));
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

                for (Point next : directions) {
                    if (next.x == x && next.y == y) {
                        out.printf("Case #%d: ", testNumber);
                        printPath(jumps, index, out);
                        out.printf("%s\n", next.dir);
                        return;
                    }
                    if (Math.abs(next.x) <= Math.abs(x) && Math.abs(next.y) <= Math.abs(y) && visited.add(next)) {
                        jumps.add(next);
                    }
                }
                index++;
            }
            out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
        }

        private void printPath(List<Point> jumps, int index, PrintWriter out) {
            if (index == -1) return;
            Point point = jumps.get(index);
            printPath(jumps, point.prevIndex, out);
            if (point.dir != ' ') {
                out.print(point.dir);
            }
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
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}