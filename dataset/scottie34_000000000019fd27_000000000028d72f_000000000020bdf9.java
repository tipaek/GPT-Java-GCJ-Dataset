import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static class Activity {
        private int id;
        private int start;
        private int end;

        public Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Activity activity = (Activity) o;
            return id == activity.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            char[] results = new char[n];

            List<Activity> sortedActivities = IntStream.range(0, n)
                    .mapToObj(id -> new Activity(id, in.nextInt(), in.nextInt()))
                    .sorted(Comparator.comparing(Activity::getStart))
                    .collect(Collectors.toList());

            List<Activity> unassignedActivities = new ArrayList<>(sortedActivities);
            //fill C activities
            int lastEnd = 0;
            for (Activity a : sortedActivities) {
                if (a.getStart() >= lastEnd) {
                    results[a.getId()] = 'C';
                    lastEnd = a.getEnd();
                    unassignedActivities.remove(a);
                }
            }

            //fill J activities
            lastEnd = 0;
            for (Activity a : unassignedActivities) {
                if (a.getStart() >= lastEnd) {
                    results[a.getId()] = 'J';
                    lastEnd = a.getEnd();
                }
            }

            String result = new String(results).trim();
            if (result.length() != n) {
                System.out.println("case #" + i + ": IMPOSSIBLE");
            }
            else {
                System.out.println("case #" + i + ": " + result);
            }
        }
    }

}
