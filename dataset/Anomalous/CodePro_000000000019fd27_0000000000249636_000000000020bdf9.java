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
            if (point == null) break;
            if ((newPoint.x < point.y && newPoint.y > point.x) || (newPoint.x < point.x && newPoint.y > point.x)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Point[] intervals = new Point[n];
            Point[] cameron = new Point[n];
            Point[] jamie = new Point[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Point(start, end);
            }

            String result = "";
            int cameronSize = 0;
            int jamieSize = 0;

            for (int i = 0; i < n; i++) {
                if (check(cameron, intervals[i])) {
                    cameron[cameronSize++] = new Point(intervals[i]);
                    result += "C";
                } else if (check(jamie, intervals[i])) {
                    jamie[jamieSize++] = new Point(intervals[i]);
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}