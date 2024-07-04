import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            ActivitySchedule cameronSchedule = new ActivitySchedule();
            ActivitySchedule jamieSchedule = new ActivitySchedule();
            String result = "";
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, j));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            boolean impossible = false;
            for (Activity activity : activities) {
                if (impossible) {
                    continue;
                }
                if (cameronSchedule.canSchedule(activity)) {
                    cameronSchedule.add(activity);
                    activity.assignedTo = "C";
                } else if (jamieSchedule.canSchedule(activity)) {
                    jamieSchedule.add(activity);
                    activity.assignedTo = "J";
                } else {
                    impossible = true;
                }
            }

            if (impossible) {
                result = "IMPOSSIBLE";
            } else {
                activities.sort(Comparator.comparingInt(a -> a.originalIndex));
                StringBuilder resultBuilder = new StringBuilder();
                for (Activity activity : activities) {
                    resultBuilder.append(activity.assignedTo);
                }
                result = resultBuilder.toString();
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        scanner.close();
    }
}

class ActivitySchedule {
    private List<Activity> activities = new ArrayList<>();

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
    int start;
    int end;
    int originalIndex;
    String assignedTo;

    public Activity(int start, int end, int originalIndex) {
        this.start = start;
        this.end = end;
        this.originalIndex = originalIndex;
        this.assignedTo = "";
    }

    public boolean overlaps(Activity other) {
        return this.start < other.end && this.end > other.start;
    }
}