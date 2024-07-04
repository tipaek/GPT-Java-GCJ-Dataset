import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            Point[] activities = new Point[activityCount];

            // Read activities
            for (int j = 0; j < activityCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Point(start, end);
            }

            String result = scheduleActivities(activities);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String scheduleActivities(Point[] activities) {
        ArrayList<Point> cameronSchedule = new ArrayList<>();
        ArrayList<Point> jamieSchedule = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (Point activity : activities) {
            if (canSchedule(cameronSchedule, activity)) {
                schedule.append('C');
            } else if (canSchedule(jamieSchedule, activity)) {
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static boolean canSchedule(ArrayList<Point> schedule, Point activity) {
        for (Point scheduledActivity : schedule) {
            if (overlaps(scheduledActivity, activity)) {
                return false;
            }
        }
        schedule.add(activity);
        return true;
    }

    private static boolean overlaps(Point a, Point b) {
        int startA = (int) a.getX();
        int endA = (int) a.getY();
        int startB = (int) b.getX();
        int endB = (int) b.getY();

        return startA < endB && startB < endA;
    }
}