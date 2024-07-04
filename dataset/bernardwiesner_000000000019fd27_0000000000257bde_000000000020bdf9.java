import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            StringBuilder sb = new StringBuilder();
            int n = in.nextInt(); //activities
            Parent ja = new Parent();
            Parent ca = new Parent();
            ArrayList<Activity> activities = new ArrayList<Activity>();
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                activities.add(new Activity(s, e));
            }

            Collections.sort(activities);
            for (Activity a : activities){
                if (ja.canTakeActivity(a)) {
                    sb.append("C");
                } else if (ca.canTakeActivity(a)) {
                    sb.append("J");
                } else {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

                System.out.println("Case #" + i + ": " + sb);

        }
    }

    static class Activity implements Comparable<Activity>{
        final int start;
        final int end;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean inRange(Activity activity) {
            return (activity.start >= start && activity.start < end) || (activity.end > start && activity.end <= end);
        }

        @Override
        public int compareTo(Activity activity) {
            return Integer.compare(this.start, activity.start);
        }
    }

    static class Parent {
        ArrayList<Activity> activities = new ArrayList<Activity>();
        boolean canTakeActivity(Activity activity){
            for (Activity a : activities) {
                if (a.inRange(activity)) return false;
            }
            activities.add(activity);
            return true;
        }

    }
}