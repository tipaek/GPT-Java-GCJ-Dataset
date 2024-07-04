import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] intervals, Point current) {
        if (current.x > current.y) {
            return false;
        }
        for (Point interval : intervals) {
            if (interval == null) {
                break;
            }
            if ((current.x <= interval.x && current.y > interval.x) ||
                (current.x >= interval.x && current.x < interval.y) ||
                (current.y > interval.x && current.y <= interval.y) ||
                (current.x == interval.x && current.x != current.y) ||
                (current.y == interval.y && current.y != current.y)) {
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
            for (Point interval : intervals) {
                if (check(cIntervals, interval)) {
                    cIntervals[cSize++] = interval;
                    result += "C";
                } else if (check(jIntervals, interval)) {
                    jIntervals[jSize++] = interval;
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}