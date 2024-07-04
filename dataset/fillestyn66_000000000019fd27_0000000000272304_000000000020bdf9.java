import java.util.*;
import java.io.*;

public class Solution {


    private static class Activity implements Comparable<Activity> {
        public Integer start;
        public Integer stop;

        @Override
        public int compareTo(Activity o) {
            return start.compareTo(o.start);
        }

        @Override
        public String toString() {
            return start + " " + stop;
        }
    }

    private static class Person {
        public String initial;
        public Activity activity;

        public boolean canTakeActivity(Activity a) {
            return a.stop <= activity.start || a.start >= activity.stop;
        }

        @Override
        public String toString() {
            return initial + " A: " + activity.toString() + "\n";
        }
    }

    private static boolean isImpossible(List<Activity> activityList) {
        List<Activity> duplicateList = new ArrayList<>(activityList.size());
        duplicateList.addAll(activityList);
        duplicateList.sort(Activity::compareTo);

        final Person C = new Person();
        C.initial = "C";
        final Person J = new Person();
        J.initial = "J";

        for (Activity a : activityList) {
            if (C.activity == null) {
                C.activity = a;

            } else if (J.activity == null) {
                J.activity = a;

            } else if (C.canTakeActivity(a)) {
                C.activity = a;

            } else if (J.canTakeActivity(a)) {
                J.activity = a;

            } else {
                return true;
            }
        }
        return false;

    }

    private static String processResult(List<Activity> activityList) {

        if (isImpossible(activityList)) {
            return "IMPOSSIBLE";
        }

        final StringBuilder resultString = new StringBuilder(100);

        final Person C = new Person();
        C.initial = "C";
        final Person J = new Person();
        J.initial = "J";

        for (Activity a : activityList) {
            if (C.activity == null) {
                C.activity = a;
                resultString.append(C.initial);
            } else if (J.activity == null) {
                J.activity = a;
                resultString.append((J.initial));
            } else if (C.canTakeActivity(a)) {
                C.activity = a;
                resultString.append(C.initial);
            } else if (J.canTakeActivity(a)) {
                J.activity = a;
                resultString.append((J.initial));
            }
        }
        return resultString.toString();
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
                activityList.add(activity);
            }
            System.out.println("Case #" + i + ": " + processResult(activityList));
        }
    }
}