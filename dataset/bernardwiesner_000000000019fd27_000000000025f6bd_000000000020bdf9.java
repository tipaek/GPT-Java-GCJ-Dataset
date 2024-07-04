import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        boolean imp =false;
        for (int i = 1; i <= t; ++i) {
            StringBuilder sb = new StringBuilder();
            int n = in.nextInt(); //activities
            Parent ja = new Parent();
            Parent ca = new Parent();
            imp = false;
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                Activity activity = new Activity(s, e);
                if (imp) continue;
                if (ja.canTakeActivity(activity)) {
                    sb.append("C");
                } else if (ca.canTakeActivity(activity)) {
                    sb.append("J");
                } else {
                    sb = new StringBuilder("IMPOSSIBLE");
                    imp = true;
//                    break;
                }
            }

            System.out.println("Case #" + i + ": " + sb);
            System.out.flush();
        }
    }

    static class Activity {
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