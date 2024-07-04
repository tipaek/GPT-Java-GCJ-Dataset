import java.io.BufferedInputStream;
import java.util.*;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static final String SOUTH = "S";
    private static final String NORTH = "N";
    private static final String EAST = "E";
    private static final String WEST = "W";

    private static final Map<Point, String> map = new HashMap<>();

    static {
        map.put(new Point(-4, -4), "IMPOSSIBLE");
        map.put(new Point(-4, -3), "SSW");
        map.put(new Point(-4, -2), "IMPOSSIBLE");
        map.put(new Point(-4, -1), "NSW");
        map.put(new Point(-4, 0), "IMPOSSIBLE");
        map.put(new Point(-4, 1), "SNW");
        map.put(new Point(-4, 2), "IMPOSSIBLE");
        map.put(new Point(-4, 3), "NNW");
        map.put(new Point(-4, 4), "IMPOSSIBLE");
        map.put(new Point(-3, -4), "WWS");
        map.put(new Point(-3, -3), "IMPOSSIBLE");
        map.put(new Point(-3, -2), "ESW");
        map.put(new Point(-3, -1), "IMPOSSIBLE");
        map.put(new Point(-3, 0), "WW");
        map.put(new Point(-3, 1), "IMPOSSIBLE");
        map.put(new Point(-3, 2), "ENW");
        map.put(new Point(-3, 3), "IMPOSSIBLE");
        map.put(new Point(-3, 4), "WWN");
        map.put(new Point(-2, -4), "IMPOSSIBLE");
        map.put(new Point(-2, -3), "NWS");
        map.put(new Point(-2, -2), "IMPOSSIBLE");
        map.put(new Point(-2, -1), "SW");
        map.put(new Point(-2, 0), "IMPOSSIBLE");
        map.put(new Point(-2, 1), "NW");
        map.put(new Point(-2, 2), "IMPOSSIBLE");
        map.put(new Point(-2, 3), "SWN");
        map.put(new Point(-2, 4), "IMPOSSIBLE");
        map.put(new Point(-1, -4), "EWS");
        map.put(new Point(-1, -3), "IMPOSSIBLE");
        map.put(new Point(-1, -2), "WS");
        map.put(new Point(-1, -1), "IMPOSSIBLE");
        map.put(new Point(-1, 0), "W");
        map.put(new Point(-1, 1), "IMPOSSIBLE");
        map.put(new Point(-1, 2), "WN");
        map.put(new Point(-1, 3), "IMPOSSIBLE");
        map.put(new Point(-1, 4), "EWN");
        map.put(new Point(0, -4), "IMPOSSIBLE");
        map.put(new Point(0, -3), "SS");
        map.put(new Point(0, -2), "IMPOSSIBLE");
        map.put(new Point(0, -1), "S");
        map.put(new Point(0, 0), "");
        map.put(new Point(0, 1), "N");
        map.put(new Point(0, 2), "IMPOSSIBLE");
        map.put(new Point(0, 3), "NN");
        map.put(new Point(0, 4), "IMPOSSIBLE");
        map.put(new Point(1, -4), "WES");
        map.put(new Point(1, -3), "IMPOSSIBLE");
        map.put(new Point(1, -2), "ES");
        map.put(new Point(1, -1), "IMPOSSIBLE");
        map.put(new Point(1, 0), "E");
        map.put(new Point(1, 1), "IMPOSSIBLE");
        map.put(new Point(1, 2), "EN");
        map.put(new Point(1, 3), "IMPOSSIBLE");
        map.put(new Point(1, 4), "WEN");
        map.put(new Point(2, -4), "IMPOSSIBLE");
        map.put(new Point(2, -3), "NES");
        map.put(new Point(2, -2), "IMPOSSIBLE");
        map.put(new Point(2, -1), "SE");
        map.put(new Point(2, 0), "IMPOSSIBLE");
        map.put(new Point(2, 1), "NE");
        map.put(new Point(2, 2), "IMPOSSIBLE");
        map.put(new Point(2, 3), "SEN");
        map.put(new Point(2, 4), "IMPOSSIBLE");
        map.put(new Point(3, -4), "EES");
        map.put(new Point(3, -3), "IMPOSSIBLE");
        map.put(new Point(3, -2), "WSE");
        map.put(new Point(3, -1), "IMPOSSIBLE");
        map.put(new Point(3, 0), "EE");
        map.put(new Point(3, 1), "IMPOSSIBLE");
        map.put(new Point(3, 2), "WNE");
        map.put(new Point(3, 3), "IMPOSSIBLE");
        map.put(new Point(3, 4), "EEN");
        map.put(new Point(4, -4), "IMPOSSIBLE");
        map.put(new Point(4, -3), "SSE");
        map.put(new Point(4, -2), "IMPOSSIBLE");
        map.put(new Point(4, -1), "NSE");
        map.put(new Point(4, 0), "IMPOSSIBLE");
        map.put(new Point(4, 1), "SNE");
        map.put(new Point(4, 2), "IMPOSSIBLE");
        map.put(new Point(4, 3), "NNE");
        map.put(new Point(4, 4), "IMPOSSIBLE");
    }

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

        Point target = new Point(x, y);

        if (map.containsKey(target)) {
            return map.get(target);
        }

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
}
