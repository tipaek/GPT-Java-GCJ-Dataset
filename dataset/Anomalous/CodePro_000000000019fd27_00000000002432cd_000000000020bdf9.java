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
            if (point == null) {
                break;
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
        String[] results = new String[t];

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            Point[] activities = new Point[n];
            Point[] cActivities = new Point[n];
            Point[] jActivities = new Point[n];

            for (int l = 0; l < n; l++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                activities[l] = new Point(x, y);
            }

            String schedule = "";
            int cSize = 0;
            int jSize = 0;

            for (int g = 0; g < n; g++) {
                if (check(cActivities, activities[g])) {
                    cActivities[cSize++] = activities[g];
                    schedule += "C";
                } else if (check(jActivities, activities[g])) {
                    jActivities[jSize++] = activities[g];
                    schedule += "J";
                } else {
                    schedule = "IMPOSSIBLE";
                    break;
                }
            }

            results[i - 1] = "Case #" + i + ": " + schedule;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}