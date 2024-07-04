import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            Map<Integer, Boolean> assigned = new HashMap<>();
            Map<Integer, String> schedule = new LinkedHashMap<>();
            int remainingTasks = n;

            for (int j = 0; j < n; j++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[j][0] = Integer.parseInt(input[0]);
                intervals[j][1] = Integer.parseInt(input[1]);
                assigned.put(j, false);
                schedule.put(j, "");
            }

            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];

            for (int j = 0; j < n; j++) {
                if (assignTask(intervals[j], cameronSchedule)) {
                    assigned.put(j, true);
                    schedule.put(j, "C");
                    remainingTasks--;
                }
            }

            for (int j = 0; j < n; j++) {
                if (assigned.get(j)) continue;
                if (assignTask(intervals[j], jamieSchedule)) {
                    assigned.put(j, true);
                    schedule.put(j, "J");
                    remainingTasks--;
                }
            }

            String result = remainingTasks == 0 ? buildSchedule(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean assignTask(int[] interval, int[] schedule) {
        for (int k = interval[0] + 1; k <= interval[1]; k++) {
            if (schedule[k] == 1) {
                return false;
            }
        }
        for (int k = interval[0] + 1; k <= interval[1]; k++) {
            schedule[k] = 1;
        }
        return true;
    }

    private static String buildSchedule(Map<Integer, String> schedule) {
        StringBuilder result = new StringBuilder();
        for (String value : schedule.values()) {
            result.append(value);
        }
        return result.toString();
    }
}