import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String[] s = in.nextLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            String p = s[2];
            System.out.println("Case #" + i + ": " + intercept(x, y, p));
        }
    }

    private static String intercept(int x, int y, String p) {
        Map<Point, List<Integer>> hisPath = drawPath(x, y, p);

        Queue<Point> my = new ArrayDeque<>();
        my.add(new Point(0, 0));
        Set<Point> visited = new HashSet<>();
        Set<Point> notVisited = new HashSet<>(hisPath.keySet());
        visited.add(new Point(0, 0));

        Integer minTime = null;

        while (notVisited.size() > 0) {
            Point cur = my.remove();

            List<Integer> hisTimes = hisPath.getOrDefault(cur, null);
            if (hisTimes != null) {
                Integer match = findSmallesMatchingTime(cur.getT(), hisTimes);
                if (match != null) {
                    if (minTime == null || match < minTime) {
                        minTime = match;
                    }
                }
            }

            notVisited.remove(cur);

            List<Point> candidates = cur.allMoves();
            for (Point c : candidates) {
                if (!visited.contains(c)) {
                    visited.add(c);
                    my.add(c);
                }
            }
        }

        return minTime == null ? "IMPOSSIBLE" : minTime.toString();
    }

    private static Integer findSmallesMatchingTime(int myTime, List<Integer> hisTimes) {
        for (Integer t : hisTimes) {
            if (myTime <= t) {
                return t;
            }
        }

        return null;
    }

    private static Map<Point, List<Integer>> drawPath(int x, int y, String p) {
        Map<Point, List<Integer>> path = new HashMap<>(p.length());
        Point last = new Point(x, y);
        path.compute(last, (point, l) -> {
            l = new ArrayList<>();
            l.add(0);
            return l;
        });

        for (char c : p.toCharArray()) {
            last = last.move(c);
            path.compute(last, (point, l) -> {
                if (l == null) {
                    l = new ArrayList<>();
                }

                l.add(point.getT());
                return l;
            });
        }

        return path;
    }

    public static class Point {
        private final int x;
        private final int y;
        private final int t;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.t = 0;
        }

        private Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getT() {
            return t;
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

        public Point move(char dir) {
            switch (dir) {
                case 'N':
                    return new Point(x, y + 1, t + 1);
                case 'S':
                    return new Point(x, y - 1, t + 1);
                case 'E':
                    return new Point(x + 1, y, t + 1);
                case 'W':
                    return new Point(x - 1, y, t + 1);
                default:
                    throw new IllegalArgumentException("Unexpected dir " + dir);
            }
        }

        public List<Point> allMoves() {
            ArrayList<Point> p = new ArrayList<>();
            p.add(move('N'));
            p.add(move('S'));
            p.add(move('E'));
            p.add(move('W'));
            return p;
        }
    }
}