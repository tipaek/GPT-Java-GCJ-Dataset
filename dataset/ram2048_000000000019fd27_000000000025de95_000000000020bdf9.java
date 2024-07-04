import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {

    public static class Activity implements Comparable<Activity> {

        public int index;
        public int start;
        public int end;
        public String assignment = "";

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return start - o.start;
        }

        public Assignment asAssignment() {
            return new Assignment(this);
        }
    }

    public static class Assignment implements Comparable<Assignment> {

        public int index;
        public String assignment;

        public Assignment(Activity activity) {
            this.index = activity.index;
            this.assignment = activity.assignment;
        }

        @Override
        public int compareTo(Assignment o) {
            return index -= o.index;
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
            for (Activity activity: activities) {
                if (activity.start < ce && activity.start < je) {
                    impossible = true;
                    break;
                }
                if (activity.start >= ce) {
                    ce = activity.end;
                    activity.assignment = "C";
                } else {
                    je = activity.end;
                    activity.assignment = "J";
                }
            }
            String assignment;
            if (impossible) {
                assignment = "IMPOSSIBLE";
            } else {
                Assignment[] assignments = new Assignment[activities.length];
                int a = 0;
                for (Activity activity: activities) {
                    assignments[a++] = activity.asAssignment();
                }
                Arrays.sort(assignments);
                StringBuilder sb = new StringBuilder();
                for (Assignment ass: assignments) {
                    sb.append(ass.assignment);
                }
                assignment = sb.toString();
            }
            System.out.println("Case #" + i + ": " + assignment);
        }
    }
}
