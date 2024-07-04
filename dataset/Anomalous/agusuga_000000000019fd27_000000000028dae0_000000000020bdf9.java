import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            Point[] activities = new Point[numActivities];

            System.out.print("Case #" + (t + 1) + ": ");

            // Collect all the times
            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Point(start, end);
            }

            // Scheduling
            ArrayList<Point> cameronSchedule = new ArrayList<>();
            ArrayList<Point> jamieSchedule = new ArrayList<>();

            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();

            for (Point activity : activities) {
                boolean assignedToCameron = canAssign(cameronSchedule, activity);
                boolean assignedToJamie = false;

                if (!assignedToCameron) {
                    assignedToJamie = canAssign(jamieSchedule, activity);
                }

                if (!assignedToCameron && !assignedToJamie) {
                    System.out.println("IMPOSSIBLE");
                    isPossible = false;
                    break;
                } else if (assignedToCameron) {
                    schedule.append('C');
                } else {
                    schedule.append('J');
                }
            }

            if (isPossible) {
                System.out.println(schedule.toString());
            }
        }
    }

    private static boolean canAssign(ArrayList<Point> schedule, Point activity) {
        int start = (int) activity.getX();
        int end = (int) activity.getY();

        for (Point scheduledActivity : schedule) {
            int scheduledStart = (int) scheduledActivity.getX();
            int scheduledEnd = (int) scheduledActivity.getY();

            if ((start >= scheduledStart && start < scheduledEnd) || (end > scheduledStart && end <= scheduledEnd)) {
                return false;
            }
        }

        schedule.add(activity);
        return true;
    }
}