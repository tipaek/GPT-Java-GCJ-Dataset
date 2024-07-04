import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] points, Point point) {
        if (point.x > point.y) {
            return false;
        }

        for (Point p : points) {
            if (p == null) {
                break;
            }

            if ((p.y >= point.y && p.x < point.y) || 
                (point.x >= p.x && point.x < p.y) ||
                (point.x < p.x && (point.y > p.x || point.y > p.y)) ||
                (point.x > p.x && (point.y >= p.x || point.y <= p.y)) ||
                (point.x < p.x && point.y > p.x) ||
                (point.x >= p.x && point.x < p.y) ||
                (point.x == p.x && point.y == p.y) ||
                (point.x == p.x && point.x != point.y) ||
                (point.y == p.y && point.y != point.y)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            Point[] tasks = new Point[n];
            Point[] cTasks = new Point[n];
            Point[] jTasks = new Point[n];
            int cSize = 0;
            int jSize = 0;
            String result = "";
            boolean isImpossible = false;

            for (int l = 0; l < n; l++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Point currentTask = new Point(x, y);

                if (x > 24 * 60 || y > 24 * 60) {
                    isImpossible = true;
                }

                if (check(jTasks, currentTask) && !isImpossible) {
                    jTasks[jSize++] = new Point(x, y);
                    result += "J";
                } else if (check(cTasks, currentTask) && !isImpossible) {
                    cTasks[cSize++] = new Point(x, y);
                    result += "C";
                } else {
                    result = "IMPOSSIBLE";
                    isImpossible = true;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}