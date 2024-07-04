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

            if (newPoint.x < point.x && newPoint.y > point.x) {
                System.out.println("fuc");
                return false;
            } else if (newPoint.x >= point.x && newPoint.x < point.y) {
                return false;
            } else if (newPoint.x == point.x && newPoint.y == point.y) {
                return false;
            } else if (newPoint.x == point.x && newPoint.x != newPoint.y) {
                return false;
            } else if (newPoint.y == point.y && newPoint.y != newPoint.y) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            Point[] points = new Point[50];
            Point[] cPoints = new Point[50];
            Point[] jPoints = new Point[50];
            int cSize = 0;
            int jSize = 0;
            String result = "";

            for (int l = 0; l < n; l++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Point newPoint = new Point(x, y);

                if (check(jPoints, newPoint)) {
                    jPoints[jSize] = new Point(x, y);
                    result += "J";
                    jSize++;
                } else if (check(cPoints, newPoint)) {
                    cPoints[cSize] = new Point(x, y);
                    result += "C";
                    cSize++;
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}