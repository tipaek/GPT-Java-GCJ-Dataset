import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                activities.add(new Activity(sc.nextInt(), sc.nextInt()));
            }
            List<Activity> sortedActivities = new ArrayList<>(activities);
            Collections.sort(sortedActivities);

            int endJ = 0, endC = 0;
            boolean possible = true;
            for (Activity activity : sortedActivities) {
                if (activity.start >= endJ) {
                    activity.assignedTo = 'J';
                    endJ = activity.end;
                } else if (activity.start >= endC) {
                    activity.assignedTo = 'C';
                    endC = activity.end;
                } else {
                    System.out.printf("Case #%d: IMPOSSIBLE%n", cs);
                    possible = false;
                    break;
                }
            }

            if (possible) {
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.assignedTo);
                }
                System.out.printf("Case #%d: %s%n", cs, result.toString());
            }
        }
    }

    private static class Activity implements Comparable<Activity> {
        int start, end;
        char assignedTo = '.';

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}