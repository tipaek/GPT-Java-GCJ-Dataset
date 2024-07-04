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
            if (x.x < point.x && x.y > point.x) {
                return false;
            } else if (x.x >= point.x && x.x < point.y) {
                return false;
            } else if (x.x == point.x && x.y == point.y) {
                return false;
            } else if (x.x == point.x && x.x != x.y) {
                return false;
            } else if (x.y == point.y && x.y != x.y) {
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

            StringBuilder result = new StringBuilder();
            int cSize = 0;
            int jSize = 0;

            for (int g = 0; g < n; g++) {
                if (check(j, ar[g])) {
                    j[jSize] = new Point(ar[g]);
                    result.append("J");
                    jSize++;
                } else if (check(c, ar[g])) {
                    c[cSize] = new Point(ar[g]);
                    result.append("C");
                    cSize++;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}