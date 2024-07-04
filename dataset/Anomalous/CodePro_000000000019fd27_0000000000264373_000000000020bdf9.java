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
            if (point == null) break;

            if ((newPoint.x < point.x && newPoint.y > point.x) ||
                (newPoint.x > point.x && newPoint.y < point.y) ||
                (newPoint.x > point.x && newPoint.x < point.y && newPoint.y > point.x) ||
                (newPoint.x == point.x && newPoint.y == point.y) ||
                (newPoint.x == point.x && newPoint.x != newPoint.y) ||
                (newPoint.y == point.y && newPoint.y != newPoint.y)) {
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
            Point[] tasks = new Point[n];
            Point[] cTasks = new Point[n];
            Point[] jTasks = new Point[n];

            for (int l = 0; l < n; l++) {
                tasks[l] = new Point(in.nextInt(), in.nextInt());
            }

            String result = "";
            int cSize = 0, jSize = 0;

            for (Point task : tasks) {
                if (check(cTasks, task)) {
                    cTasks[cSize++] = task;
                    result += "C";
                } else if (check(jTasks, task)) {
                    jTasks[jSize++] = task;
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}