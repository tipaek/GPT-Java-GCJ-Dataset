import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] p, Point x) {
        if (x.x > x.y) {
            return false;
        }
        for (Point point : p) {
            if (point == null) {
                break;
            }
            if ((x.x < point.y && x.x > point.x && x.y > point.x && x.y > point.y) ||
                (x.x < point.x && x.x < point.y && x.y > point.x && x.y < point.y)) {
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

            for (int l = 0; l < n; l++) {
                int x = in.nextInt();
                int y = in.nextInt();
                ar[l] = new Point(x, y);
            }

            StringBuilder r = new StringBuilder();
            int csize = 0;
            int jsize = 0;

            for (Point point : ar) {
                if (check(c, point)) {
                    c[csize++] = new Point(point);
                    r.append("C");
                } else if (check(j, point)) {
                    j[jsize++] = new Point(point);
                    r.append("J");
                } else {
                    r = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + r);
        }
    }
}