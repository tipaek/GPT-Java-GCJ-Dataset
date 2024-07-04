import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] intervals, Point current) {
        if (current.x > current.y) {
            return false;
        }
        for (Point interval : intervals) {
            if (interval == null) {
                break;
            }
            if (current.x < interval.x && current.y > interval.x) {
                return false;
            }
            if (current.x > interval.x && current.x < interval.y) {
                return false;
            }
            if (current.y > interval.x && current.y <= interval.y) {
                return false;
            }
            if (current.x == interval.x && current.x != current.y) {
                return false;
            }
            if (current.y == interval.y && current.y != current.x) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            Point[] activities = new Point[n];
            Point[] cIntervals = new Point[n];
            Point[] jIntervals = new Point[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Point(start, end);
            }

            String result = "";
            int cSize = 0;
            int jSize = 0;

            for (Point activity : activities) {
                if (check(cIntervals, activity)) {
                    cIntervals[cSize++] = new Point(activity);
                    result += "C";
                } else if (check(jIntervals, activity)) {
                    jIntervals[jSize++] = new Point(activity);
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}