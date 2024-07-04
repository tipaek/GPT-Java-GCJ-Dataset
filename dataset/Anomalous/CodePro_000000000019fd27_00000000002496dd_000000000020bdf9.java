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
            if ((x.x < point.y && x.y > point.x) || (x.x < point.x && x.y > point.x)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; ++i) {
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
            int csize = 0;
            int jsize = 0;
            boolean isPossible = true;

            for (int g = 0; g < n; g++) {
                if (check(c, ar[g])) {
                    c[csize++] = ar[g];
                    result.append("C");
                } else if (check(j, ar[g])) {
                    j[jsize++] = ar[g];
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            results[i] = "Case #" + (i + 1) + ": " + result.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}