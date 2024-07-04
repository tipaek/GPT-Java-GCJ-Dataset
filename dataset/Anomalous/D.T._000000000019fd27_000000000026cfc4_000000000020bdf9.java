import java.util.*;

public class Solution {

    public static void solve(int caseNumber, Scanner scanner, int activityCount) {
        PriorityQueue<Activity> activityQueue = new PriorityQueue<>(Comparator.comparingInt(activity -> activity.start));
        List<Activity> activityList = new ArrayList<>();
        int[] cameronSchedule = new int[1440];
        int[] jamieSchedule = new int[1440];

        for (int i = 0; i < activityCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Activity activity = new Activity(start, end);
            activityList.add(activity);
            activityQueue.add(activity);
        }

        boolean isImpossible = false;
        while (!activityQueue.isEmpty()) {
            Activity currentActivity = activityQueue.poll();

            if (isImpossible) {
                continue;
            }

            if (isSlotAvailable(currentActivity, cameronSchedule)) {
                currentActivity.owner = "C";
            } else if (isSlotAvailable(currentActivity, jamieSchedule)) {
                currentActivity.owner = "J";
            } else {
                isImpossible = true;
            }
        }

        if (isImpossible) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else {
            StringBuilder result = new StringBuilder();
            for (Activity activity : activityList) {
                result.append(activity.owner);
            }
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }

    private static boolean isSlotAvailable(Activity activity, int[] schedule) {
        for (int i = activity.start; i < activity.end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }

        for (int i = activity.start; i < activity.end; i++) {
            schedule[i] = 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            solve(caseNumber, scanner, activityCount);
        }
    }

    public static class Activity {
        int start;
        int end;
        String owner;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}