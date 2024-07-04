import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] intervals, Point newInterval) {
        if (newInterval.x > newInterval.y) {
            return false;
        }
        for (Point interval : intervals) {
            if (interval == null) {
                break;
            }
            if ((newInterval.x < interval.x && newInterval.y > interval.x) ||
                (newInterval.x >= interval.x && newInterval.x < interval.y) ||
                (newInterval.y > interval.x && newInterval.y <= interval.y) ||
                (newInterval.x == interval.x && newInterval.x != newInterval.y) ||
                (newInterval.y == interval.y && newInterval.y != newInterval.y)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            Point[] activities = new Point[n];
            Point[] cIntervals = new Point[n];
            Point[] jIntervals = new Point[n];

            for (int j = 0; j < n; j++) {
                activities[j] = new Point(scanner.nextInt(), scanner.nextInt());
            }

            StringBuilder result = new StringBuilder();
            int cSize = 0;
            int jSize = 0;

            for (Point activity : activities) {
                if (check(cIntervals, activity)) {
                    cIntervals[cSize++] = activity;
                    result.append("C");
                } else if (check(jIntervals, activity)) {
                    jIntervals[jSize++] = activity;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}