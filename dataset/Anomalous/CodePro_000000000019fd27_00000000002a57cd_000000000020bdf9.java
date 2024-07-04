import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] points, Point interval) {
        if (interval.x > interval.y) {
            return false;
        }
        
        for (Point p : points) {
            if (p == null) break;

            if ((p.y >= interval.y && p.x < interval.y) ||
                (interval.x >= p.x && interval.x < p.y) ||
                (interval.x < p.x && interval.y > p.x) ||
                (interval.x == p.x && interval.y == p.y) ||
                (interval.x == p.x && interval.x != interval.y) ||
                (interval.y == p.y && interval.y != interval.y)) {
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
            String result = "";
            boolean flag = false;

            for (int l = 0; l < n; l++) {
                int x = in.nextInt();
                int y = in.nextInt();
                Point interval = new Point(x, y);

                if (interval.x > 24 * 60 || interval.y > 24 * 60) {
                    flag = true;
                }

                if (!flag && check(j, interval)) {
                    j[jSize++] = interval;
                    result += "J";
                } else if (!flag && check(c, interval)) {
                    c[cSize++] = interval;
                    result += "C";
                } else {
                    result = "IMPOSSIBLE";
                    flag = true;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}