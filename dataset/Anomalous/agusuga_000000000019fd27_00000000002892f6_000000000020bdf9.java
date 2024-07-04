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

            System.out.print("Case #" + (i + 1) + ": ");
            // Collect all the times
            for (int j = 0; j < numActivity; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities[j] = new Point(start, end);
            }

            // Scheduling
            List<Point> cameron = new ArrayList<>();
            List<Point> jamie = new ArrayList<>();

            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();

            for (int j = 0; j < numActivity; j++) {
                if (isTimeAvailable(cameron, activities[j])) {
                    cameron.add(activities[j]);
                    schedule.append('C');
                } else if (isTimeAvailable(jamie, activities[j])) {
                    jamie.add(activities[j]);
                    schedule.append('J');
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println(schedule.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static boolean isTimeAvailable(List<Point> schedule, Point proposed) {
        int propStart = (int) proposed.getX();
        int propEnd = (int) proposed.getY();

        for (Point time : schedule) {
            int start = (int) time.getX();
            int end = (int) time.getY();

            if ((propStart >= start && propStart < end) || (propEnd > start && propEnd <= end)) {
                return false;
            }
        }
        return true;
    }
}