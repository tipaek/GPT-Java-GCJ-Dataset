import java.util.*;
import java.io.*;

public class Solution {


    private static class Activity implements Comparable<Activity> {
        public Integer start;
        public Integer stop;
        public Integer no;
        public String person;

        public int sortNo(Activity o) {
            return no.compareTo(o.no);
        }

        @Override
        public int compareTo(Activity o) {
            return start.compareTo(o.start);
        }

        @Override
        public String toString() {
            return start + " " + stop;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Activity)) return false;
            Activity activity = (Activity) o;
            return start.equals(activity.start) &&
                    stop.equals(activity.stop);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, stop);
        }
    }

    private static class Person {
        public String initial;
        public Activity activity;

        public boolean canTakeActivity(Activity a) {
            return activity.stop <= a.start;
        }

        @Override
        public String toString() {
            return initial + " A: " + activity.toString() + "\n";
        }
    }

    private static String processResult(List<Activity> activityList) {

        activityList.sort(Activity::compareTo);

        final Person C = new Person();
        C.initial = "C";
        final Person J = new Person();
        J.initial = "J";

        for (Activity a : activityList) {
            if (C.activity == null) {
                C.activity = a;
                a.person = C.initial;
            } else if (J.activity == null) {
                J.activity = a;
                a.person = J.initial;
            } else if (C.canTakeActivity(a)) {
                C.activity = a;
                a.person = C.initial;

            } else if (J.canTakeActivity(a)) {
                J.activity = a;
                a.person = J.initial;
            } else {
                return "IMPOSSIBLE";
            }
        }

        activityList.sort(Activity::sortNo);
        return activityList.stream().map(e -> e.person).reduce("", String::concat);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int activities = in.nextInt();
            List<Activity> activityList = new ArrayList<>(100);
            for (int y = 1; y <= activities; y++) {
                Activity activity = new Activity();
                activity.start = in.nextInt();
                activity.stop = in.nextInt();
                activity.no = y;
                activityList.add(activity);
            }
            System.out.println("Case #" + i + ": " + processResult(activityList));
        }
    }
}