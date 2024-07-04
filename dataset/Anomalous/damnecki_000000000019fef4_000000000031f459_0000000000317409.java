import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

    private static final Scanner SCANNER = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUTPUT = System.out;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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
            int initialX = SCANNER.nextInt();
            int initialY = SCANNER.nextInt();
            String path = SCANNER.next();
            int pathLength = path.length();
            boolean isFound = false;

            Point currentPosition = new Point(initialX, initialY);
            Map<String, Point> visitedPositions = new HashMap<>();
            visitedPositions.put("", new Point(0, 0));

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
                        currentPosition = new Point(currentPosition.x + 1, currentPosition.y);
                        break;
                    case 'W':
                        currentPosition = new Point(currentPosition.x - 1, currentPosition.y);
                        break;
                }

                Map<String, Point> newVisitedPositions = new HashMap<>();
                for (Map.Entry<String, Point> entry : visitedPositions.entrySet()) {
                    Point point = entry.getValue();
                    newVisitedPositions.put(entry.getKey(), point);
                    newVisitedPositions.put(entry.getKey() + "N", new Point(point.x, point.y + 1));
                    newVisitedPositions.put(entry.getKey() + "S", new Point(point.x, point.y - 1));
                    newVisitedPositions.put(entry.getKey() + "E", new Point(point.x + 1, point.y));
                    newVisitedPositions.put(entry.getKey() + "W", new Point(point.x - 1, point.y));
                }
                visitedPositions = newVisitedPositions;

                for (Map.Entry<String, Point> entry : visitedPositions.entrySet()) {
                    if (currentPosition.equals(entry.getValue())) {
                        OUTPUT.println("Case #" + t + ": " + i);
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    break;
                }
            }
            if (!isFound) {
                OUTPUT.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}