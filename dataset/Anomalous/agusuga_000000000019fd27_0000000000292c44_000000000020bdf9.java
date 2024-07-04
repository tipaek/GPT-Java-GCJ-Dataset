import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int numActivities = scanner.nextInt();
            Point[] activities = new Point[numActivities];

            System.out.print("Case #" + (caseIndex + 1) + ": ");

            for (int activityIndex = 0; activityIndex < numActivities; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[activityIndex] = new Point(start, end);
            }

            List<Point> cameronSchedule = new ArrayList<>();
            List<Point> jamieSchedule = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;

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
                System.out.println(schedule);
            }
        }
    }

    static boolean canAssignActivity(List<Point> schedule, Point activity) {
        int activityStart = (int) activity.getX();
        int activityEnd = (int) activity.getY();

        for (Point scheduledActivity : schedule) {
            int scheduledStart = (int) scheduledActivity.getX();
            int scheduledEnd = (int) scheduledActivity.getY();

            if (!(activityEnd <= scheduledStart || activityStart >= scheduledEnd)) {
                return false;
            }
        }

        schedule.add(activity);
        return true;
    }
}