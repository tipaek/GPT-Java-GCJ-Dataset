import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];

            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            int[] originalOrder = sortActivitiesAndTrackOrder(activities);

            int cEndTime = 0;
            int jEndTime = 0;
            boolean conflict = false;
            String[] schedule = new String[activitiesCount];

            for (int i = 0; i < activitiesCount; i++) {
                if (cEndTime <= activities[i][0]) {
                    schedule[originalOrder[i]] = "C";
                    cEndTime = activities[i][1];
                } else if (jEndTime <= activities[i][0]) {
                    schedule[originalOrder[i]] = "J";
                    jEndTime = activities[i][1];
                } else {
                    conflict = true;
                    break;
                }
            }

            String result = conflict ? "IMPOSSIBLE" : String.join("", schedule);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static int[] sortActivitiesAndTrackOrder(int[][] activities) {
        int length = activities.length;
        int[] orderTracker = new int[length];
        for (int i = 0; i < length; i++) {
            orderTracker[i] = i;
        }

        for (int i = 1; i < length; i++) {
            int[] currentActivity = activities[i];
            int currentOrder = orderTracker[i];
            int j = i - 1;

            while (j >= 0 && activities[j][0] > currentActivity[0]) {
                activities[j + 1] = activities[j];
                orderTracker[j + 1] = orderTracker[j];
                j--;
            }

            activities[j + 1] = currentActivity;
            orderTracker[j + 1] = currentOrder;
        }

        return orderTracker;
    }
}