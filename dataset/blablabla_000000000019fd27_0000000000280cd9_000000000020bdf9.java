
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseId = 1; caseId <= t; caseId++) {
            int schedules = scanner.nextInt();

            String result = "";

            int cameronEnd = 0;
            int jamieEnd = 0;

            SortedSet<Activity> activities = new TreeSet<>();

            for (int i = 0; i < schedules; i++) {
                int beg = scanner.nextInt();
                int end = scanner.nextInt();

                activities.add(new Activity(beg, end, i));
            }

            for (Activity activity : activities) {
                if (activity.beg >= cameronEnd) {
                    // assign to cameron
                    cameronEnd = activity.end;
                    activity.owner = 'C';
                } else if (activity.beg >= jamieEnd) {
                    // assign to jamie
                    jamieEnd = activity.end;
                    activity.owner = 'J';
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = activities.stream()
                        .sorted(Comparator.comparing(activity -> activity.order))
                        .map(activity -> activity.owner)
                        .map(String::valueOf)
                        .collect(Collectors.joining(""));
            }
            System.out.println("Case #" + caseId + ": " + result);
        }
    }

    static class Activity implements Comparable<Activity> {
        final int beg;
        final int end;
        char owner;
        int order;

        public Activity(int beg, int end, int order) {
            this.beg = beg;
            this.end = end;
            this.order = order;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "beg=" + beg +
                    ", end=" + end +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Activity
                    && ((Activity) obj).order == this.order;
        }

        @Override
        public int hashCode() {
            return Objects.hash(order);
        }

        @Override
        public int compareTo(Activity o) {
            int compare = Integer.compare(beg, o.beg);
            if (compare == 0) {
                return Integer.compare(order, o.order);
            }
            return compare;
        }
    }

}
