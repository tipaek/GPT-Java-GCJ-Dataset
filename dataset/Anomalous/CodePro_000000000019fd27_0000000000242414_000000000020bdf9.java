import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean isNonOverlapping(Point[] intervals, Point newInterval) {
        if (newInterval.x > newInterval.y) {
            return false;
        }
        for (Point interval : intervals) {
            if (interval == null) {
                break;
            }
            if (newInterval.x < interval.y && newInterval.y > interval.x) {
                return false;
            }
            if (newInterval.x < interval.x && newInterval.y > interval.x) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            Point[] activities = new Point[n];
            Point[] cSchedule = new Point[n];
            Point[] jSchedule = new Point[n];

            for (int j = 0; j < n; j++) {
                activities[j] = new Point(scanner.nextInt(), scanner.nextInt());
            }

            StringBuilder schedule = new StringBuilder();
            int cCount = 0, jCount = 0;

            for (Point activity : activities) {
                if (isNonOverlapping(cSchedule, activity)) {
                    cSchedule[cCount++] = activity;
                    schedule.append("C");
                } else if (isNonOverlapping(jSchedule, activity)) {
                    jSchedule[jCount++] = activity;
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            results[i] = "Case #" + (i + 1) + ": " + schedule.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}