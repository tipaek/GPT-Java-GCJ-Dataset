import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] points, Point interval) {
        if (interval.x >= interval.y || interval.x > 24 * 60 || interval.y > 24 * 60) {
            return false;
        }

        for (Point point : points) {
            if (point == null) break;

            if (interval.x == point.x || interval.y == point.y) {
                return false;
            }
            if (interval.x < point.y && interval.y > point.x) {
                return false;
            }
            if (interval.x < point.x && interval.y > point.x) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Point[] intervals = new Point[n];
            Point[] cameron = new Point[n];
            Point[] jamie = new Point[n];

            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals[j] = new Point(start, end);
            }

            StringBuilder result = new StringBuilder();
            int cameronSize = 0;
            int jamieSize = 0;

            for (Point interval : intervals) {
                if (check(jamie, interval)) {
                    cameron[cameronSize++] = new Point(interval);
                    result.append("J");
                } else if (check(cameron, interval)) {
                    jamie[jamieSize++] = new Point(interval);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}