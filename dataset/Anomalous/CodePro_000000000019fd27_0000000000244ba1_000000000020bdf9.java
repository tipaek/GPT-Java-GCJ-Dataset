import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean check(Point[] intervals, Point newInterval) {
        if (newInterval.x >= newInterval.y || newInterval.x > 24 * 60 || newInterval.y > 24 * 60) {
            return false;
        }
        for (Point interval : intervals) {
            if (interval == null) break;
            if (newInterval.x < interval.y && newInterval.y > interval.x) {
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
            for (int j = 0; j < n; j++) {
                tasks[j] = new Point(in.nextInt(), in.nextInt());
            }

            StringBuilder result = new StringBuilder();
            Point[] cTasks = new Point[n];
            Point[] jTasks = new Point[n];
            int cCount = 0, jCount = 0;

            for (Point task : tasks) {
                if (check(cTasks, task)) {
                    cTasks[cCount++] = task;
                    result.append("C");
                } else if (check(jTasks, task)) {
                    jTasks[jCount++] = task;
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