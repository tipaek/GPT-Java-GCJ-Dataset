import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }
            String result = assignActivities(activities);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignActivities(List<int[]> activities) {
        boolean[] jSchedule = new boolean[1440];
        boolean[] cSchedule = new boolean[1440];
        StringBuilder result = new StringBuilder();

        for (int[] activity : activities) {
            if (canFit(jSchedule, activity)) {
                blockTime(jSchedule, activity);
                result.append('J');
            } else if (canFit(cSchedule, activity)) {
                blockTime(cSchedule, activity);
                result.append('C');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean canFit(boolean[] schedule, int[] activity) {
        for (int i = activity[0]; i < activity[1]; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void blockTime(boolean[] schedule, int[] activity) {
        for (int i = activity[0]; i < activity[1]; i++) {
            schedule[i] = true;
        }
    }
}