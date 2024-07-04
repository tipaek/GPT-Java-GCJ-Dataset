import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<>();
            List<Activity> original = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                Activity activity = new Activity(s, e);
                activities.add(activity);
                original.add(activity);
            }

            activities.sort((a1, a2) -> {
                if (a1.s != a2.s) {
                    return a1.s - a2.s;
                }
                return a1.e - a2.e;
            });

            Map<Integer, String> scheduleMap = new HashMap<>();
            int cameronEnd = 0;
            int jamieEnd = 0;
            boolean isImpossible = false;

            for (Activity activity : activities) {
                if (activity.s >= cameronEnd) {
                    cameronEnd = activity.e;
                    scheduleMap.put(activity.s, "C");
                } else if (activity.s >= jamieEnd) {
                    jamieEnd = activity.e;
                    scheduleMap.put(activity.s, "J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder schedule = new StringBuilder();
            for (Activity activity : original) {
                schedule.append(scheduleMap.get(activity.s));
            }

            if (isImpossible) {
                System.out.println("Case #" + p + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + p + ": " + schedule);
            }
        }
    }
}

class Activity {
    int s;
    int e;

    Activity(int s, int e) {
        this.s = s;
        this.e = e;
    }
}