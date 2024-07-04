import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner SCANNER = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUTPUT = System.out;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int distance(Point p) {
            return Math.abs(p.x - this.x) + Math.abs(p.y - this.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int x = SCANNER.nextInt();
            int y = SCANNER.nextInt();
            String path = SCANNER.next();
            int pathLength = path.length();
            boolean found = false;

            Point currentPosition = new Point(x, y);
            Set<Point> reachablePoints = new HashSet<>();
            reachablePoints.add(new Point(0, 0));

            for (int i = 1; i <= pathLength; i++) {
                switch (path.charAt(i - 1)) {
                    case 'N':
                        currentPosition = new Point(currentPosition.x, currentPosition.y + 1);
                        break;
                    case 'S':
                        currentPosition = new Point(currentPosition.x, currentPosition.y - 1);
                        break;
                    case 'E':
                        currentPosition = new Point(currentPosition.x - 1, currentPosition.y);
                        break;
                    case 'W':
                        currentPosition = new Point(currentPosition.x + 1, currentPosition.y);
                        break;
                }
                Set<Point> newReachablePoints = new HashSet<>();
                for (Point p : reachablePoints) {
                    newReachablePoints.add(p);
                    newReachablePoints.add(new Point(p.x, p.y + 1));
                    newReachablePoints.add(new Point(p.x, p.y - 1));
                    newReachablePoints.add(new Point(p.x + 1, p.y));
                    newReachablePoints.add(new Point(p.x - 1, p.y));
                }
                Set<Point> validPoints = new HashSet<>();
                for (Point p : newReachablePoints) {
                    int distance = p.distance(currentPosition);
                    if (distance == 0) {
                        OUTPUT.println("Case #" + t + ": " + i);
                        found = true;
                        break;
                    } else if (distance <= 2 * (pathLength - i)) {
                        validPoints.add(p);
                    }
                }
                if (found) {
                    break;
                }
                reachablePoints = validPoints;
            }
            if (!found) {
                OUTPUT.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}