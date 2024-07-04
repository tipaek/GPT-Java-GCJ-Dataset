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
            if ((point.y >= x.y && point.x < x.y) || (x.x >= point.x && x.x < point.y)) {
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
            int csize = 0;
            int jsize = 0;
            StringBuilder r = new StringBuilder();
            boolean isPossible = true;

            for (int l = 0; l < n; l++) {
                int x = in.nextInt();
                int y = in.nextInt();
                Point tr = new Point(x, y);

                if (check(j, tr)) {
                    j[jsize] = new Point(tr);
                    r.append("J");
                    jsize++;
                } else if (check(c, tr)) {
                    c[csize] = new Point(tr);
                    r.append("C");
                    csize++;
                } else {
                    r = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + r.toString());
        }
    }
}