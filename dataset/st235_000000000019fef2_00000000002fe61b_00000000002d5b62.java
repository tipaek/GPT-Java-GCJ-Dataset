import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class JumpsSolution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static final String SOUTH = "S";
    private static final String NORTH = "N";
    private static final String EAST = "E";
    private static final String WEST = "W";

    private static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static String solve(Set<Point> visited, String path, int iter, int currentX, int currentY, int x, int y) {
        if (currentX == x && currentY == y) {
            return path;
        }

        Point current = new Point(currentX, currentY);

        if (visited.contains(current)) {
            return null;
        }

        visited.add(current);

        double jump = (double) Math.pow(2, iter);

        if (jump > Integer.MAX_VALUE || jump < Integer.MIN_VALUE) {
            return null;
        }

        String result = null;

        if (Math.abs(x - currentX) >= jump) {
            result = solve(visited, path + EAST, iter + 1, currentX + (int)jump, currentY, x, y);
            String t = solve(visited, path + WEST, iter + 1, currentX - (int)jump, currentY, x, y);
            if (result == null) {
                result = t;
            } else if (t != null && t.length() < result.length()) {
                result = t;
            }
        }

        if (Math.abs(y - currentY) >= jump) {
            String t;
            t = solve(visited, path + NORTH, iter + 1, currentX, currentY + (int)jump, x, y);
            if (t != null) {
                if (result == null) {
                    result = t;
                } else if (t.length() < result.length()) {
                    result = t;
                }
            }
            t = solve(visited, path + SOUTH, iter + 1, currentX, currentY - (int)jump, x, y);
            if (t != null) {
                if (result == null) {
                    result = t;
                } else if (t.length() < result.length()) {
                    result = t;
                }
            }
        }

        visited.remove(current);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String result = solve(new HashSet<>(), "", 0, 0, 0, x, y);
            System.out.printf("Case #%d: %s\n", (i + 1), result == null ? IMPOSSIBLE : result);
        }
    }
}
