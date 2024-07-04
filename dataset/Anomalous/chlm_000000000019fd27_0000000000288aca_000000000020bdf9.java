import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scan.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();
            StringBuilder ans = new StringBuilder("X".repeat(n));

            for (int j = 0; j < n; j++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                activities.add(new Activity(j, start, end));
            }

            ArrayList<Activity> activitiesC = new ArrayList<>();
            ArrayList<Activity> activitiesJ = new ArrayList<>();

            for (Activity activity : activities) {
                if (canAssign(activity, activitiesC)) {
                    activitiesC.add(activity);
                    ans.setCharAt(activity.index, 'C');
                } else if (canAssign(activity, activitiesJ)) {
                    activitiesJ.add(activity);
                    ans.setCharAt(activity.index, 'J');
                } else {
                    ans = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.format("Case #%d: %s\n", i, ans);
        }
        scan.close();
    }

    private static boolean canAssign(Activity activity, ArrayList<Activity> assignedActivities) {
        for (Activity assigned : assignedActivities) {
            if (!(activity.end <= assigned.start || activity.start >= assigned.end)) {
                return false;
            }
        }
        return true;
    }

    static class Activity {
        int index;
        int start;
        int end;

        Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}