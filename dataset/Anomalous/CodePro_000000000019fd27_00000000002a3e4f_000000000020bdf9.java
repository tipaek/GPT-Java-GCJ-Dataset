import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Parent {

    public static boolean check(Point[] points, Point interval) {
        for (Point point : points) {
            if (point == null) break;

            if (interval.x > interval.y) {
                return false;
            }

            if ((interval.x < point.x && interval.y > point.x) ||
                (interval.x >= point.x && interval.x < point.y) ||
                (interval.x == point.x && interval.y == point.y) ||
                (interval.x == point.x && interval.x != interval.y) ||
                (interval.y == point.y && interval.y != interval.y)) {
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
            Point[] intervals = new Point[n];
            Point[] cIntervals = new Point[50];
            Point[] jIntervals = new Point[50];
            int cSize = 0, jSize = 0;
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int l = 0; l < n; l++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Point interval = new Point(x, y);
                intervals[l] = interval;

                if (check(jIntervals, interval) && !isImpossible) {
                    jIntervals[jSize++] = new Point(interval);
                    result.append("J");
                } else if (check(cIntervals, interval) && !isImpossible) {
                    cIntervals[cSize++] = new Point(interval);
                    result.append("C");
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    isImpossible = true;
                }
            }

            results[i - 1] = "Case #" + i + ": " + result;
        }

        for (String res : results) {
            System.out.println(res);
        }
    }
}