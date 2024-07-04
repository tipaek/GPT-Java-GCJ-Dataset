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
            LinkedList<Activity> jamesActivities = new LinkedList<>();
            LinkedList<Activity> cameronActivities = new LinkedList<>();
            int numActivities = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < numActivities; j++) {
                boolean canAssignToJames = false;
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity newActivity = new Activity(startTime, endTime);

                if (jamesActivities.isEmpty()) {
                    canAssignToJames = true;
                }

                if (canAssignToJames) {
                    result.append("J");
                    jamesActivities.add(newActivity);
                } else {
                    boolean canAssignToCameron = cameronActivities.isEmpty();
                    if (canAssignToCameron) {
                        result.append("C");
                        cameronActivities.add(newActivity);
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }
            System.out.printf("Case #%d: %s %n", i + 1, result);
        }
    }
}