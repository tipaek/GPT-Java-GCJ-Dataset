import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static boolean isCompatible(List<int[]> currentTimestamps, int[] newTimestamp) {
        for (int[] timestamp : currentTimestamps) {
            int start = newTimestamp[0];
            int end = newTimestamp[1];
            if (!((start >= timestamp[1] || end <= timestamp[0]))) {
                return false;
            }
        }
        return true;
    }

    public static String solve(List<int[]> activities) {
        int freeTimeJamie = 24 * 60;
        int freeTimeCameron = 24 * 60;
        List<int[]> scheduleJamie = new ArrayList<>();
        List<int[]> scheduleCameron = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;

        for (int[] activity : activities) {
            if (isCompatible(scheduleJamie, activity)) {
                scheduleJamie.add(activity);
                freeTimeJamie -= activity[1] - activity[0];
                result.append("C");
            } else if (isCompatible(scheduleCameron, activity)) {
                scheduleCameron.add(activity);
                freeTimeCameron -= activity[1] - activity[0];
                result.append("J");
            } else {
                isImpossible = true;
                break;
            }
        }

        return isImpossible ? "IMPOSSIBLE" : result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int[] activity = new int[2];
                activity[0] = scanner.nextInt();
                activity[1] = scanner.nextInt();
                activities.add(activity);
            }
            System.out.println("Case #" + i + ": " + solve(activities));
        }
        scanner.close();
    }
}