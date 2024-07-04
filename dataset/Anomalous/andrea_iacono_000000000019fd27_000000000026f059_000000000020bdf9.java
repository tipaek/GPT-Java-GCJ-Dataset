import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long testCases = scanner.nextLong();

        for (int i = 0; i < testCases; i++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < activityCount; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            Planning result = scheduleActivities(new Planning(new Parent(), new Parent()), 0, activities);
            System.out.println("Case #" + (i + 1) + ": " + (result == null ? "IMPOSSIBLE" : generateSchedule(result.cameron, result.jamie)));
        }
    }

    private static Planning scheduleActivities(Planning currentPlanning, int currentIndex, List<Activity> activities) {
        if (currentIndex >= activities.size()) {
            return new Planning(currentPlanning.cameron, currentPlanning.jamie);
        }

        Activity currentActivity = activities.get(currentIndex);
        if (!currentPlanning.cameron.isAvailable(currentActivity) && !currentPlanning.jamie.isAvailable(currentActivity)) {
            return null;
        }

        if (currentPlanning.cameron.isAvailable(currentActivity)) {
            currentPlanning.cameron.addActivity(currentActivity);
            Planning result = scheduleActivities(currentPlanning, currentIndex + 1, activities);
            if (result != null) {
                return result;
            }
            currentPlanning.cameron.removeActivity(currentActivity);
        }

        if (currentPlanning.jamie.isAvailable(currentActivity)) {
            currentPlanning.jamie.addActivity(currentActivity);
            Planning result = scheduleActivities(currentPlanning, currentIndex + 1, activities);
            if (result != null) {
                return result;
            }
            currentPlanning.jamie.removeActivity(currentActivity);
        }

        return null;
    }

    private static String generateSchedule(Parent cameron, Parent jamie) {
        StringBuilder schedule = new StringBuilder();
        List<Activity> cameronActivities = cameron.getActivities();
        List<Activity> jamieActivities = jamie.getActivities();
        int cameronIdx = 0, jamieIdx = 0;

        while (cameronIdx < cameronActivities.size() || jamieIdx < jamieActivities.size()) {
            if (cameronIdx < cameronActivities.size() && jamieIdx < jamieActivities.size()) {
                Activity cameronActivity = cameronActivities.get(cameronIdx);
                Activity jamieActivity = jamieActivities.get(jamieIdx);

                if (cameronActivity.start < jamieActivity.start) {
                    schedule.append("C");
                    cameronIdx++;
                } else {
                    schedule.append("J");
                    jamieIdx++;
                }
            } else if (cameronIdx < cameronActivities.size()) {
                schedule.append("C");
                cameronIdx++;
            } else {
                schedule.append("J");
                jamieIdx++;
            }
        }

        return schedule.toString();
    }

    static class Planning {
        Parent cameron;
        Parent jamie;

        public Planning(Parent cameron, Parent jamie) {
            this.cameron = new Parent(cameron.getActivities());
            this.jamie = new Parent(jamie.getActivities());
        }

        @Override
        public String toString() {
            return "Planning{" + "cameron=" + cameron + ", jamie=" + jamie + '}';
        }
    }

    static class Parent {
        private List<Activity> activities;

        public Parent() {
            this.activities = new ArrayList<>();
        }

        public Parent(List<Activity> activities) {
            this.activities = new ArrayList<>(activities);
        }

        public void addActivity(Activity activity) {
            activities.add(activity);
        }

        public boolean isAvailable(Activity activity) {
            for (Activity a : activities) {
                if ((activity.start >= a.start && activity.start < a.end) || (activity.end > a.start && activity.end <= a.end)) {
                    return false;
                }
            }
            return true;
        }

        public List<Activity> getActivities() {
            return activities;
        }

        public void removeActivity(Activity activity) {
            activities.remove(activity);
        }

        @Override
        public String toString() {
            return activities.toString();
        }
    }

    static class Activity {
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Activity activity = (Activity) obj;
            return start == activity.start && end == activity.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}