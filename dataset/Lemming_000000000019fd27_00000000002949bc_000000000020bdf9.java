import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Solution my = new Solution(); // Instance necessary to access inner class.
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                activities.add(my.new Activity(j, s, e));
            }
            Collections.sort(activities); // Sort on start time.

            Activity activityCameron = null;
            Activity activityJamie = null;
            boolean impossible = false;
            for (Activity activity : activities) {
                if (activityCameron == null || activity.startTime >= activityCameron.endTime) {
                    activity.assignee = 'C';
                    activityCameron = activity;
                } else if (activityJamie == null || activity.startTime >= activityJamie.endTime) {
                    activity.assignee = 'J';
                    activityJamie = activity;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                char[] y = new char[n];
                for (Activity activity : activities) {
                    y[activity.index] = activity.assignee;
                }
                System.out.println("Case #" + i + ": " + String.valueOf(y));
            }
        }
        in.close();
    }

    private class Activity implements Comparable<Activity> {
        int index;
        int startTime;
        int endTime;
        char assignee;

        public Activity(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Activity o) {
            return this.startTime - o.startTime;
        }
    }

}