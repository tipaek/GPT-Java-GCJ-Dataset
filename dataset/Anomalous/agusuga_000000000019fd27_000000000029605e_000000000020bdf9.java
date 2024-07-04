import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int i = 0; i < numberOfCases; i++) {
            int numberOfActivities = scanner.nextInt();
            Point[] activities = new Point[numberOfActivities];
            
            System.out.print("Case #" + (i + 1) + ": ");
            
            for (int j = 0; j < numberOfActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Point(start, end);
            }
            
            ArrayList<Point> cameronSchedule = new ArrayList<>();
            ArrayList<Point> jamieSchedule = new ArrayList<>();
            
            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();
            
            for (int j = 0; j < numberOfActivities; j++) {
                boolean cameronAssigned = canAssignActivity(cameronSchedule, activities[j]);
                boolean jamieAssigned = false;
                
                if (cameronAssigned) {
                    schedule.append('C');
                } else {
                    jamieAssigned = canAssignActivity(jamieSchedule, activities[j]);
                    if (jamieAssigned) {
                        schedule.append('J');
                    }
                }
                
                if (!cameronAssigned && !jamieAssigned) {
                    System.out.println("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                System.out.println(schedule.toString());
            }
        }
    }
    
    static boolean canAssignActivity(ArrayList<Point> schedule, Point activity) {
        int activityStart = (int) activity.getX();
        int activityEnd = (int) activity.getY();
        
        for (Point existingActivity : schedule) {
            int existingStart = (int) existingActivity.getX();
            int existingEnd = (int) existingActivity.getY();
            
            if (activityStart < existingEnd && activityEnd > existingStart) {
                return false;
            }
        }
        
        schedule.add(activity);
        return true;
    }
}