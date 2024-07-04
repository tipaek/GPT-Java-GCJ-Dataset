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

        byte totalTestCases = scanner.nextByte();

        for (int i = 0; i < totalTestCases; i++) {
            LinkedList<Activity> james = new LinkedList<>();
            LinkedList<Activity> cameron = new LinkedList<>();
            int n = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity activity = new Activity(startTime, endTime);

                boolean assigned = assignActivity(james, cameron, stringBuilder, activity);

                if (!assigned) {
                    stringBuilder = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.printf("Case #%d: %s%n", i + 1, stringBuilder);
        }
    }

    private static boolean assignActivity(LinkedList<Activity> james, LinkedList<Activity> cameron, StringBuilder stringBuilder, Activity activity) {
        if (canAssign(james, activity)) {
            stringBuilder.append("J");
            james.add(activity);
            return true;
        } else if (canAssign(cameron, activity)) {
            stringBuilder.append("C");
            cameron.add(activity);
            return true;
        }
        return false;
    }

    private static boolean canAssign(LinkedList<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if (!(newActivity.endTime <= activity.startTime || newActivity.startTime >= activity.endTime)) {
                return false;
            }
        }
        return true;
    }
}