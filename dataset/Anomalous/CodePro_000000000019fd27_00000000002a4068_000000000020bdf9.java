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
        int t = scanner.nextInt();
        String[] results = new String[t];

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            Point[] points = new Point[50];
            Point[] cPoints = new Point[50];
            Point[] jPoints = new Point[50];
            int cSize = 0;
            int jSize = 0;
            String result = "";
            boolean isPossible = true;

            for (int l = 0; l < n; l++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Point newPoint = new Point(x, y);

                if (check(jPoints, newPoint) && isPossible) {
                    jPoints[jSize] = new Point(newPoint);
                    result += "J";
                    jSize++;
                } else if (check(cPoints, newPoint) && isPossible) {
                    cPoints[cSize] = new Point(newPoint);
                    result += "C";
                    cSize++;
                } else {
                    result = "IMPOSSIBLE";
                    isPossible = false;
                }
            }
            results[i - 1] = "Case #" + i + ": " + result;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}