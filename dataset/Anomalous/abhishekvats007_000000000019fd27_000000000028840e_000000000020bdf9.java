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
            LinkedList<Activity> jamesActivities = new LinkedList<>();
            LinkedList<Activity> cameronActivities = new LinkedList<>();
            int n = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();

            jamesActivities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            schedule.append("J");

            for (byte j = 1; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity currentActivity = new Activity(startTime, endTime);
                boolean assigned = false;

                // Try to assign to James
                for (Activity activity : jamesActivities) {
                    if (endTime <= activity.startTime || activity.endTime <= startTime) {
                        jamesActivities.add(currentActivity);
                        schedule.append("J");
                        assigned = true;
                        break;
                    }
                }

                // If not assigned, try to assign to Cameron
                if (!assigned) {
                    if (cameronActivities.isEmpty()) {
                        cameronActivities.add(currentActivity);
                        schedule.append("C");
                        assigned = true;
                    } else {
                        for (Activity activity : cameronActivities) {
                            if (endTime <= activity.startTime || activity.endTime <= startTime) {
                                cameronActivities.add(currentActivity);
                                schedule.append("C");
                                assigned = true;
                                break;
                            }
                        }
                    }
                }

                // If still not assigned, it's impossible
                if (!assigned) {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.printf("Case #%d: %s %n", i + 1, schedule);
        }
        scanner.close();
    }
}