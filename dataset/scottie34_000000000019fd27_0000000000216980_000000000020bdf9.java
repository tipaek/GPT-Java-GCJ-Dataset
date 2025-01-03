import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static class Activity {
        private int start;
        private int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            StringBuilder result = new StringBuilder();
            int n = in.nextInt();
            List<Activity> cActivities = new ArrayList<>();
            List<Activity> jActivities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                Activity activity = new Activity(in.nextInt(), in.nextInt());
                if (!isOverlapping(cActivities, activity)) {
                    result.append("C");
                    cActivities.add(activity);
                }
                else if (!isOverlapping(jActivities, activity)) {
                    result.append("J");
                    jActivities.add(activity);
                }
                else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("case #" + i + ": " + result);
        }
    }

    private static boolean isOverlapping(List<Activity> activities, Activity activity) {
        for (int i = 0; i < activities.size(); i++) {
            Activity activity1 = activities.get(i);
            if (activity.start > activity1.start && activity.start < activity1.end) {
                return true;
            }
            if (activity.end > activity1.start && activity.end < activity1.end) {
                return true;
            }
        }
        return false;
    }

}
