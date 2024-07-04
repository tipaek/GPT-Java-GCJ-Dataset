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
            if ((point.y - newPoint.y >= 0 && point.x - newPoint.y < 0) || 
                (newPoint.x - point.x >= 0 && newPoint.x - point.y < 0)) {
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
            Point[] cIntervals = new Point[n];
            Point[] jIntervals = new Point[n];
            int cSize = 0, jSize = 0;
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int l = 0; l < n; l++) {
                int x = in.nextInt();
                int y = in.nextInt();
                Point interval = new Point(x, y);

                if (x > 24 * 60 || y > 24 * 60) {
                    isImpossible = true;
                }

                if (!isImpossible && check(jIntervals, interval)) {
                    jIntervals[jSize++] = interval;
                    result.append("J");
                } else if (!isImpossible && check(cIntervals, interval)) {
                    cIntervals[cSize++] = interval;
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
        in.close();
    }
}