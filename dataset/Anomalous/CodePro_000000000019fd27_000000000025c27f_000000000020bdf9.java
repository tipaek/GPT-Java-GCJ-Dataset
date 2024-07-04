import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] points, Point x) {
        if (x.x > x.y) {
            return false;
        }
        for (Point point : points) {
            if (point == null) {
                break;
            }
            if ((x.x < point.y && x.x > point.y) || (x.y > point.x && x.y > point.y) ||
                (x.x < point.x && x.x < point.y && x.y > point.x && x.y < point.y)) {
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
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                intervals[l] = new Point(x, y);
            }

            String result = "";
            int cSize = 0;
            int jSize = 0;

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
        scanner.close();
    }
}