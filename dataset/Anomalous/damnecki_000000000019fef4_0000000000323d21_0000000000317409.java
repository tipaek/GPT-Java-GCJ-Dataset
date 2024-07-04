import java.io.BufferedInputStream;
import java.io.PrintStream;
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

        int distanceTo(Point other) {
            return Math.abs(other.x - x) + Math.abs(other.y - y);
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
            return "Point{" + "x=" + x + ", y=" + y + '}';
        }
    }

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int startX = SCANNER.nextInt();
            int startY = SCANNER.nextInt();
            String path = SCANNER.next();
            int pathLength = path.length();
            boolean isReachable = false;

            Point currentPosition = new Point(startX, startY);
            Point origin = new Point(0, 0);

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
                if (currentPosition.distanceTo(origin) <= i) {
                    OUTPUT.println("Case #" + t + ": " + i);
                    isReachable = true;
                    break;
                }
            }
            if (!isReachable) {
                OUTPUT.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}