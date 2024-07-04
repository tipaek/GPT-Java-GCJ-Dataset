import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean isNonOverlapping(Point[] points, Point newPoint) {
        if (newPoint.x > newPoint.y) {
            return false;
        }
        for (Point point : points) {
            if (point == null) break;
            if ((newPoint.x < point.y && newPoint.y > point.x) || 
                (newPoint.x < point.x && newPoint.y > point.x)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();  // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();  // Number of intervals

            Point[] intervals = new Point[n];
            for (int l = 0; l < n; l++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                intervals[l] = new Point(x, y);
            }

            Point[] cSchedule = new Point[n];
            Point[] jSchedule = new Point[n];
            StringBuilder result = new StringBuilder();

            int cSize = 0;
            int jSize = 0;
            boolean possible = true;

            for (Point interval : intervals) {
                if (isNonOverlapping(cSchedule, interval)) {
                    cSchedule[cSize++] = interval;
                    result.append("C");
                } else if (isNonOverlapping(jSchedule, interval)) {
                    jSchedule[jSize++] = interval;
                    result.append("J");
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
        scanner.close();
    }
}