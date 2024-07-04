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

            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < schedules; i++) {
                int beg = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(beg, end, i));
            }

            Collections.sort(activities);

            for (Activity activity : activities) {
                if (activity.beg >= cameronEnd) {
                    cameronEnd = activity.end;
                    activity.owner = 'C';
                } else if (activity.beg >= jamieEnd) {
                    jamieEnd = activity.end;
                    activity.owner = 'J';
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = activities.stream()
                        .sorted(Comparator.comparingInt(a -> a.order))
                        .map(a -> String.valueOf(a.owner))
                        .collect(Collectors.joining());
            }
            System.out.println("Case #" + caseId + ": " + result);
        }
    }

    static class Activity implements Comparable<Activity> {
        final int beg;
        final int end;
        char owner;
        final int order;

        public Activity(int beg, int end, int order) {
            this.beg = beg;
            this.end = end;
            this.order = order;
        }

        @Override
        public int compareTo(Activity other) {
            int compare = Integer.compare(this.beg, other.beg);
            if (compare == 0) {
                return Integer.compare(this.order, other.order);
            }
            return compare;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Activity activity = (Activity) obj;
            return order == activity.order;
        }

        @Override
        public int hashCode() {
            return Objects.hash(order);
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "beg=" + beg +
                    ", end=" + end +
                    ", owner=" + owner +
                    ", order=" + order +
                    '}';
        }
    }
}