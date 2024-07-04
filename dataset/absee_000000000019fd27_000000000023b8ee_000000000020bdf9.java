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
                activities[i] = new Activity(in.nextInt(), in.nextInt());
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
            String result = null;
            char[] choice = new char[n];
            if (check(n, 0, choice)) {
                result = new String(choice);
            } else {
                result = "IMPOSSIBLE";
            }
            return result;
        }

        private ArrayDeque<Activity> cameronChoice = new ArrayDeque<>();
        private ArrayDeque<Activity> jamieChoice = new ArrayDeque<>();

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
                } else if (selectedActivity.s < activity.s && activity.e < selectedActivity.e) {
                    return false;
                } else if (activity.s < selectedActivity.s && selectedActivity.e < activity.e) {
                    return false;
                } else if (selectedActivity.s == activity.s && selectedActivity.e == activity.e) {
                    return false;
                }
            }
            return true;
        }

        private boolean check(int n, int activityIndex, char[] choice) {

            if (activityIndex == n) {
                // it's answer complete, return true
                return true;
            } else {
                // validate choice Cameron
                choice[activityIndex] = 'C';
                if (validate(activityIndex, choice[activityIndex])) {
                    // choice Cameron
                    cameronChoice.push(activities[activityIndex]);
                    // do next choice
                    if (check(n, activityIndex + 1, choice)) {
                        // if get first answer return
                        return true;
                    } else {
                        // choice back
                        cameronChoice.pop();
                    }
                }
                // validate choice Jamie
                choice[activityIndex] = 'J';
                if (validate(activityIndex, choice[activityIndex])) {
                    // choice Jamie
                    jamieChoice.push(activities[activityIndex]);
                    // do next choice
                    if (check(n, activityIndex + 1, choice)) {
                        // if get first answer return
                        return true;
                    } else {
                        // choice back
                        jamieChoice.pop();
                    }
                }
            }
            // it's not answer any more, return false
            return false;
        }
    }

    public static class Activity {
        int s;
        int e;

        public Activity(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

}