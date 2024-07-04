import java.util.*;

public class Solution {

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
    }

    static class Pair {
        Point p;
        int time;

        public Pair(Point p, int time) {
            this.p = p;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String route = scanner.next();

            String result = solve(x, y, route);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String solve(int x, int y, String route) {
        List<Pair> routeList = buildRoute(x, y, route);
        int minTime = Integer.MAX_VALUE;

        for (Pair pair : routeList) {
            Point point = pair.p;
            int time = pair.time;
            int distance = Math.abs(point.x) + Math.abs(point.y);

            if (distance <= time) {
                minTime = Math.min(minTime, time);
            }
        }

        return minTime == Integer.MAX_VALUE ? "IMPOSSIBLE" : String.valueOf(minTime);
    }

    private static List<Pair> buildRoute(int startX, int startY, String route) {
        List<Pair> routeList = new ArrayList<>();
        int x = startX, y = startY, time = 0;

        routeList.add(new Pair(new Point(x, y), time));

        for (char direction : route.toCharArray()) {
            time++;
            switch (direction) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            routeList.add(new Pair(new Point(x, y), time));
        }

        return routeList;
    }

    private static int findPeaks(int[] heights) {
        int peakCount = 0;

        for (int i = 1; i < heights.length - 1; i++) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                peakCount++;
            }
        }

        return peakCount;
    }
}