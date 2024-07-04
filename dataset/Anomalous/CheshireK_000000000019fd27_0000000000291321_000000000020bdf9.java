import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static boolean isCompatible(List<Integer[]> currentTimestamps, Integer[] newTimestamp) {
        for (Integer[] timestamp : currentTimestamps) {
            Integer start = newTimestamp[0];
            Integer end = newTimestamp[1];

            if (start.equals(timestamp[0]) || end.equals(timestamp[1]) ||
                (start < timestamp[0] && end > timestamp[1]) ||
                (start > timestamp[0] && end < timestamp[1]) ||
                (start > timestamp[0] && start < timestamp[1] && end > timestamp[1]) ||
                (start < timestamp[0] && end > timestamp[0] && end < timestamp[1])) {
                return false;
            }
        }
        return true;
    }

    public static String scheduleActivities(List<Integer[]> activities) {
        int freeTimeJamie = 24 * 60;
        int freeTimeCameron = 24 * 60;
        List<Integer[]> jamieSchedule = new ArrayList<>();
        List<Integer[]> cameronSchedule = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;

        for (Integer[] activity : activities) {
            if (isCompatible(jamieSchedule, activity)) {
                jamieSchedule.add(activity);
                freeTimeJamie -= activity[1] - activity[0];
                result.append("C");
            } else if (isCompatible(cameronSchedule, activity)) {
                cameronSchedule.add(activity);
                freeTimeCameron -= activity[1] - activity[0];
                result.append("J");
            } else {
                isImpossible = true;
            }
        }

        if (freeTimeJamie < 0 || freeTimeCameron < 0) {
            isImpossible = true;
        }

        return isImpossible ? "IMPOSSIBLE" : result.toString();
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

            System.out.println("Case #" + i + ": " + scheduleActivities(activities));
        }
    }
}