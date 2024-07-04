import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static boolean check(Point[] points, Point current) {
        if (current.x > current.y) {
            return false;
        }

        for (Point point : points) {
            if (point == null) {
                break;
            }

            if ((current.x < point.x && current.y > point.x) ||
                (current.x >= point.x && current.x < point.y) ||
                (current.x == point.x && current.y == point.y) ||
                (current.x == point.x && current.x != current.y) ||
                (current.y == point.y && current.y != current.y)) {
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

            for (int j = 0; j < n; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                intervals[j] = new Point(x, y);
            }

            StringBuilder result = new StringBuilder();
            int cSize = 0;
            int jSize = 0;

            for (Point interval : intervals) {
                if (check(jIntervals, interval)) {
                    jIntervals[jSize] = new Point(interval);
                    result.append("J");
                    jSize++;
                } else if (check(cIntervals, interval)) {
                    cIntervals[cSize] = new Point(interval);
                    result.append("C");
                    cSize++;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            results[i - 1] = "Case #" + i + ": " + result;
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }
}