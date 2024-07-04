import java.io.BufferedReader;
import java.io.StringReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      
        long n = in.nextLong(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                activities.add(new Activity(in.nextInt(), in.nextInt()));
            }
            Planning result = parenting(new Planning(new Parent(), new Parent()), 0, activities);
            System.out.println("Case #" + (i + 1) + ": " + (result == null ? "IMPOSSIBLE" : schedule(result.cameron, result.jamie)));
        }
    }
    
    private static Planning parenting(Planning partial, int currentIdx, List<Activity> activities) {

        if (currentIdx >= activities.size()) {
            return new Planning(partial.cameron, partial.jamie);
        }

        Activity currentActivity = activities.get(currentIdx);
        if (!partial.cameron.isFreeFor(currentActivity) && !partial.jamie.isFreeFor(currentActivity)) {
            return null;
        }

        if (partial.cameron.isFreeFor(currentActivity)) {
            partial.cameron.add(currentActivity);
            Planning result = parenting(partial, currentIdx + 1, activities);
            if (result != null) {
                return result;
            };
            partial.cameron.remove(currentActivity);
        }
        if (partial.jamie.isFreeFor(currentActivity)) {
            partial.jamie.add(currentActivity);
            Planning result = parenting(partial, currentIdx + 1, activities);
            if (result != null) {
                return result;
            }
            partial.jamie.remove(currentActivity);
        }
        return null;
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

    static class Planning {
        Parent cameron;
        Parent jamie;

        public Planning(Parent cameron, Parent jamie) {
            this.cameron = new Parent();
            this.cameron.plan = cameron.plan;
            this.jamie = new Parent();
            this.jamie.plan = jamie.plan;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Planning{");
            sb.append("cameron=").append(cameron);
            sb.append(", jamie=").append(jamie);
            sb.append('}');
            return sb.toString();
        }
    }
    
    static class Parent {
        List<Activity> plan = new ArrayList<>();

        public void add(Activity activity) {
            plan.add(activity);
        }

        public boolean isFreeFor(Activity toAdd) {
            for (Activity planned : plan) {
                if ((toAdd.start >= planned.start && toAdd.start < planned.end) ||
                        (toAdd.end > planned.start && toAdd.end <= planned.end)) {
                    return false;
                }
            }
//            System.out.println("is Free to add " + toAdd + " in plan " + plan);
            return true;
        }

        @Override
        public String toString() {
            return plan.toString();
        }

        public void remove(Activity activity) {
            plan.remove(activity);
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Activity activity = (Activity) o;

            if (start != activity.start) return false;
            return end == activity.end;
        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}
