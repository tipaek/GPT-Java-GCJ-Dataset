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
                boolean assigned = assignActivity(cameron, activities[j]);
                if (assigned) {
                    schedule.append('C');
                } else if (assignActivity(jamie, activities[j])) {
                    schedule.append('J');
                } else {
                    System.out.println("IMPOSSIBLE");
                    success = false;
                    break;
                }
            }
            
            if (success) {
                System.out.println(schedule.toString());
            }
        }
    }
    
    static boolean assignActivity(List<Point> schedule, Point activity) {
        int start = (int) activity.getX();
        int end = (int) activity.getY();
        
        for (Point p : schedule) {
            int scheduledStart = (int) p.getX();
            int scheduledEnd = (int) p.getY();
            
            if (start < scheduledEnd && end > scheduledStart) {
                return false;
            }
        }
        
        schedule.add(activity);
        return true;
    }
}