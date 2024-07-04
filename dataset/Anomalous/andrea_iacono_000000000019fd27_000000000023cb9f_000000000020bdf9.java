import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ParentsReturn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        long testCases = scanner.nextLong();
        for (int i = 0; i < testCases; i++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < activityCount; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            String result = assignActivities(activities);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String assignActivities(List<Activity> activities) {
        Parent cameron = new Parent();
        Parent jamie = new Parent();

        for (Activity activity : activities) {
            if (cameron.isAvailable(activity)) {
                cameron.addActivity(activity);
            } else if (jamie.isAvailable(activity)) {
                jamie.addActivity(activity);
            } else {
                return "IMPOSSIBLE";
            }
        }
        return createSchedule(cameron, jamie);
    }

    private static String createSchedule(Parent cameron, Parent jamie) {
        StringBuilder schedule = new StringBuilder();
        List<Activity> cameronActivities = cameron.getActivities();
        List<Activity> jamieActivities = jamie.getActivities();
        int cameronIndex = 0;
        int jamieIndex = 0;

        while (cameronIndex < cameronActivities.size() || jamieIndex < jamieActivities.size()) {
            if (cameronIndex < cameronActivities.size() && jamieIndex < jamieActivities.size()) {
                Activity nextCameronActivity = cameronActivities.get(cameronIndex);
                Activity nextJamieActivity = jamieActivities.get(jamieIndex);
                if (nextCameronActivity.getStart() < nextJamieActivity.getStart()) {
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

    static class Parent {
        private List<Activity> activities = new ArrayList<>();

        public void addActivity(Activity activity) {
            activities.add(activity);
        }

        public boolean isAvailable(Activity activity) {
            for (Activity scheduledActivity : activities) {
                if ((activity.getStart() < scheduledActivity.getEnd() && activity.getEnd() > scheduledActivity.getStart())) {
                    return false;
                }
            }
            return true;
        }

        public List<Activity> getActivities() {
            return activities;
        }
    }

    static class Activity {
        private int start;
        private int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}