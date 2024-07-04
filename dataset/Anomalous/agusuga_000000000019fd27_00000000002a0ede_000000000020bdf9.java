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
                // Start Point
                Point startPoint = new Point(0, start);
                // End Point
                Point endPoint = new Point(1, end);
                activities.add(startPoint);
                activities.add(endPoint);
            }

            // Sort times
            activities.sort(Comparator.comparingInt(Point::y));

            StringBuilder schedule = new StringBuilder();

            // Placeholder for scheduling logic
            while (!activities.isEmpty()) {
                // Your scheduling logic should go here
                // Currently, it does nothing
                activities.remove(0); // This line is just to prevent infinite loop
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
        }
    }

    static boolean timeCheck(List<Point> parent, Point proposed) {
        int propStart = proposed.x;
        int propStop = proposed.y;

        for (Point point : parent) {
            int setStart = point.x;
            int setStop = point.y;

            if (propStart == setStart || 
                (propStart < setStart && propStop > setStart) || 
                (propStart > setStart && propStart < setStop)) {
                return false;
            }
        }

        parent.add(proposed);
        return true;
    }
}