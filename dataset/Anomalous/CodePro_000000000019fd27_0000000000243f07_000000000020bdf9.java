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

            if (newPoint.x == newPoint.y) {
                if (newPoint.x == point.x || newPoint.y == point.y) {
                    return false;
                }
            }

            if (newPoint.x < point.y && newPoint.y > point.x) {
                return false;
            }

            if (newPoint.x < point.x && newPoint.y > point.x) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            Point[] intervals = new Point[n];
            Point[] cAssignments = new Point[n];
            Point[] jAssignments = new Point[n];

            for (int j = 0; j < n; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                intervals[j] = new Point(x, y);
            }

            StringBuilder result = new StringBuilder();
            int cSize = 0;
            int jSize = 0;

            for (Point interval : intervals) {
                if (isValid(cAssignments, interval)) {
                    cAssignments[cSize++] = new Point(interval);
                    result.append("C");
                } else if (isValid(jAssignments, interval)) {
                    jAssignments[jSize++] = new Point(interval);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            results[i - 1] = "Case #" + i + ": " + result;
        }

        for (String res : results) {
            System.out.println(res);
        }
    }
}