import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream output = System.out;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int distance(Point p) {
            return Math.abs(p.x - x) + Math.abs(p.y - y);
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
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            int pathLength = path.length();
            boolean found = false;

            Point position = new Point(x, y);
            Set<Point> reachablePoints = new HashSet<>();
            reachablePoints.add(new Point(0, 0));

            for (int i = 1; i <= pathLength; i++) {
                switch (path.charAt(i - 1)) {
                    case 'N':
                        position = new Point(position.x, position.y + 1);
                        break;
                    case 'S':
                        position = new Point(position.x, position.y - 1);
                        break;
                    case 'E':
                        position = new Point(position.x - 1, position.y);
                        break;
                    case 'W':
                        position = new Point(position.x + 1, position.y);
                        break;
                }
                Set<Point> newReachablePoints = new HashSet<>();
                for (Point p : reachablePoints) {
                    Set<Point> potentialPoints = new HashSet<>();
                    potentialPoints.add(p);
                    potentialPoints.add(new Point(p.x, p.y + 1));
                    potentialPoints.add(new Point(p.x, p.y - 1));
                    potentialPoints.add(new Point(p.x + 1, p.y));
                    potentialPoints.add(new Point(p.x - 1, p.y));

                    for (Point potentialPoint : potentialPoints) {
                        int distance = potentialPoint.distance(position);
                        if (distance == 0) {
                            output.println("Case #" + t + ": " + i);
                            found = true;
                            break;
                        } else if (distance <= 2 * (pathLength - i)) {
                            newReachablePoints.add(potentialPoint);
                        }
                    }
                    if (found) {
                        break;
                    }
                }
                if (found) {
                    break;
                }
                reachablePoints = newReachablePoints;
            }
            if (!found) {
                output.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}