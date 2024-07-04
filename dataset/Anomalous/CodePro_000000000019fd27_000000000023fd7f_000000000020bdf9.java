import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] points, Point newPoint) {
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
        int t = scanner.nextInt();  // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();  // Number of intervals
            Point[] intervals = new Point[n];
            Point[] c = new Point[n];
            Point[] j = new Point[n];

            for (int l = 0; l < n; l++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                intervals[l] = new Point(x, y);
            }

            StringBuilder result = new StringBuilder();
            int cSize = 0;
            int jSize = 0;

            for (int g = 0; g < n; g++) {
                if (check(c, intervals[g])) {
                    c[cSize++] = new Point(intervals[g]);
                    result.append("C");
                } else if (check(j, intervals[g])) {
                    j[jSize++] = new Point(intervals[g]);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}