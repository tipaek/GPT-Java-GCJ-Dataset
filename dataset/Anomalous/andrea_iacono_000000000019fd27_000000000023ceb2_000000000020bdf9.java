import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        long numberOfCases = scanner.nextLong();
        for (int i = 0; i < numberOfCases; i++) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < numberOfActivities; j++) {
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

        return generateSchedule(cameron, jamie);
    }

    private static String generateSchedule(Parent cameron, Parent jamie) {
        StringBuilder schedule = new StringBuilder();
        List<Activity> cameronActivities = cameron.getActivities();
        List<Activity> jamieActivities = jamie.getActivities();

        int cameronIndex = 0, jamieIndex = 0;

        while (cameronIndex < cameronActivities.size() || jamieIndex < jamieActivities.size()) {
            if (cameronIndex < cameronActivities.size() && jamieIndex < jamieActivities.size()) {
                Activity cameronNext = cameronActivities.get(cameronIndex);
                Activity jamieNext = jamieActivities.get(jamieIndex);

                if (cameronNext.getStart() < jamieNext.getStart()) {
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
        private final List<Activity> activities = new ArrayList<>();

        public void addActivity(Activity activity) {
            activities.add(activity);
        }

        public boolean isAvailable(Activity activity) {
            for (Activity plannedActivity : activities) {
                if ((activity.getStart() < plannedActivity.getEnd() && activity.getEnd() > plannedActivity.getStart())) {
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
        private final int start;
        private final int end;

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