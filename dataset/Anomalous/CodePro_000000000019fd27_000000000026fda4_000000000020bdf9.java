import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] points, Point newPoint) {
        if (newPoint.x > newPoint.y) {
            return false;
        }

        for (Point point : points) {
            if (point == null) {
                break;
            }
            if ((newPoint.x < point.x && newPoint.y > point.x) ||
                (newPoint.x > point.x && newPoint.x < point.y) ||
                (newPoint.x == point.x && newPoint.y == point.y) ||
                (newPoint.x == point.x) ||
                (newPoint.y == point.y)) {
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
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                intervals[l] = new Point(x, y);
            }

            String result = "";
            int cSize = 0;
            int jSize = 0;

            for (int g = 0; g < n; g++) {
                Point currentInterval = intervals[g];
                if (currentInterval.x == currentInterval.y || currentInterval.y > 24 * 60 || currentInterval.x > currentInterval.y) {
                    result = "IMPOSSIBLE";
                    break;
                }

                if (check(cIntervals, currentInterval)) {
                    cIntervals[cSize++] = currentInterval;
                    result += "C";
                } else if (check(jIntervals, currentInterval)) {
                    jIntervals[jSize++] = currentInterval;
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