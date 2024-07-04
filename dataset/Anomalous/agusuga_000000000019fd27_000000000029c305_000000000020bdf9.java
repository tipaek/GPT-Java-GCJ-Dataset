import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int numActivities = scanner.nextInt();
            Point[] activities = new Point[numActivities];

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Point(start, end);
            }

            String result = scheduleActivities(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String scheduleActivities(Point[] activities) {
        List<Point> cameronActivities = new ArrayList<>();
        List<Point> jamieActivities = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (Point activity : activities) {
            if (isTimeSlotAvailable(jamieActivities, activity)) {
                cameronActivities.add(activity);
                schedule.append('C');
            } else if (isTimeSlotAvailable(cameronActivities, activity)) {
                jamieActivities.add(activity);
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static boolean isTimeSlotAvailable(List<Point> activities, Point proposed) {
        int proposedStart = (int) proposed.getX();
        int proposedEnd = (int) proposed.getY();

        for (Point activity : activities) {
            int existingStart = (int) activity.getX();
            int existingEnd = (int) activity.getY();

            if (proposedStart < existingEnd && proposedEnd > existingStart) {
                return false;
            }
        }
        return true;
    }
}