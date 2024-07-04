import java.util.ArrayList;
import java.util.List;
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
            List<Activity> james = new ArrayList<>();
            List<Activity> cameron = new ArrayList<>();
            int n = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            james.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            schedule.append("J");

            for (int j = 1; j < n; j++) {
                boolean assigned = false;
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity newActivity = new Activity(startTime, endTime);

                if (canAssign(james, newActivity)) {
                    james.add(newActivity);
                    schedule.append("J");
                    assigned = true;
                } else if (canAssign(cameron, newActivity)) {
                    cameron.add(newActivity);
                    schedule.append("C");
                    assigned = true;
                }

                if (!assigned) {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.printf("Case #%d: %s%n", i + 1, schedule);
        }
    }

    private static boolean canAssign(List<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if (!(newActivity.endTime <= activity.startTime || newActivity.startTime >= activity.endTime)) {
                return false;
            }
        }
        return true;
    }
}