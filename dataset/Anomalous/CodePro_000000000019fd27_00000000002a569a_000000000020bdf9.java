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
            if ((point.y >= x.y && point.x < x.y) || 
                (x.x >= point.x && x.x < point.y) || 
                (x.x < point.x && x.y > point.x) || 
                (x.x == point.x && x.y == point.y) || 
                (x.x == point.x && x.x != x.y) || 
                (x.y == point.y && x.x != x.y)) {
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
            Point[] c = new Point[n];
            Point[] j = new Point[n];
            int cSize = 0, jSize = 0;
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int l = 0; l < n; l++) {
                int x = in.nextInt();
                int y = in.nextInt();
                Point currentPoint = new Point(x, y);

                if (x > 24 * 60 || y > 24 * 60) {
                    isImpossible = true;
                }

                if (!isImpossible && check(j, currentPoint)) {
                    j[jSize++] = new Point(currentPoint);
                    result.append("J");
                } else if (!isImpossible && check(c, currentPoint)) {
                    c[cSize++] = new Point(currentPoint);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}