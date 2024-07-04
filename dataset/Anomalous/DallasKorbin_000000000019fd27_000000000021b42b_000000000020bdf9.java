import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = scanner.nextInt();
            ActivityScheduler cameronScheduler = new ActivityScheduler();
            ActivityScheduler jamieScheduler = new ActivityScheduler();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < activitiesCount; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity activity = new Activity(startTime, endTime);

                if (result.toString().equals("IMPOSSIBLE")) {
                    continue;
                } else if (cameronScheduler.canSchedule(activity)) {
                    cameronScheduler.add(activity);
                    result.append("C");
                } else if (jamieScheduler.canSchedule(activity)) {
                    jamieScheduler.add(activity);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        scanner.close();
    }
}

class ActivityScheduler {
    private List<Activity> activities;

    public ActivityScheduler() {
        this.activities = new ArrayList<>();
    }

    public void add(Activity activity) {
        activities.add(activity);
    }

    public boolean canSchedule(Activity newActivity) {
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
        return other.start < this.end && other.end > this.start;
    }
}