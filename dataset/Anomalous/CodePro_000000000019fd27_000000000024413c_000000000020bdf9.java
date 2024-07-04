import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    
    public static boolean isValid(Point[] schedule, Point interval) {
        if (interval.x >= interval.y || interval.x >= 24 * 60 || interval.y > 24 * 60) {
            return false;
        }
        
        for (Point p : schedule) {
            if (p == null) break;
            if (interval.x < p.y && interval.y > p.x) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            Point[] intervals = new Point[n];
            Point[] cSchedule = new Point[n];
            Point[] jSchedule = new Point[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i] = new Point(scanner.nextInt(), scanner.nextInt());
            }
            
            StringBuilder result = new StringBuilder();
            int cCount = 0, jCount = 0;
            
            for (Point interval : intervals) {
                if (isValid(cSchedule, interval)) {
                    cSchedule[cCount++] = new Point(interval);
                    result.append("C");
                } else if (isValid(jSchedule, interval)) {
                    jSchedule[jCount++] = new Point(interval);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + t + ": " + result);
        }
        
        scanner.close();
    }
}