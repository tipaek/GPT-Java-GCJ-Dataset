import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static boolean isCompatible(List<Integer[]> currentSchedule, Integer[] newInterval) {
        for (Integer[] interval : currentSchedule) {
            int start = newInterval[0];
            int end = newInterval[1];
            int intervalStart = interval[0];
            int intervalEnd = interval[1];

            if ((start >= intervalStart && start < intervalEnd) ||
                (end > intervalStart && end <= intervalEnd) ||
                (start <= intervalStart && end >= intervalEnd)) {
                return false;
            }
        }
        return true;
    }

    public static String scheduleActivities(List<Integer[]> activities) {
        int availableJamie = 24 * 60;
        int availableCameron = 24 * 60;
        List<Integer[]> scheduleJamie = new ArrayList<>();
        List<Integer[]> scheduleCameron = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (Integer[] activity : activities) {
            if (isCompatible(scheduleJamie, activity)) {
                scheduleJamie.add(activity);
                availableJamie -= (activity[1] - activity[0]);
                result.append("C");
            } else if (isCompatible(scheduleCameron, activity)) {
                scheduleCameron.add(activity);
                availableCameron -= (activity[1] - activity[0]);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        if (availableJamie < 0 || availableCameron < 0) {
            return "IMPOSSIBLE";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            List<Integer[]> activities = new ArrayList<>();

            for (int j = 0; j < activityCount; j++) {
                Integer[] activity = new Integer[2];
                activity[0] = scanner.nextInt();
                activity[1] = scanner.nextInt();
                activities.add(activity);
            }

            String result = scheduleActivities(activities);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }
}