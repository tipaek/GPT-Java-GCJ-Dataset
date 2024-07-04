import java.util.*;
import java.io.*;

public class Solution {

    private static final char CAMERON = 'C';
    private static final char JAMIE = 'J';
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    static class Activity {
        int startTime;
        int endTime;
        Parent assignee;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.assignee = null;
        }

        @Override
        public String toString() {
            return String.format("%d-%d (%s)", startTime, endTime, assignee == null ? "" : assignee.name);
        }
    }

    static class Parent {
        char name;
        int availableAt;

        Parent(char name) {
            this.name = name;
            this.availableAt = 0;
        }

        boolean isAvailable(Activity activity) {
            return availableAt <= activity.startTime;
        }

        void assign(Activity activity) {
            this.availableAt = activity.endTime;
            activity.assignee = this;
        }
    }

    private static String solve(List<Activity> activities) {
        Parent cameron = new Parent(CAMERON);
        Parent jamie = new Parent(JAMIE);
        StringBuilder result = new StringBuilder();

        activities.sort(Comparator.comparingInt(a -> a.startTime));

        for (Activity activity : activities) {
            if (cameron.isAvailable(activity)) {
                cameron.assign(activity);
            } else if (jamie.isAvailable(activity)) {
                jamie.assign(activity);
            } else {
                return IMPOSSIBLE;
            }
        }

        for (Activity activity : activities) {
            result.append(activity.assignee.name);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.add(new Activity(startTime, endTime));
            }

            String result = solve(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}