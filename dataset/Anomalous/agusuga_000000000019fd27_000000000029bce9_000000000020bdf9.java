import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int numActivities = scanner.nextInt();
            Point[] activities = new Point[numActivities];

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Point(start, end);
            }

            List<Point> cameron = new ArrayList<>();
            List<Point> jamie = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (Point activity : activities) {
                if (canAssign(cameron, activity)) {
                    schedule.append('C');
                } else if (canAssign(jamie, activity)) {
                    schedule.append('J');
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + schedule);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean canAssign(List<Point> schedule, Point activity) {
        int start = activity.x;
        int end = activity.y;

        for (Point scheduled : schedule) {
            if ((start >= scheduled.x && start < scheduled.y) || (end > scheduled.x && end <= scheduled.y) || (start <= scheduled.x && end >= scheduled.y)) {
                return false;
            }
        }

        schedule.add(activity);
        return true;
    }
}