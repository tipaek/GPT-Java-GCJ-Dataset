import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < activityCount; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            results.add(assignActivities(activities));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String assignActivities(List<Activity> activities) {
        List<Activity> sortedActivities = activities.stream()
                .sorted(Comparator.comparingInt(Activity::getDuration).reversed())
                .collect(Collectors.toList());

        Scheduler jScheduler = new Scheduler();
        Scheduler cScheduler = new Scheduler();

        for (Activity activity : sortedActivities) {
            if (!cScheduler.schedule(activity) && !jScheduler.schedule(activity)) {
                return "IMPOSSIBLE";
            }
        }

        return activities.stream()
                .map(activity -> jScheduler.contains(activity) ? "J" : "C")
                .collect(Collectors.joining());
    }

    static class Scheduler {
        private final List<Activity> scheduledActivities = new ArrayList<>();

        boolean schedule(Activity newActivity) {
            for (Activity activity : scheduledActivities) {
                if (overlaps(activity, newActivity)) {
                    return false;
                }
            }
            scheduledActivities.add(newActivity);
            return true;
        }

        boolean contains(Activity activity) {
            return scheduledActivities.contains(activity);
        }

        private boolean overlaps(Activity a, Activity b) {
            return a.startTime < b.endTime && b.startTime < a.endTime;
        }
    }

    static class Activity {
        final int startTime;
        final int endTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        int getDuration() {
            return endTime - startTime;
        }
    }
}