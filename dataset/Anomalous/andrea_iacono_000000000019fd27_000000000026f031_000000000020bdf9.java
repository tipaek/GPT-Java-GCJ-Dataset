import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        long testCases = scanner.nextLong();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < activityCount; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            Planning planningResult = planActivities(new Planning(new Parent(), new Parent()), 0, activities);
            System.out.println("Case #" + testCase + ": " + (planningResult == null ? "IMPOSSIBLE" : generateSchedule(planningResult.cameron, planningResult.jamie)));
        }
    }

    private static Planning planActivities(Planning currentPlan, int currentIndex, List<Activity> activities) {
        if (currentIndex >= activities.size()) {
            return new Planning(currentPlan.cameron, currentPlan.jamie);
        }

        Activity currentActivity = activities.get(currentIndex);
        if (!currentPlan.cameron.canAccommodate(currentActivity) && !currentPlan.jamie.canAccommodate(currentActivity)) {
            return null;
        }

        if (currentPlan.cameron.canAccommodate(currentActivity)) {
            currentPlan.cameron.addActivity(currentActivity);
            Planning result = planActivities(currentPlan, currentIndex + 1, activities);
            if (result != null) {
                return result;
            }
            currentPlan.cameron.removeActivity(currentActivity);
        }

        if (currentPlan.jamie.canAccommodate(currentActivity)) {
            currentPlan.jamie.addActivity(currentActivity);
            Planning result = planActivities(currentPlan, currentIndex + 1, activities);
            if (result != null) {
                return result;
            }
            currentPlan.jamie.removeActivity(currentActivity);
        }

        return null;
    }

    private static String generateSchedule(Parent cameron, Parent jamie) {
        StringBuilder schedule = new StringBuilder();
        List<Activity> cameronActivities = cameron.activities;
        List<Activity> jamieActivities = jamie.activities;
        int cameronIndex = 0, jamieIndex = 0;

        while (cameronIndex < cameronActivities.size() || jamieIndex < jamieActivities.size()) {
            if (cameronIndex < cameronActivities.size() && jamieIndex < jamieActivities.size()) {
                Activity cameronActivity = cameronActivities.get(cameronIndex);
                Activity jamieActivity = jamieActivities.get(jamieIndex);
                if (cameronActivity.start < jamieActivity.start) {
                    schedule.append("C");
                    cameronIndex++;
                } else {
                    schedule.append("J");
                    jamieIndex++;
                }
            } else if (cameronIndex < cameronActivities.size()) {
                schedule.append("C");
                cameronIndex++;
            } else {
                schedule.append("J");
                jamieIndex++;
            }
        }
        return schedule.toString();
    }

    static class Planning {
        Parent cameron;
        Parent jamie;

        public Planning(Parent cameron, Parent jamie) {
            this.cameron = new Parent(cameron.activities);
            this.jamie = new Parent(jamie.activities);
        }

        @Override
        public String toString() {
            return "Planning{" + "cameron=" + cameron + ", jamie=" + jamie + '}';
        }
    }

    static class Parent {
        List<Activity> activities;

        public Parent() {
            this.activities = new ArrayList<>();
        }

        public Parent(List<Activity> activities) {
            this.activities = new ArrayList<>(activities);
        }

        public void addActivity(Activity activity) {
            activities.add(activity);
        }

        public void removeActivity(Activity activity) {
            activities.remove(activity);
        }

        public boolean canAccommodate(Activity activity) {
            for (Activity existingActivity : activities) {
                if ((activity.start >= existingActivity.start && activity.start < existingActivity.end) ||
                    (activity.end > existingActivity.start && activity.end <= existingActivity.end)) {
                    return false;
                }
            }
            return true;
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