import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int ti = 1; ti <= t; ++ti) {
            int n = in.nextInt();

            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(i, in.nextInt(), in.nextInt());
            }

            Solve solve = new Solve(n, activities);
            System.out.println("Case #" + ti + ": " + solve.solve());
        }
    }

    public static class Solve {


        private Activity[] activities;
        private int n;

        public Solve(int n, Activity[] activities) {
            this.n = n;
            this.activities = activities;
        }

        public String solve() {
            Arrays.sort(this.activities);
            String result = null;
            if (check(n, 0)) {
                char[] reOrderedChoices = new char[n];
                for (int i = 0; i < n; i++){
                    Activity choice = choices.poll();
                    reOrderedChoices[choice.idx] = choice.assigned;
                }
                result = new String(reOrderedChoices);
            } else {
                result = "IMPOSSIBLE";
            }
            return result;
        }

        private ArrayDeque<Activity> cameronChoice = new ArrayDeque<>();
        private ArrayDeque<Activity> jamieChoice = new ArrayDeque<>();
        private ArrayDeque<Activity> choices = new ArrayDeque<>();

        private boolean validate(int activityIndex, char choice) {
            Activity activity = activities[activityIndex];
            if (choice == 'C') {
                return isOverlap(activity, cameronChoice);
            } else if (choice == 'J') {
                return isOverlap(activity, jamieChoice);
            }
            return false;
        }

        private boolean isOverlap(Activity activity, ArrayDeque<Activity> choices) {
            for (Activity selectedActivity : choices) {
                if (selectedActivity.s < activity.e && activity.e < selectedActivity.e) {
                    return false;
                } else if (selectedActivity.s < activity.s && activity.s < selectedActivity.e) {
                    return false;
                } else if (activity.s < selectedActivity.e && selectedActivity.e < activity.e) {
                    return false;
                } else if (activity.s < selectedActivity.s && selectedActivity.s < activity.e) {
                    return false;
                } else if (selectedActivity.s == activity.s && selectedActivity.e == activity.e) {
                    return false;
                }
            }
            return true;
        }

        private boolean check(int n, int activityIndex) {

            if (activityIndex == n) {
                // it's answer complete, return true
                return true;
            } else {

                Activity activitity = activities[activityIndex];

                // validate choice Cameron
                if (validate(activityIndex, 'C')) {
                    // choice Cameron
                    activitity.assigned = 'C';
                    cameronChoice.push(activitity);
                    choices.push(activitity);
                    // do next choice
                    if (check(n, activityIndex + 1)) {
                        // if get first answer return
                        return true;
                    } else {
                        // choice back
                        cameronChoice.pop();
                        choices.pop();
                    }
                }
                // validate choice Jamie
                if (validate(activityIndex, 'J')) {
                    // choice Jamie
                    activitity.assigned = 'J';
                    jamieChoice.push(activitity);
                    choices.push(activitity);
                    // do next choice
                    if (check(n, activityIndex + 1)) {
                        // if get first answer return
                        return true;
                    } else {
                        // choice back
                        jamieChoice.pop();
                        choices.pop();
                    }
                }
            }
            // it's not answer any more, return false
            return false;
        }
    }

    public static class Activity implements Comparable<Activity> {

        int idx;
        int s;
        int e;
        int length;
        char assigned;

        public Activity(int idx, int s, int e) {
            this.idx = idx;
            this.s = s;
            this.e = e;
            this.length = e - s;
        }

        @Override
        public int compareTo(Activity o) {
            return o.length - length;
        }
    }

}