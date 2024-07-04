import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static boolean isCompatible(List<Integer[]> currentTimestamps, Integer[] newTimestamp) {
        for (Integer[] timestamp : currentTimestamps) {
            int start = newTimestamp[0];
            int end = newTimestamp[1];
            int tsStart = timestamp[0];
            int tsEnd = timestamp[1];

            if ((start >= tsStart && start < tsEnd) || (end > tsStart && end <= tsEnd) || 
                (start <= tsStart && end >= tsEnd)) {
                return false;
            }
        }
        return true;
    }

    public static String solve(List<Integer[]> activityList) {
        int freeJamie = 24 * 60;
        int freeCameron = 24 * 60;
        List<Integer[]> jamieActivities = new ArrayList<>();
        List<Integer[]> cameronActivities = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();
        boolean impossible = false;

        for (Integer[] activity : activityList) {
            if (isCompatible(jamieActivities, activity)) {
                jamieActivities.add(activity);
                freeJamie -= activity[1] - activity[0];
                schedule.append("J");
            } else if (isCompatible(cameronActivities, activity)) {
                cameronActivities.add(activity);
                freeCameron -= activity[1] - activity[0];
                schedule.append("C");
            } else {
                impossible = true;
                break;
            }
        }

        if (freeJamie < 0 || freeCameron < 0) {
            impossible = true;
        }

        return impossible ? "IMPOSSIBLE" : schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            List<Integer[]> activityList = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                Integer[] activity = new Integer[2];
                activity[0] = scanner.nextInt();
                activity[1] = scanner.nextInt();
                activityList.add(activity);
            }

            System.out.println("Case #" + i + ": " + solve(activityList));
        }

        scanner.close();
    }
}