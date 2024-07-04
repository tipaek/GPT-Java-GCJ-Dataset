import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static final String SOUTH = "S";
    private static final String NORTH = "N";
    private static final String EAST = "E";
    private static final String WEST = "W";

    private static class Point {
        final long x;
        final long y;

        public Point(long x, long y) {
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

    private static String solve(Set<Point> visited, String path, int iter, long currentX, long currentY, int x, int y) {
        if (currentX == x && currentY == y) {
            return path;
        }

        Point current = new Point(currentX, currentY);

        if (visited.contains(current)) {
            return null;
        }

        visited.add(current);

        double jump = (double) Math.pow(2, iter);

        if (jump > Long.MAX_VALUE || jump < Long.MIN_VALUE) {
            return null;
        }

        String result = null;

        if (Math.abs(x - currentX) >= jump) {
            if (add(currentX, (long) jump)) {
                result = solve(visited, path + EAST, iter + 1, currentX + (long) jump, currentY, x, y);
            }
            if (sub(currentX, (long) jump)) {
                String t = solve(visited, path + WEST, iter + 1, currentX - (long) jump, currentY, x, y);
                if (result == null) {
                    result = t;
                } else if (t != null && t.length() < result.length()) {
                    result = t;
                }
            }
        }

        if (Math.abs(y - currentY) >= jump) {
            String t;
            if (add(currentY, (long) jump)) {
                t = solve(visited, path + NORTH, iter + 1, currentX, currentY + (long) jump, x, y);
                if (t != null) {
                    if (result == null) {
                        result = t;
                    } else if (t.length() < result.length()) {
                        result = t;
                    }
                }
            }

            if (sub(currentY,(long)  jump)) {
                t = solve(visited, path + SOUTH, iter + 1, currentX, currentY - (long) jump, x, y);
                if (t != null) {
                    if (result == null) {
                        result = t;
                    } else if (t.length() < result.length()) {
                        result = t;
                    }
                }
            }
        }

        visited.remove(current);

        return result;
    }

    public static boolean add(final long s, final long d) {
        long r = s + d;
        if (((s & d & ~r) | (~s & ~d & r)) < 0)
            return false;
        return true;
    }

    public static boolean sub(final long d, final long s) {
        long r = d - s;
        if ((((~s & d & ~r) | (s & ~d & r)) & 0x8000000000000000L) != 0)
            return false;
        return true;
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

//        for (int i = -4; i <= 4; i++) {
//            for (int j = -4; j <= 4; j++) {
//                String result = solve(new HashSet<>(), "", 0, 0, 0, i, j);
//                System.out.printf("Case #%d: %s\n", (i + 1), result == null ? IMPOSSIBLE : result);
//            }
//        }
//    }
}
