import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean isNonOverlapping(Point[] intervals, Point newInterval) {
        for (Point interval : intervals) {
            if (interval == null) break;

            if (newInterval.x < interval.x && newInterval.y > interval.x) return false;
            if (newInterval.x >= interval.x && newInterval.x < interval.y) return false;
            if (newInterval.x == interval.x && newInterval.y == interval.y) return false;
            if (newInterval.x == interval.x && newInterval.x != newInterval.y) return false;
            if (newInterval.y == interval.y && newInterval.y != newInterval.y) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Point[] intervals = new Point[n];
            Point[] cIntervals = new Point[n];
            Point[] jIntervals = new Point[n];

            for (int l = 0; l < n; l++) {
                intervals[l] = new Point(in.nextInt(), in.nextInt());
            }

            StringBuilder result = new StringBuilder();
            int cSize = 0, jSize = 0;

            for (Point interval : intervals) {
                if (isNonOverlapping(cIntervals, interval)) {
                    cIntervals[cSize++] = interval;
                    result.append("C");
                } else if (isNonOverlapping(jIntervals, interval)) {
                    jIntervals[jSize++] = interval;
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