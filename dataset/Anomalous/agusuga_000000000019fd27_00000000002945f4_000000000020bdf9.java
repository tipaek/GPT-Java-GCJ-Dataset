import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++)
        {
            int numActivities = scanner.nextInt();
            Point[] activities = new Point[numActivities];
            
            System.out.print("Case #" + (caseIndex + 1) + ": ");
            
            // Collect all the times
            for (int activityIndex = 0; activityIndex < numActivities; activityIndex++)
            {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[activityIndex] = new Point(start, end);
            }
            
            // Scheduling
            List<Point> cameronSchedule = new ArrayList<>();
            List<Point> jamieSchedule = new ArrayList<>();
            
            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();
            
            for (Point activity : activities)
            {
                boolean assignedToCameron = canAssign(cameronSchedule, activity);
                if (assignedToCameron)
                {
                    schedule.append('C');
                }
                else
                {
                    boolean assignedToJamie = canAssign(jamieSchedule, activity);
                    if (assignedToJamie)
                    {
                        schedule.append('J');
                    }
                    else
                    {
                        System.out.println("IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                }
            }
            
            if (isPossible)
            {
                System.out.println(schedule.toString());
            }
        }
    }
    
    static boolean canAssign(List<Point> schedule, Point activity)
    {
        int proposedStart = activity.x;
        int proposedEnd = activity.y;
        
        for (Point scheduledActivity : schedule)
        {
            int scheduledStart = scheduledActivity.x;
            int scheduledEnd = scheduledActivity.y;
            
            if (proposedStart < scheduledEnd && proposedEnd > scheduledStart)
            {
                return false;
            }
        }
        
        schedule.add(activity);
        return true;
    }
}