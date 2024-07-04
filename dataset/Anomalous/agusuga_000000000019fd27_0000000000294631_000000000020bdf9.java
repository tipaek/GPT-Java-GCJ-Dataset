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

            // Collect all activity times
            for (int j = 0; j < numActivity; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities[j] = new Point(start, end);
            }

            // Scheduling
            List<Point> cameron = new ArrayList<>();
            List<Point> jamie = new ArrayList<>();

            boolean success = true;
            StringBuilder schedule = new StringBuilder();

            for (int j = 0; j < numActivity; j++) {
                boolean assigned = false;
                boolean possible = true;

                // Check for Cameron
                assigned = timeCheck(cameron, activities[j]);
                if (!assigned) {
                    possible = timeCheck(jamie, activities[j]);
                } else {
                    schedule.append('C');
                }

                // Check for Jamie
                if (!possible) {
                    System.out.println("IMPOSSIBLE");
                    success = false;
                    break;
                } else if (!assigned && possible) {
                    schedule.append('J');
                }
            }

            if (success) {
                System.out.println(schedule.toString());
            }
        }
    }

    static boolean timeCheck(List<Point> parent, Point proposed) {
        int propStart = (int) proposed.getX();
        int propEnd = (int) proposed.getY();

        for (Point activity : parent) {
            int setStart = (int) activity.getX();
            int setEnd = (int) activity.getY();

            if (propStart < setEnd && propEnd > setStart) {
                return false;
            }
        }

        parent.add(proposed);
        return true;
    }
}