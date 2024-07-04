import java.util.*;

public class Solution {

    static class Activity {
        int start, end, order;
        char assigned;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < A; j++) {
                Activity activity = new Activity();
                activity.start = sc.nextInt();
                activity.end = sc.nextInt();
                activity.order = j;
                activities.add(activity);
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            boolean impossible = false;
            int cEnd = 0, jEnd = 0;

            for (Activity activity : activities) {
                if (activity.start >= cEnd) {
                    activity.assigned = 'C';
                    cEnd = activity.end;
                } else if (activity.start >= jEnd) {
                    activity.assigned = 'J';
                    jEnd = activity.end;
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                activities.sort(Comparator.comparingInt(a -> a.order));
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.assigned);
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }
}