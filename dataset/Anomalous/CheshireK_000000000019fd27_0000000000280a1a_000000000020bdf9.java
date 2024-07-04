import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static boolean isCompatible(List<int[]> currentTimestamps, int[] newTimestamp) {
        for (int[] timestamp : currentTimestamps) {
            int start = newTimestamp[0];
            int end = newTimestamp[1];
            if ((start >= timestamp[0] && start >= timestamp[1]) || (start <= timestamp[0] && start <= timestamp[1])) {
                // No overlap on start
            } else {
                return false;
            }
            if (start == timestamp[0] && end == timestamp[1]) {
                return false;
            }
            if ((end >= timestamp[0] && end >= timestamp[1]) || (end <= timestamp[0] && end <= timestamp[1])) {
                // No overlap on end
            } else {
                return false;
            }
        }
        return true;
    }

    public static String solve(List<int[]> activityList) {
        int freeJamie = 24 * 60;
        int freeCameron = 24 * 60;
        List<int[]> Jamie = new ArrayList<>();
        List<int[]> Cameron = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();
        boolean isImpossible = false;

        for (int[] timestamp : activityList) {
            if (isCompatible(Jamie, timestamp)) {
                Jamie.add(timestamp);
                freeJamie -= timestamp[1] - timestamp[0];
                schedule.append("C");
            } else if (isCompatible(Cameron, timestamp)) {
                Cameron.add(timestamp);
                freeCameron -= timestamp[1] - timestamp[0];
                schedule.append("J");
            } else {
                isImpossible = true;
            }
        }

        if (freeCameron < 0 || freeJamie < 0) {
            isImpossible = true;
        }

        return isImpossible ? "IMPOSSIBLE" : schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            List<int[]> activityList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int[] activity = new int[2];
                activity[0] = scanner.nextInt();
                activity[1] = scanner.nextInt();
                activityList.add(activity);
            }
            System.out.println("Case #" + i + ": " + solve(activityList));
        }
        scanner.close();
    }
}