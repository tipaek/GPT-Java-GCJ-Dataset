import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int numActivity = in.nextInt();
            List<Point> activities = new ArrayList<>();

            // Collect all the activities
            for (int j = 0; j < numActivity; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Point(0, start)); // Start Point
                activities.add(new Point(1, end));   // End Point
            }

            // Sort times
            activities.sort(Comparator.comparing(Point::getY));

            StringBuilder schedule = new StringBuilder();
            boolean isCameronBusy = false;
            boolean isJamieBusy = false;

            while (!activities.isEmpty()) {
                Point current = activities.remove(0);

                if (current.getX() == 0) { // Start time
                    if (!isCameronBusy) {
                        isCameronBusy = true;
                        schedule.append('C');
                    } else if (!isJamieBusy) {
                        isJamieBusy = true;
                        schedule.append('J');
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                } else { // End time
                    if (isCameronBusy) {
                        isCameronBusy = false;
                    } else if (isJamieBusy) {
                        isJamieBusy = false;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule);
        }
    }

    static boolean timeCheck(List<Point> schedule, Point proposed) {
        int propStart = proposed.x;
        int propStop = proposed.y;

        for (Point activity : schedule) {
            int setStart = activity.x;
            int setStop = activity.y;

            if (propStart == setStart || (propStart < setStart && propStop > setStart) || (propStart > setStart && propStart < setStop)) {
                return false;
            }
        }

        schedule.add(proposed);
        return true;
    }
}