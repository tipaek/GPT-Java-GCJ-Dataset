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

            int cEnd = 0, jEnd = 0;
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            for (Activity activity : activities) {
                if (activity.s >= cEnd) {
                    cEnd = activity.e;
                    schedule.append("C");
                } else if (activity.s >= jEnd) {
                    jEnd = activity.e;
                    schedule.append("J");
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + p + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + p + ": " + schedule);
            }
        }
        sc.close();
    }
}

class Activity {
    int s, e;

    Activity(int s, int e) {
        this.s = s;
        this.e = e;
    }
}