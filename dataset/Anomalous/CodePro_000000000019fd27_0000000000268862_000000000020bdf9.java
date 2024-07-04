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
                Point current = intervals[g];

                if (current.x == current.y || current.y > 24 * 60 || current.x > current.y) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                if (check(c, current)) {
                    c[cSize++] = current;
                    result.append("C");
                } else if (check(j, current)) {
                    j[jSize++] = current;
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