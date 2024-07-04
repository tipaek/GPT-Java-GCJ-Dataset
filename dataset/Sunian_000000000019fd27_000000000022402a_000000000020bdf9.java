import java.util.*;

/**
 * Created by Sun on 4/3/2020.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scan.nextLine());
            List<Activity> activities = new ArrayList<>(N);
            for (int n = 0; n < N; n++) {
                String[] inputs = scan.nextLine().split(" ");
                activities.add(new Activity(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
            }
            System.out.printf("Case #%d: %s\n", i + 1, schedule(activities));
        }
    }

    private static String schedule(List<Activity> activities) {
        List<Activity> sorted = new ArrayList<>(activities);
        Collections.sort(sorted);
        Set<Activity> cam = new HashSet<>(activities.size());
        Set<Activity> jam = new HashSet<>(activities.size());
        for (Activity activity : sorted) {
            if (!hasConflict(cam, activity)) {
                cam.add(activity);
            } else if (!hasConflict(jam, activity)) {
                jam.add(activity);
            } else {
                return "IMPOSSIBLE";
            }
        }
        StringBuilder output = new StringBuilder(activities.size());
        for (Activity activity : activities) {
            if (cam.contains(activity)) {
                output.append("C");
            } else {
                output.append("J");
            }
        }
        return output.toString();
    }

    private static boolean hasConflict(Set<Activity> schedule, Activity newActivity) {
        for (Activity activity : schedule) {
            if (activity.conflictsWith(newActivity)) {
                return true;
            }
        }
        return false;
    }

    private static class Activity implements Comparable<Activity> {
        final int start;
        final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean conflictsWith(Activity other) {
            if (other.start >= this.end) {
                return false;
            }
            if (this.start >= other.end) {
                return false;
            }
            return true;
        }

        @Override
        public int compareTo(Activity o) {
            return Integer.compare(start, o.start);
        }
    }
}
