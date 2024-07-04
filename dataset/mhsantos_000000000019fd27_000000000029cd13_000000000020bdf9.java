import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        caset:
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int actv = 0; actv < n; actv++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Activity activity = new Activity();
                activity.id = actv;
                activity.start = start;
                activity.end = end;
                activities.add(activity);
            }
            activities.sort((Activity a1, Activity a2) -> a1.start - a2.start);
            List<int[]> CSchedule = new ArrayList<>();
            List<int[]> JSchedule = new ArrayList<>();
            for (Activity activity : activities) {
                if (isParentFree(activity.start, activity.end, CSchedule)) {
                    activity.parent = 'C';
                    CSchedule.add(new int[] {activity.start, activity.end});
                }
                else if (isParentFree(activity.start, activity.end, JSchedule)) {
                    activity.parent = 'J';
                    JSchedule.add(new int[] {activity.start, activity.end});
                }
                else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    continue caset;
                }
            }

            activities.sort((Activity a1, Activity a2) -> a1.id - a2.id);
            StringBuffer schedule = new StringBuffer();
            for (Activity activity : activities) {
                schedule.append(activity.parent);
            }
            System.out.println("Case #" + i + ": " + schedule.toString());

        }
    }

    static boolean isParentFree(int start, int end, List<int[]> schedule) {
        if (schedule.isEmpty()) {
            return true;
        }
        for (int[] fromTo : schedule) {
            if (start < fromTo[1] && end > fromTo[0]) {
                return false;
            }
        }
        return true;
    }

    static class Activity {
        int id = 0;
        int start = 0;
        int end = 0;
        char parent = 'x';
    }
}

