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

        for (byte i = 0; i < totalTestCases; i++) {
            LinkedList<Activity> james = new LinkedList<>();
            LinkedList<Activity> cameron = new LinkedList<>();
            int n = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            james.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            stringBuilder.append("J");

            for (byte j = 1; j < n; j++) {
                boolean assigned = false;
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity activity = new Activity(startTime, endTime);

                if (canAssignActivity(james, activity)) {
                    james.add(activity);
                    stringBuilder.append("J");
                    assigned = true;
                } else if (canAssignActivity(cameron, activity)) {
                    cameron.add(activity);
                    stringBuilder.append("C");
                    assigned = true;
                }

                if (!assigned) {
                    stringBuilder = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.printf("Case #%d: %s%n", i + 1, stringBuilder);
        }
    }

    private static boolean canAssignActivity(LinkedList<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if (!(newActivity.endTime <= activity.startTime || newActivity.startTime >= activity.endTime)) {
                return false;
            }
        }
        return true;
    }
}