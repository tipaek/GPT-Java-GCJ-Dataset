import java.util.*;
import java.io.*;

public class Solution {

    public static class Activity implements Comparable<Activity> {

        public int index;
        public int start;
        public int end;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            Activity[] activities = new Activity[n];
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                activities[j] = new Activity(j, s, e);
            }
            Arrays.sort(activities);
            boolean impossible = false;
            int ce = -1;
            int je = -1;
            char[] assignments = new char[n];
            for (Activity activity: activities) {
                if (activity.start < ce && activity.start < je) {
                    impossible = true;
                    break;
                }
                if (activity.start >= ce) {
                    ce = activity.end;
                    assignments[activity.index] = 'C';
                } else {
                    je = activity.end;
                    assignments[activity.index] = 'J';
                }
            }
            String assignment;
            if (impossible) {
                assignment = "IMPOSSIBLE";
            } else {
                assignment = new String(assignments);
            }
            System.out.println("Case #" + i + ": " + assignment);
        }
    }
}
