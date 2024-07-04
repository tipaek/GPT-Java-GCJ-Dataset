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
            if (point == null) break;
            if ((x.x < point.x && x.y >= point.x) ||
                (x.x >= point.x && x.y <= point.x) ||
                (x.x >= point.x && x.y >= point.x) ||
                (x.x == point.x && x.y == point.y)) {
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
            int cSize = 0;
            int jSize = 0;
            
            for (int g = 0; g < n; g++) {
                if (check(c, ar[g])) {
                    c[cSize++] = new Point(ar[g]);
                    r.append("C");
                } else if (check(j, ar[g])) {
                    j[jSize++] = new Point(ar[g]);
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