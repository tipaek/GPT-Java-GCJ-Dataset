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

            if ((point.y >= newPoint.y && point.x < newPoint.y) || 
                (newPoint.x >= point.x && newPoint.x < point.y) || 
                (newPoint.x > point.x && (newPoint.y > point.x || newPoint.y > point.y)) || 
                (newPoint.x < point.x && newPoint.y > point.x) || 
                (newPoint.x >= point.x && newPoint.x < point.y) || 
                (newPoint.x == point.x && newPoint.y == point.y) || 
                (newPoint.x == point.x && newPoint.x != newPoint.y) || 
                (newPoint.y == point.y && newPoint.y != newPoint.y)) {
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
            Point[] ar = new Point[n];
            Point[] c = new Point[n];
            Point[] j = new Point[n];
            int cSize = 0;
            int jSize = 0;
            String result = "";
            boolean isImpossible = false;

            for (int l = 0; l < n; l++) {
                int x = in.nextInt();
                int y = in.nextInt();
                Point currentPoint = new Point(x, y);

                if (currentPoint.x > 24 * 60 || currentPoint.y > 24 * 60) {
                    isImpossible = true;
                }

                if (!isImpossible && check(j, currentPoint)) {
                    j[jSize++] = currentPoint;
                    result += "J";
                } else if (!isImpossible && check(c, currentPoint)) {
                    c[cSize++] = currentPoint;
                    result += "C";
                } else {
                    result = "IMPOSSIBLE";
                    isImpossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}