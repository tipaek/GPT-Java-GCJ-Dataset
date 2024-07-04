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
            if ((point.x <= p.x && point.y > p.x) || 
                (point.x > p.x && point.y <= p.x) || 
                (point.x >= p.x && point.y > p.x) || 
                (point.x == p.x && point.y == p.y)) {
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
            Point[] activities = new Point[n];
            Point[] cSchedule = new Point[n];
            Point[] jSchedule = new Point[n];

            for (int l = 0; l < n; l++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                activities[l] = new Point(x, y);
            }

            StringBuilder result = new StringBuilder();
            int cSize = 0;
            int jSize = 0;

            for (Point activity : activities) {
                if (check(cSchedule, activity)) {
                    cSchedule[cSize++] = activity;
                    result.append("C");
                } else if (check(jSchedule, activity)) {
                    jSchedule[jSize++] = activity;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
        scanner.close();
    }
}