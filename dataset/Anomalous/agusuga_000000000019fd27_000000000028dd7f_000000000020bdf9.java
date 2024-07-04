import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int numActivities = scanner.nextInt();
            Point[] activities = new Point[numActivities];

            System.out.print("Case #" + (caseIndex + 1) + ": ");

            // Collect all the activity times
            for (int activityIndex = 0; activityIndex < numActivities; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[activityIndex] = new Point(start, end);
            }

            // Scheduling
            List<Point> cameronSchedule = new ArrayList<>();
            List<Point> jamieSchedule = new ArrayList<>();

            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();

            for (Point activity : activities) {
                boolean assignedToCameron = canAssignActivity(cameronSchedule, activity);
                if (assignedToCameron) {
                    schedule.append('C');
                } else if (canAssignActivity(jamieSchedule, activity)) {
                    schedule.append('J');
                } else {
                    System.out.println("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println(schedule.toString());
            }
        }
    }

    static boolean canAssignActivity(List<Point> schedule, Point activity) {
        int activityStart = (int) activity.getX();
        int activityEnd = (int) activity.getY();

        for (Point scheduledActivity : schedule) {
            int scheduledStart = (int) scheduledActivity.getX();
            int scheduledEnd = (int) scheduledActivity.getY();

            if ((activityStart < scheduledEnd && activityStart >= scheduledStart) ||
                (activityEnd > scheduledStart && activityEnd <= scheduledEnd)) {
                return false;
            }
        }

        schedule.add(activity);
        return true;
    }
}