import java.util.*;
import java.io.*;

public class Solution {

    private static class Activity implements Comparable<Activity> {
        public int start;
        public int stop;
        public int no;
        public String person;

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return start + " " + stop;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Activity)) return false;
            Activity other = (Activity) obj;
            return start == other.start && stop == other.stop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, stop);
        }
    }

    private static class Person {
        public String initial;
        public Activity lastActivity;

        public boolean canTakeActivity(Activity activity) {
            return lastActivity == null || lastActivity.stop <= activity.start;
        }

        @Override
        public String toString() {
            return initial + " A: " + lastActivity.toString() + "\n";
        }
    }

    private static String processResult(List<Activity> activities) {
        activities.sort(Activity::compareTo);

        Person C = new Person();
        C.initial = "C";
        Person J = new Person();
        J.initial = "J";

        for (Activity activity : activities) {
            if (C.canTakeActivity(activity)) {
                C.lastActivity = activity;
                activity.person = C.initial;
            } else if (J.canTakeActivity(activity)) {
                J.lastActivity = activity;
                activity.person = J.initial;
            } else {
                return "IMPOSSIBLE";
            }
        }

        activities.sort(Comparator.comparingInt(a -> a.no));
        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.person);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(n);
            for (int j = 1; j <= n; j++) {
                Activity activity = new Activity();
                activity.start = scanner.nextInt();
                activity.stop = scanner.nextInt();
                activity.no = j;
                activities.add(activity);
            }
            System.out.println("Case #" + i + ": " + processResult(activities));
        }
    }
}