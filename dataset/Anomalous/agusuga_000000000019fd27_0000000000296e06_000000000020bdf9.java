import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numActivities = scanner.nextInt();
            Point[] activities = new Point[numActivities];

            System.out.print("Case #" + (caseIndex + 1) + ": ");

            // Collect all the times
            for (int activityIndex = 0; activityIndex < numActivities; activityIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities[activityIndex] = new Point(startTime, endTime);
            }

            // Scheduling
            List<Point> cameronSchedule = new ArrayList<>();
            List<Point> jamieSchedule = new ArrayList<>();
            StringBuilder scheduleBuilder = new StringBuilder();

            boolean isSuccessful = true;

            for (Point activity : activities) {
                boolean isAssigned = checkAndAssignTime(cameronSchedule, activity);
                if (!isAssigned) {
                    isAssigned = checkAndAssignTime(jamieSchedule, activity);
                    if (isAssigned) {
                        scheduleBuilder.append('J');
                    }
                } else {
                    scheduleBuilder.append('C');
                }

                if (!isAssigned) {
                    System.out.println("IMPOSSIBLE");
                    isSuccessful = false;
                    break;
                }
            }

            if (isSuccessful) {
                System.out.println(scheduleBuilder.toString());
            }
        }
    }

    private static boolean checkAndAssignTime(List<Point> schedule, Point newActivity) {
        int newStart = newActivity.x;
        int newEnd = newActivity.y;

        for (Point existingActivity : schedule) {
            int existingStart = existingActivity.x;
            int existingEnd = existingActivity.y;

            if (newStart < existingEnd && newEnd > existingStart) {
                return false;
            }
        }

        schedule.add(newActivity);
        return true;
    }
}