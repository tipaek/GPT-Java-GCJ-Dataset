import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] points, Point newPoint) {
        if (newPoint.x > newPoint.y) {
            return false;
        }
        for (Point p : points) {
            if (p == null) {
                break;
            }
            if ((p.y >= newPoint.y && p.x < newPoint.y) || 
                (newPoint.x >= p.x && newPoint.x < p.y) ||
                (newPoint.x < p.x && (newPoint.y > p.x || newPoint.y > p.y)) ||
                (newPoint.x > p.x && newPoint.y > p.x && newPoint.y <= p.y) ||
                (newPoint.x < p.x && newPoint.y > p.x) ||
                (newPoint.x == p.x && newPoint.y == p.y) ||
                (newPoint.x == p.x && newPoint.x != newPoint.y) ||
                (newPoint.y == p.y && newPoint.y != newPoint.y)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();  // Number of intervals
            Point[] intervals = new Point[n];
            Point[] c = new Point[n];
            Point[] j = new Point[n];
            int cSize = 0;
            int jSize = 0;
            StringBuilder result = new StringBuilder();
            boolean flag = false;

            for (int l = 0; l < n; l++) {
                int x = in.nextInt();
                int y = in.nextInt();
                Point currentInterval = new Point(x, y);

                if (currentInterval.x > 24 * 60 || currentInterval.y > 24 * 60) {
                    flag = true;
                }

                if (check(j, currentInterval) && !flag) {
                    j[jSize] = new Point(currentInterval);
                    result.append("J");
                    jSize++;
                } else if (check(c, currentInterval) && !flag) {
                    c[cSize] = new Point(currentInterval);
                    result.append("C");
                    cSize++;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    flag = true;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}