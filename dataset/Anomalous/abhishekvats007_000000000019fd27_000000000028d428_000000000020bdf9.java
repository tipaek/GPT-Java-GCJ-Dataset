import java.util.LinkedList;
import java.util.Scanner;

public class ParentingPartnering {

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
            StringBuilder schedule = new StringBuilder();

            for (byte j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity activity = new Activity(startTime, endTime);

                if (canAssignActivity(james, activity)) {
                    schedule.append("J");
                    james.add(activity);
                } else if (canAssignActivity(cameron, activity)) {
                    schedule.append("C");
                    cameron.add(activity);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.printf("Case #%d: %s%n", i + 1, schedule);
        }
    }

    private static boolean canAssignActivity(LinkedList<Activity> person, Activity activity) {
        for (Activity existingActivity : person) {
            if (!(activity.endTime <= existingActivity.startTime || existingActivity.endTime <= activity.startTime)) {
                return false;
            }
        }
        return true;
    }
}