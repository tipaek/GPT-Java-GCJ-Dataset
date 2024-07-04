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
                (newPoint.x > point.x && newPoint.y < point.y) ||
                (newPoint.x > point.x && newPoint.x < point.y && newPoint.y > point.x) ||
                (newPoint.x == point.x && newPoint.y == point.y) ||
                (newPoint.x == point.x && newPoint.x != newPoint.y) ||
                (newPoint.y == point.y && newPoint.y != newPoint.x)) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Point[] intervals = new Point[n];
            Point[] cAssigned = new Point[n];
            Point[] jAssigned = new Point[n];

            for (int l = 0; l < n; l++) {
                int x = in.nextInt();
                int y = in.nextInt();
                intervals[l] = new Point(x, y);
            }

            StringBuilder result = new StringBuilder();
            int cSize = 0;
            int jSize = 0;

            for (Point interval : intervals) {
                if (check(cAssigned, interval)) {
                    cAssigned[cSize++] = interval;
                    result.append("C");
                } else if (check(jAssigned, interval)) {
                    jAssigned[jSize++] = interval;
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