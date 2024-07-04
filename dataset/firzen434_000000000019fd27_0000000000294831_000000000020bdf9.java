import java.util.*;
import java.io.*;
public class Solution {

    private static final char CAMERON = 'C';
    private static final char JAMIE = 'J';
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    static class Activity {
        int startTime;
        int endTime;
        Parent assignee = null;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return String.format("%d-%d (%s)", startTime, endTime, assignee == null ? "" : assignee.name);
        }
    }

    static class Parent {
        char name;
        Activity assignedActivity = null;

        Parent(char name) {
            this.name = name;
        }

        boolean isBusy(Activity activity) {
            if (assignedActivity != null) {
                return assignedActivity.endTime > activity.startTime;
            }
            return false;
        }

        void assignActivity(Activity activity) {
            assert !isBusy(activity);

            assignedActivity = activity;
            activity.assignee = this;
        }
    }

    private static String soln(List<Activity> activities) {
        Parent cameron = new Parent(CAMERON);
        Parent jamie = new Parent(JAMIE);
        StringBuilder sb = new StringBuilder();

        List<Activity> sortedActivities = new ArrayList<>(activities);
        sortedActivities.sort(Comparator.comparingInt(o -> o.startTime));

        for (Activity activity : sortedActivities) {
            if (cameron.isBusy(activity) && jamie.isBusy(activity)) {
                return IMPOSSIBLE;
            } else if (cameron.isBusy(activity)) {
                jamie.assignActivity(activity);
            } else {
                // if both parents are free, assign to Cameron by default
                cameron.assignActivity(activity);
            }
        }

        for (Activity activity : activities) {
            if (activity.assignee != null) {
                sb.append(activity.assignee.name);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        List<Activity> activities = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            int numActivities = in.nextInt();
            for (int j = 0; j < numActivities; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                activities.add(new Activity(s, e));
            }
            System.out.println("Case #" + i + ": " + soln(activities));
            activities.clear();
        }
    }
}