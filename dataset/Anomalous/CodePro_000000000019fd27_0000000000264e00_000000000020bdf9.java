import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean isValid(Point[] points, Point newPoint) {
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
                (newPoint.x == point.x && newPoint.x != newPoint.y) ||
                (newPoint.y == point.y && newPoint.x != newPoint.y)) {
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
            Point[] cameron = new Point[n];
            Point[] jamie = new Point[n];

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Point(start, end);
            }

            StringBuilder result = new StringBuilder();
            int cameronSize = 0;
            int jamieSize = 0;

            for (Point activity : activities) {
                if (isValid(cameron, activity)) {
                    cameron[cameronSize++] = activity;
                    result.append("C");
                } else if (isValid(jamie, activity)) {
                    jamie[jamieSize++] = activity;
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