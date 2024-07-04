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
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            Point[] intervals = new Point[n];
            Point[] cIntervals = new Point[n];
            Point[] jIntervals = new Point[n];

            for (int l = 0; l < n; l++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[l] = new Point(start, end);
            }

            String result = "";
            int cSize = 0;
            int jSize = 0;
            for (int g = 0; g < n; g++) {
                if (isNonOverlapping(cIntervals, intervals[g])) {
                    cIntervals[cSize] = new Point(intervals[g].x, intervals[g].y);
                    result += "C";
                    cSize++;
                } else if (isNonOverlapping(jIntervals, intervals[g])) {
                    jIntervals[jSize] = new Point(intervals[g].x, intervals[g].y);
                    result += "J";
                    jSize++;
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }
}