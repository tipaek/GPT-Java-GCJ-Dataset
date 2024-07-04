import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int numActivities = in.nextInt();
            Point[] activities = new Point[numActivities];

            // Collect all the times
            for (int j = 0; j < numActivities; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities[j] = new Point(start, end);
            }

            // Scheduling
            List<Point> cameron = new ArrayList<>();
            List<Point> jamie = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            boolean possible = true;

            for (Point activity : activities) {
                if (isTimeAvailable(cameron, activity)) {
                    cameron.add(activity);
                    schedule.append('C');
                } else if (isTimeAvailable(jamie, activity)) {
                    jamie.add(activity);
                    schedule.append('J');
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule);
        }
    }

    private static boolean isTimeAvailable(List<Point> schedule, Point newActivity) {
        int newStart = (int) newActivity.getX();
        int newEnd = (int) newActivity.getY();

        for (Point activity : schedule) {
            int start = (int) activity.getX();
            int end = (int) activity.getY();

            if ((newStart < end && newEnd > start)) {
                return false;
            }
        }
        return true;
    }
}