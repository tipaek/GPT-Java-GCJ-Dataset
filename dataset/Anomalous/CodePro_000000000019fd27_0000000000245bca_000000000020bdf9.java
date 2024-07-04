import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] intervals, Point newInterval) {
        if (newInterval.x >= newInterval.y || newInterval.x > 24 * 60 || newInterval.y > 24 * 60) {
            return false;
        }
        for (Point interval : intervals) {
            if (interval == null) break;
            if (newInterval.x < interval.y && newInterval.y > interval.x) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            Point[] intervals = new Point[n];
            for (int j = 0; j < n; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                intervals[j] = new Point(x, y);
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(Point[] intervals) {
        Point[] cIntervals = new Point[intervals.length];
        Point[] jIntervals = new Point[intervals.length];
        int cSize = 0, jSize = 0;
        StringBuilder schedule = new StringBuilder();

        for (Point interval : intervals) {
            if (check(jIntervals, interval)) {
                jIntervals[jSize++] = interval;
                schedule.append("J");
            } else if (check(cIntervals, interval)) {
                cIntervals[cSize++] = interval;
                schedule.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }
}