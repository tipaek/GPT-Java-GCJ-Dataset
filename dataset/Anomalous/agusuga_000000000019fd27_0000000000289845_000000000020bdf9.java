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
            boolean success = true;
            StringBuilder schedule = new StringBuilder();

            for (int j = 0; j < numActivity; j++) {
                boolean assigned = timeCheck(cameron, activities[j]);
                boolean possible = assigned || timeCheck(jamie, activities[j]);

                if (!possible) {
                    System.out.println("IMPOSSIBLE");
                    success = false;
                    break;
                } else {
                    schedule.append(assigned ? 'C' : 'J');
                }
            }

            if (success) {
                System.out.println(schedule);
            }
        }
    }

    static boolean timeCheck(List<Point> parent, Point proposed) {
        int propStart = proposed.x;
        int propStop = proposed.y;

        for (Point activity : parent) {
            int setStart = activity.x;
            int setStop = activity.y;

            if ((propStart < setStop && propStart >= setStart) || (propStop > setStart && propStop <= setStop)) {
                return false;
            }
        }

        parent.add(proposed);
        return true;
    }
}