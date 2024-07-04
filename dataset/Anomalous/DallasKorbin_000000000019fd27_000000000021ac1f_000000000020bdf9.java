import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = scanner.nextInt();
        
        for (int i = 0; i < numTests; i++) {
            Schedule cameronSchedule = new Schedule();
            Schedule jamieSchedule = new Schedule();
            StringBuilder result = new StringBuilder();
            int numActivities = scanner.nextInt();
            
            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity activity = new Activity(start, end);
                
                if (cameronSchedule.canAdd(activity)) {
                    cameronSchedule.add(activity);
                    result.append("C");
                } else if (jamieSchedule.canAdd(activity)) {
                    jamieSchedule.add(activity);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        scanner.close();
    }
}

class Schedule {
    private List<Activity> activities = new ArrayList<>();
    
    public void add(Activity activity) {
        activities.add(activity);
    }
    
    public boolean canAdd(Activity newActivity) {
        for (Activity activity : activities) {
            if (activity.overlaps(newActivity)) {
                return false;
            }
        }
        return true;
    }
}

class Activity {
    private int start;
    private int end;
    
    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public boolean overlaps(Activity other) {
        return this.start < other.end && this.end > other.start;
    }
}