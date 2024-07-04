import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static class Activity {
        int startTime;
        int endTime;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTestCases = scanner.nextInt();

        for (int i = 0; i < totalTestCases; i++) {
            int n = scanner.nextInt();
            LinkedList<Activity> james = new LinkedList<>();
            LinkedList<Activity> cameron = new LinkedList<>();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity activity = new Activity(startTime, endTime);

                if (canAddActivity(james, activity)) {
                    result.append("J");
                    james.add(activity);
                } else if (canAddActivity(cameron, activity)) {
                    result.append("C");
                    cameron.add(activity);
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.printf("Case #%d: %s%n", i + 1, result);
        }
    }

    private static boolean canAddActivity(LinkedList<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if (!(newActivity.endTime <= activity.startTime || newActivity.startTime >= activity.endTime)) {
                return false;
            }
        }
        return true;
    }
}