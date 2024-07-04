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
                if (ca.canTakeActivity(activity)) {
//                    sb.append("C");
                } else if (ja.canTakeActivity(activity)) {
//                    sb.append("J");
                } else {
                    sb = new StringBuilder("IMPOSSIBLE");
                    imp = true;
//                    break;
                }
            }
            if (!imp) {
                ArrayList<Activity> jList = ja.activities;
                ArrayList<Activity> cList= ca.activities;
                for (int j = 0; j < n; j++) {
                    if (jList.isEmpty()) {
                        for (Activity a : cList) {
                            sb.append("C");
                        }
                        break;
                    }
                    if (cList.isEmpty()) {
                        for (Activity a : jList) {
                            sb.append("J");

                        }
                        break;
                    }
                    if (jList.get(0).start < cList.get(0).start) {
                        sb.append("J");
                        jList.remove(0);
                    } else {
                        sb.append("C");
                        cList.remove(0);
                    }
                }
            }
                System.out.println("Case #" + i + ": " + sb);
            System.out.flush();

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
            return Integer.compare(start, activity.start);
        }
    }

    static class Parent {
        ArrayList<Activity> activities = new ArrayList<Activity>();
        boolean canTakeActivity(Activity activity){
            for (Activity a : activities) {
                if (a.inRange(activity)) return false;
            }
            activities.add(activity);
            Collections.sort(activities);
            return true;
        }

    }
}