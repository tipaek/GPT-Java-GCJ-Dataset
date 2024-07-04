import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            solve(activities, caseNum);
        }
    }

    private static List<int[]> scheduleJ = new ArrayList<>();
    private static List<int[]> scheduleC = new ArrayList<>();

    private static void solve(int[][] activities, int caseNum) {
        scheduleJ.clear();
        scheduleC.clear();
        StringBuilder result = new StringBuilder();
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            if (canSchedule(activity, start, end, scheduleJ)) {
                result.append("J");
            } else if (canSchedule(activity, start, end, scheduleC)) {
                result.append("C");
            } else {
                result.setLength(0); // Reset the result
                result.append("IMPOSSIBLE");
                break;
            }
        }
        System.out.println("Case #" + caseNum + ": " + result.toString());
    }

    private static boolean canSchedule(int[] activity, int start, int end, List<int[]> schedule) {
        if (schedule.isEmpty()) {
            schedule.add(activity);
            return true;
        }
        for (int i = 0; i < schedule.size(); i++) {
            int[] current = schedule.get(i);
            if (end <= current[0]) {
                schedule.add(i, activity);
                return true;
            } else if (start >= current[1]) {
                if (i == schedule.size() - 1 || end <= schedule.get(i + 1)[0]) {
                    schedule.add(i + 1, activity);
                    return true;
                }
            }
        }
        return false;
    }
}