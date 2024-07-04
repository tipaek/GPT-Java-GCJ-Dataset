import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner IN = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUT = System.out;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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
        int testCases = IN.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int startX = IN.nextInt();
            int startY = IN.nextInt();
            String path = IN.next();
            int pathLength = path.length();
            boolean isFound = false;

            Point currentPosition = new Point(startX, startY);
            Set<Point> visitedPositions = new HashSet<>();
            visitedPositions.add(new Point(0, 0));

            for (int i = 1; i <= pathLength; i++) {
                char direction = path.charAt(i - 1);
                switch (direction) {
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

                Set<Point> newVisitedPositions = new HashSet<>();
                for (Point p : visitedPositions) {
                    newVisitedPositions.add(p);
                    newVisitedPositions.add(new Point(p.x, p.y + 1));
                    newVisitedPositions.add(new Point(p.x, p.y - 1));
                    newVisitedPositions.add(new Point(p.x + 1, p.y));
                    newVisitedPositions.add(new Point(p.x - 1, p.y));
                }

                if (newVisitedPositions.contains(currentPosition)) {
                    OUT.println("Case #" + t + ": " + i);
                    isFound = true;
                    break;
                }

                visitedPositions = newVisitedPositions;
            }

            if (!isFound) {
                OUT.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}