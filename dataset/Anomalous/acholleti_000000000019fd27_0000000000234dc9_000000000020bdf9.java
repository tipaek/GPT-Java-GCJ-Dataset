import java.util.*;

public class Solution {

    static class Activity {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void scheduleActivities(int caseNo, int noActivities, List<Activity> activities) {
        PriorityQueue<Activity> activityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.start));
        char[] schedule = new char[noActivities];

        for (Activity activity : activities) {
            activityQueue.add(activity);
        }

        int cEnd = 0;
        int jEnd = 0;

        while (!activityQueue.isEmpty()) {
            Activity currentActivity = activityQueue.poll();

            if (cEnd <= currentActivity.start) {
                cEnd = currentActivity.end;
                schedule[currentActivity.index] = 'C';
            } else if (jEnd <= currentActivity.start) {
                jEnd = currentActivity.end;
                schedule[currentActivity.index] = 'J';
            } else {
                System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + caseNo + ": " + new String(schedule));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int caseNo = 1; caseNo <= cases; caseNo++) {
            int noActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < noActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }

            scheduleActivities(caseNo, noActivities, activities);
        }

        scanner.close();
    }
}