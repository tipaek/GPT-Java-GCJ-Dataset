import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] points, Point newPoint) {
        if (newPoint.x >= newPoint.y) {
            return false;
        }
        for (Point point : points) {
            if (point == null) break;
            if (newPoint.x == newPoint.y && (newPoint.x == point.x || newPoint.y == point.y)) {
                return false;
            }
            if ((newPoint.x < point.y && newPoint.y > point.x) || (newPoint.x < point.x && newPoint.y > point.x)) {
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
            Point[] cIntervals = new Point[n];
            Point[] jIntervals = new Point[n];

            for (int l = 0; l < n; l++) {
                intervals[l] = new Point(scanner.nextInt(), scanner.nextInt());
            }

            String result = "";
            int cSize = 0, jSize = 0;

            for (int g = 0; g < n; g++) {
                if (check(cIntervals, intervals[g])) {
                    cIntervals[cSize++] = new Point(intervals[g]);
                    result += "C";
                } else if (check(jIntervals, intervals[g])) {
                    jIntervals[jSize++] = new Point(intervals[g]);
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}