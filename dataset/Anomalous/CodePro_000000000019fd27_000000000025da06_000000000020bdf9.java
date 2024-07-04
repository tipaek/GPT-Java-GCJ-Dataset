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
            if ((newPoint.x > point.x && newPoint.x < point.y) || 
                (newPoint.y > point.x && newPoint.y < point.y) || 
                (newPoint.x == point.x && newPoint.x != newPoint.y) || 
                (newPoint.y == point.y && newPoint.y != newPoint.x)) {
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
            Point[] cameronTasks = new Point[n];
            Point[] jamieTasks = new Point[n];

            for (int l = 0; l < n; l++) {
                tasks[l] = new Point(in.nextInt(), in.nextInt());
            }

            StringBuilder result = new StringBuilder();
            int cameronSize = 0;
            int jamieSize = 0;

            for (Point task : tasks) {
                if (check(cameronTasks, task)) {
                    cameronTasks[cameronSize++] = new Point(task);
                    result.append("C");
                } else if (check(jamieTasks, task)) {
                    jamieTasks[jamieSize++] = new Point(task);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}