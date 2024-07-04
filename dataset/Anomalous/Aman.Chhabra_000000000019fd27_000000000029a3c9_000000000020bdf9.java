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
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
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
                .sorted(Comparator.comparingInt(Activity::getStartTime))
                .collect(Collectors.toList());

        Schedule jSchedule = new Schedule();
        Schedule cSchedule = new Schedule();

        for (Activity activity : sortedActivities) {
            if (!cSchedule.bookActivity(activity) && !jSchedule.bookActivity(activity)) {
                return "IMPOSSIBLE";
            }
        }

        return activities.stream()
                .map(activity -> jSchedule.contains(activity) ? "J" : "C")
                .collect(Collectors.joining());
    }

    static class Schedule {
        private final List<Activity> activities = new ArrayList<>();

        boolean bookActivity(Activity newActivity) {
            for (Activity activity : activities) {
                if (activity.overlaps(newActivity)) {
                    return false;
                }
            }
            activities.add(newActivity);
            return true;
        }

        boolean contains(Activity activity) {
            return activities.contains(activity);
        }
    }

    static class Activity {
        private final int startTime;
        private final int endTime;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public boolean overlaps(Activity other) {
            return (this.startTime < other.endTime && this.endTime > other.startTime);
        }
    }
}