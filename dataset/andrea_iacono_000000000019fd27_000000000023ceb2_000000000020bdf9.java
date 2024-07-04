import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Scanner in = new Scanner(new BufferedReader(new StringReader(input)));

        long n = in.nextLong(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                activities.add(new Activity(in.nextInt(), in.nextInt()));
            }
            String result = parenting(activities);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String parenting(List<Activity> activities) {
        Parent cameron = new Parent();
        Parent jamie = new Parent();
        for (Activity activity : activities) {
            if (cameron.isFreeFor(activity)) {
                cameron.add(activity);
            } else if (jamie.isFreeFor(activity)) {
                jamie.add(activity);
            } else return "IMPOSSIBLE";
        }
//        System.out.println("C:" + cameron.plan);
//        System.out.println("J:" + jamie.plan);
        return schedule(cameron, jamie);
    }

    private static String schedule(Parent cameron, Parent jamie) {
        StringBuilder result = new StringBuilder();
        List<Activity> l1 = cameron.plan;
        List<Activity> l2 = jamie.plan;
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < l1.size() || idx2 < l2.size()) {

            if (idx1 < l1.size() && idx2 < l2.size()) {
                Activity nextCameron = l1.get(idx1);
                Activity nextJamie = l2.get(idx2);
                if (nextCameron.start < nextJamie.start) {
                    result.append("C");
                    idx1++;
                } else {
                    result.append("J");
                    idx2++;
                }
            } else if (idx1 < l1.size()) {
                result.append("C");
                idx1++;
            } else {
                result.append("J");
                idx2++;
            }
        }
        return result.toString();
    }

    static class Parent {
        List<Activity> plan = new ArrayList<>();

        public void add(Activity activity) {
            plan.add(activity);
        }

        public boolean isFreeFor(Activity toAdd) {
            for (Activity planned : plan) {
                if ((toAdd.start > planned.start && toAdd.start < planned.end) ||
                        (toAdd.end > planned.start && toAdd.end < planned.end)) {
                    return false;
                }
            }
//            System.out.println("is Free to add " + toAdd + " in plan " + plan);
            return true;
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
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}
