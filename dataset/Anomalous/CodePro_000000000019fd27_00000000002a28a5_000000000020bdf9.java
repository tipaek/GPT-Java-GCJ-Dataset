import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    
    public static boolean isValid(Point[] points, Point newPoint) {
        for (Point point : points) {
            if (point == null) break;

            if ((newPoint.x < point.x && newPoint.y > point.x) ||
                (newPoint.x >= point.x && newPoint.x < point.y) ||
                (newPoint.x == point.x && newPoint.y == point.y) ||
                (newPoint.x == point.x && newPoint.x != newPoint.y) ||
                (newPoint.y == point.y && newPoint.y != newPoint.y)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            Point[] intervals = new Point[n];
            
            for (int j = 0; j < n; j++) {
                intervals[j] = new Point(scanner.nextInt(), scanner.nextInt());
            }
            
            StringBuilder schedule = new StringBuilder();
            Point[] cIntervals = new Point[n];
            Point[] jIntervals = new Point[n];
            int cCount = 0, jCount = 0;
            boolean possible = true;

            for (Point interval : intervals) {
                if (isValid(jIntervals, interval)) {
                    jIntervals[jCount++] = interval;
                    schedule.append("J");
                } else if (isValid(cIntervals, interval)) {
                    cIntervals[cCount++] = interval;
                    schedule.append("C");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            results[i - 1] = "Case #" + i + ": " + schedule.toString();
        }
        
        for (String result : results) {
            System.out.println(result);
        }
    }
}