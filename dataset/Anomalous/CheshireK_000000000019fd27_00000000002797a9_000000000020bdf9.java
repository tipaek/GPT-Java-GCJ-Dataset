import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static boolean canSchedule(List<Integer[]> existingSchedules, Integer[] newSchedule) {
        for (Integer[] schedule : existingSchedules) {
            if (!(newSchedule[1] <= schedule[0] || newSchedule[0] >= schedule[1])) {
                return false;
            }
        }
        return true;
    }

    public static String allocateSchedules(List<Integer[]> activities) {
        int totalMinutesInDay = 24 * 60;
        int freeTimeJamie = totalMinutesInDay;
        int freeTimeCameron = totalMinutesInDay;
        List<Integer[]> jamieSchedules = new ArrayList<>();
        List<Integer[]> cameronSchedules = new ArrayList<>();
        StringBuilder scheduleResult = new StringBuilder();
        boolean isImpossible = false;

        for (Integer[] activity : activities) {
            if (canSchedule(jamieSchedules, activity)) {
                jamieSchedules.add(activity);
                freeTimeJamie -= (activity[1] - activity[0]);
                scheduleResult.append("J");
            } else if (canSchedule(cameronSchedules, activity)) {
                cameronSchedules.add(activity);
                freeTimeCameron -= (activity[1] - activity[0]);
                scheduleResult.append("C");
            } else {
                isImpossible = true;
            }
        }

        if (freeTimeJamie < 0 || freeTimeCameron < 0) {
            isImpossible = true;
        }

        return isImpossible ? "IMPOSSIBLE" : scheduleResult.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Integer[]> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Integer[] activity = new Integer[2];
                activity[0] = scanner.nextInt();
                activity[1] = scanner.nextInt();
                activities.add(activity);
            }

            System.out.println("Case #" + t + ": " + allocateSchedules(activities));
        }
    }
}