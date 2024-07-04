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
            if ((x.x < point.x && x.y > point.x) ||
                (x.x >= point.x && x.x < point.y) ||
                (x.x == point.x && x.y == point.y) ||
                (x.x == point.x && x.x != x.y) ||
                (x.y == point.y && x.y != x.y)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Read number of test cases
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Point[] ar = new Point[50];
            Point[] c = new Point[50];
            Point[] j = new Point[50];
            int csize = 0;
            int jsize = 0;
            StringBuilder result = new StringBuilder();

            for (int l = 0; l < n; l++) {
                int x = in.nextInt();
                int y = in.nextInt();
                Point tr = new Point(x, y);

                if (check(j, tr)) {
                    j[jsize] = new Point(tr);
                    result.append("J");
                    jsize++;
                } else if (check(c, tr)) {
                    c[csize] = new Point(tr);
                    result.append("C");
                    csize++;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}