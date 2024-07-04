import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] schedule, Point interval) {
        if (interval.x >= interval.y || interval.x >= 24 * 60 || interval.y > 24 * 60) {
            return false;
        }
        
        for (Point p : schedule) {
            if (p == null) {
                break;
            }
            if (interval.x < p.y && interval.y > p.x) {
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
            Point[] intervals = new Point[n];
            Point[] cSchedule = new Point[n];
            Point[] jSchedule = new Point[n];

            for (int l = 0; l < n; l++) {
                intervals[l] = new Point(in.nextInt(), in.nextInt());
            }

            StringBuilder result = new StringBuilder();
            int cSize = 0;
            int jSize = 0;
            
            for (Point interval : intervals) {
                if (check(jSchedule, interval)) {
                    jSchedule[jSize++] = interval;
                    result.append("J");
                } else if (check(cSchedule, interval)) {
                    cSchedule[cSize++] = interval;
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}