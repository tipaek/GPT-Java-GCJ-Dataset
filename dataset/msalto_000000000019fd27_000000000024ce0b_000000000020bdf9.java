
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());
        for (int tc = 1; tc <= tests; ++tc) {
            int intervals = Integer.parseInt(scanner.nextLine());
            Point[] points = new Point[intervals * 2];
            for (int id = 0, idx = 0; id < intervals; ++id, idx += 2) {
                addPoint(points, scanner.nextLine(), idx, id);
            }
            String schedule = createSchedule(intervals, points);
            System.out.println("Case #" + tc + ": " + schedule);
        }
    }

    private static String createSchedule(int intervals, Point[] points) {
        char[] res = new char[intervals];
        Arrays.sort(points);
        int cameron = -1;
        int jamie = -1;
        for (Point point : points) {
            if (point.isStart) {
                if (cameron == -1) {
                    cameron = point.id;
                    res[point.id] = 'C';
                } else if (jamie == -1) {
                    jamie = point.id;
                    res[point.id] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            } else if (cameron == point.id) {
                cameron = -1;
            } else {
                jamie = -1;
            }
        }
        return new String(res);
    }

    private static void addPoint(Point[] points, String line, int idx, int id) {
        String[] data = line.split(" ");
        points[idx] = new Point(id, Integer.parseInt(data[0]), true);
        points[idx + 1] = new Point(id, Integer.parseInt(data[1]), false);
    }

    private static class Point implements Comparable<Point> {
        final int id;
        final int value;
        final boolean isStart;

        Point(int id, int value, boolean isStart) {
            this.id = id;
            this.value = value;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Point o) {
            int compare = Integer.compare(value, o.value);
            if (compare == 0) {
                if (isStart == o.isStart) {
                    return 0;
                }
                return isStart ? 1 : -1;
            }
            return compare;
        }
    }
}
