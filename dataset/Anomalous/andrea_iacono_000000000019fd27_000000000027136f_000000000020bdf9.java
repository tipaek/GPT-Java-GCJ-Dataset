import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ParentsReturn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long testCases = scanner.nextLong();

        for (int i = 0; i < testCases; i++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            Planning planning = findSchedule(new Planning(new Parent(), new Parent()), 0, activities);
            String result = generateScheduleString(planning, activities);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static Planning findSchedule(Planning currentPlanning, int index, List<Activity> activities) {
        if (index >= activities.size()) {
            return new Planning(currentPlanning.cameron, currentPlanning.jamie);
        }

        Activity activity = activities.get(index);
        if (!currentPlanning.cameron.isAvailable(activity) && !currentPlanning.jamie.isAvailable(activity)) {
            return null;
        }

        if (currentPlanning.cameron.isAvailable(activity)) {
            currentPlanning.cameron.addActivity(activity);
            Planning result = findSchedule(currentPlanning, index + 1, activities);
            if (result != null) {
                return result;
            }
            currentPlanning.cameron.removeActivity(activity);
        }

        if (currentPlanning.jamie.isAvailable(activity)) {
            currentPlanning.jamie.addActivity(activity);
            Planning result = findSchedule(currentPlanning, index + 1, activities);
            if (result != null) {
                return result;
            }
            currentPlanning.jamie.removeActivity(activity);
        }

        return null;
    }

    private static String generateScheduleString(Planning planning, List<Activity> activities) {
        if (planning == null) {
            return "IMPOSSIBLE";
        }

        StringBuilder schedule = new StringBuilder();
        for (Activity activity : activities) {
            if (planning.cameron.containsActivity(activity)) {
                schedule.append("C");
            } else {
                schedule.append("J");
            }
        }
        return schedule.toString();
    }

    static class Planning {
        Parent cameron;
        Parent jamie;

        public Planning(Parent cameron, Parent jamie) {
            this.cameron = new Parent(cameron);
            this.jamie = new Parent(jamie);
        }

        @Override
        public String toString() {
            return "Planning{" +
                    "cameron=" + cameron +
                    ", jamie=" + jamie +
                    '}';
        }
    }

    static class Parent {
        List<Activity> activities;

        public Parent() {
            this.activities = new ArrayList<>();
        }

        public Parent(Parent other) {
            this.activities = new ArrayList<>(other.activities);
        }

        public void addActivity(Activity activity) {
            activities.add(activity);
        }

        public boolean isAvailable(Activity activity) {
            for (Activity a : activities) {
                if (activity.overlapsWith(a)) {
                    return false;
                }
            }
            return true;
        }

        public void removeActivity(Activity activity) {
            activities.remove(activity);
        }

        public boolean containsActivity(Activity activity) {
            return activities.contains(activity);
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

        public boolean overlapsWith(Activity other) {
            return (this.start < other.end && this.end > other.start);
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