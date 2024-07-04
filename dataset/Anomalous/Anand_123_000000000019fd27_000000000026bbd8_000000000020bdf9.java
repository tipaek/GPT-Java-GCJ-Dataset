import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<>();
            List<Activity> originalActivities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Activity activity = new Activity(start, end);
                activities.add(activity);
                originalActivities.add(activity);
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            Map<Integer, String> scheduleMap = new HashMap<>();
            int cEnd = 0;
            int jEnd = 0;
            boolean isImpossible = false;

            for (Activity activity : activities) {
                if (activity.start >= cEnd) {
                    cEnd = activity.end;
                    scheduleMap.put(activity.start, "C");
                } else if (activity.start >= jEnd) {
                    jEnd = activity.end;
                    scheduleMap.put(activity.start, "J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder schedule = new StringBuilder();
            for (Activity activity : originalActivities) {
                schedule.append(scheduleMap.get(activity.start));
            }

            if (!isImpossible) {
                System.out.println("Case #" + caseNumber + ": " + schedule);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
            caseNumber++;
        }

        sc.close();
    }
}

class Activity {
    int start;
    int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}