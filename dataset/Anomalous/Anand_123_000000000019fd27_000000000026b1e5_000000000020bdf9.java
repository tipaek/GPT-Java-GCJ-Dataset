import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                activities.add(new Activity(s, e));
            }

            activities.sort(Comparator.comparingInt(a -> a.s));

            Map<Integer, String> scheduleMap = new HashMap<>();
            int cEnd = 0;
            int jEnd = 0;
            boolean impossible = false;

            for (Activity activity : activities) {
                if (activity.s >= cEnd) {
                    cEnd = activity.e;
                    scheduleMap.put(activity.s, "C");
                } else if (activity.s >= jEnd) {
                    jEnd = activity.e;
                    scheduleMap.put(activity.s, "J");
                } else {
                    impossible = true;
                    break;
                }
            }

            StringBuilder schedule = new StringBuilder();
            for (Activity activity : activities) {
                schedule.append(scheduleMap.get(activity.s));
            }

            if (impossible) {
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