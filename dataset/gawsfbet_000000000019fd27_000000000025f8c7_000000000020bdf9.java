import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t0 = 1; t0 <= t; ++t0) {
            int n = in.nextInt();
            String ans = "";
            char[] schedule = new char[n];
            PriorityQueue<Activity> activities = new PriorityQueue<>();
            Stack<Activity> cameron = new Stack<>(), jamie = new Stack<>();

            for (int i = 0; i < n; i++) {
                activities.add(new Activity(in.nextInt(), in.nextInt(), i));
            }

            while (!activities.isEmpty()) {
                Activity next = activities.poll();

                if (canAssignTo(next, cameron)) {
                    cameron.push(next);
                    schedule[next.index] = 'C';
                } else if (canAssignTo(next, jamie)) {
                    jamie.push(next);
                    schedule[next.index] = 'J';
                } else {
                    ans = "IMPOSSIBLE";
                    break;
                }
            }

            if (!ans.equals("IMPOSSIBLE")) {
                ans = new String(schedule);
            }

            System.out.println(String.format("Case #%d: %s", t0, ans));
        }
    }

    public static boolean canAssignTo(Activity nextActivity, Stack<Activity> activityList) {
        return activityList.isEmpty() || activityList.peek().end <= nextActivity.start;
    }

    public static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity that) {
            if (this.start != that.start) {
                return this.start - that.start;
            } else {
                return this.end - that.end;
            }
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }
}