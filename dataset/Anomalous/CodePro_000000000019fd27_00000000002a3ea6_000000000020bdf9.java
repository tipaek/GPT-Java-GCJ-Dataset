import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] points, Point newPoint) {
        if (newPoint.x > newPoint.y) {
            return false;
        }

        for (Point point : points) {
            if (point == null) {
                break;
            }

            if ((newPoint.x < point.x && newPoint.y > point.x) ||
                (newPoint.x >= point.x && newPoint.x < point.y) ||
                (newPoint.x == point.x && newPoint.y == point.y) ||
                (newPoint.x == point.x && newPoint.x != newPoint.y) ||
                (newPoint.y == point.y && newPoint.y != newPoint.x)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Point[] ar = new Point[50];
            Point[] c = new Point[50];
            Point[] j = new Point[50];
            int cSize = 0;
            int jSize = 0;
            String result = "";
            boolean isImpossible = false;

            for (int l = 0; l < n; l++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Point task = new Point(x, y);

                if (check(j, task) && !isImpossible) {
                    j[jSize] = new Point(task);
                    result += "J";
                    jSize++;
                } else if (check(c, task) && !isImpossible) {
                    c[cSize] = new Point(task);
                    result += "C";
                    cSize++;
                } else {
                    result = "IMPOSSIBLE";
                    isImpossible = true;
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}