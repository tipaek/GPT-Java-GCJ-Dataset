import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }
            
            Collections.sort(activities);
            StringBuilder result = new StringBuilder();
            List<ScheduledActivity> scheduledActivities = new ArrayList<>();
            int cEnd = 0;
            int jEnd = 0;
            boolean possible = true;
            
            for (Activity activity : activities) {
                if (activity.start >= cEnd) {
                    scheduledActivities.add(new ScheduledActivity(activity.id, "C"));
                    cEnd = activity.end;
                } else if (activity.start >= jEnd) {
                    scheduledActivities.add(new ScheduledActivity(activity.id, "J"));
                    jEnd = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            Collections.sort(scheduledActivities);
            
            if (!possible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                for (ScheduledActivity scheduledActivity : scheduledActivities) {
                    result.append(scheduledActivity.person);
                }
                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            }
        }
        
        scanner.close();
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int id;

    Activity(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    @Override
    public int compareTo(Activity other) {
        if (this.start == other.start) {
            return this.end - other.end;
        }
        return this.start - other.start;
    }
}

class ScheduledActivity implements Comparable<ScheduledActivity> {
    int id;
    String person;

    ScheduledActivity(int id, String person) {
        this.id = id;
        this.person = person;
    }

    @Override
    public int compareTo(ScheduledActivity other) {
        return this.id - other.id;
    }
}