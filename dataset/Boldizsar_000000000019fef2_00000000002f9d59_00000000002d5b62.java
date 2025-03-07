import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        PrintWriter out = new PrintWriter(outputStream);
        Solver1 solver = new Solver1();
        int testCount = in.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    private static class Solver1 {

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int x = in.nextInt();
            int y = in.nextInt();
            List<Point> jumps = new ArrayList<>();
          //  Set<Point> jumped = new HashSet<>();
            jumps.add(new Point(0, 0, 'x', -1, 0));
         //   jumped.add(new Point(0, 0, 'x', -1, 0));
            int i = 0;
            while (i < jumps.size()) {
                Point current = jumps.get(i);
                long hop = current.hop == 0 ? 1 : current.hop * 2;

                {
                    Point south = new Point(current.x, current.y - hop, 'S', i, hop);
                    if (south.x == x && south.y == y) {
                        out.printf("Case #%d: ", testNumber);
                        printList(jumps, i, out);
                        out.printf("%s\n", 'S');
                        return;
                    }
                    if (Math.abs(south.x) <= Math.abs(x) && Math.abs(south.y) <= Math.abs(y)){// && !jumped.contains(south)) {
                        jumps.add(south);
                        //jumped.add(south);
                    }
                }

                {
                    Point north = new Point(current.x, current.y + hop, 'N', i, hop);
                    if (north.x == x && north.y == y) {
                        out.printf("Case #%d: ", testNumber);
                        printList(jumps, i, out);
                        out.printf("%s\n", 'N');
                        return;
                    }
                    if (Math.abs(north.x) <= Math.abs(x) && Math.abs(north.y) <= Math.abs(y)){//  && !jumped.contains(north)) {
                        jumps.add(north);
                       // jumped.add(north);
                    }
                }

                {
                    Point east = new Point(current.x + hop, current.y, 'E', i, hop);
                    if (east.x == x && east.y == y) {
                        out.printf("Case #%d: ", testNumber);
                        printList(jumps, i, out);
                        out.printf("%s\n", 'E');
                        return;
                    }
                    if (Math.abs(east.x) <= Math.abs(x) && Math.abs(east.y) <= Math.abs(y)){//  && !jumped.contains(east)) {
                        jumps.add(east);
                      //  jumped.add(east);
                    }
                }

                {
                    Point west = new Point(current.x - hop, current.y, 'W', i, hop);
                    if (west.x == x && west.y == y) {
                        out.printf("Case #%d: ", testNumber);
                        printList(jumps, i, out);
                        out.printf("%s\n", 'N');
                        return;
                    }
                    if (Math.abs(west.x) <= Math.abs(x) && Math.abs(west.y) <= Math.abs(y)){//  && !jumped.contains(west)) {
                        jumps.add(west);
                        //jumped.add(west);
                    }
                }

                ++i;
            }
            out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
        }

    }

    private static void printList(List<Point> jumps, int i, PrintWriter out) {
        Point point = jumps.get(i);
        if (point.prevIndex == -1) return;
        printList(jumps, point.prevIndex, out);
        out.printf("%s", point.dir);
    }

    static class Point {
        long x;
        long y;
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
            return x == point.x &&
                    y == point.y &&
                    point.hop < hop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
