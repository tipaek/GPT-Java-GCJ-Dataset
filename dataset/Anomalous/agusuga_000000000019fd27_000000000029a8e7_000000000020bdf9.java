import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int numActivity = in.nextInt();
            Point[] activities = new Point[numActivity];

            for (int j = 0; j < numActivity; j++) {
                activities[j] = new Point(in.nextInt(), in.nextInt());
            }

            List<Point> cameron = new ArrayList<>();
            List<Point> jamie = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            boolean success = true;

            for (Point activity : activities) {
                if (assignActivity(cameron, activity)) {
                    schedule.append('C');
                } else if (assignActivity(jamie, activity)) {
                    schedule.append('J');
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    success = false;
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
        }
    }

    static boolean assignActivity(List<Point> schedule, Point activity) {
        int start = (int) activity.getX();
        int end = (int) activity.getY();

        for (Point existing : schedule) {
            int existingStart = (int) existing.getX();
            int existingEnd = (int) existing.getY();

            if (start < existingEnd && end > existingStart) {
                return false;
            }
        }
        schedule.add(activity);
        return true;
    }
}