import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] parts = br.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(parts[0]);
                intervals[i][1] = Integer.parseInt(parts[1]);
            }

            String result = findSchedule(intervals, new HashSet<>(), new HashSet<>(), 0, "");
            if (result.length() != n) {
                result = "IMPOSSIBLE";
            }

            System.out.format("Case #%d: %s", t, result);
            if (t < T) {
                System.out.println();
            }
        }
        br.close();
    }

    private static String findSchedule(int[][] intervals, HashSet<int[]> cSchedule, HashSet<int[]> jSchedule, int index, String currentSchedule) {
        if (index == intervals.length) {
            return currentSchedule;
        }

        if (isAvailable(cSchedule, intervals[index])) {
            cSchedule.add(intervals[index]);
            String schedule = findSchedule(intervals, cSchedule, jSchedule, index + 1, currentSchedule + 'C');
            cSchedule.remove(intervals[index]);
            if (schedule.length() == intervals.length) {
                return schedule;
            }
        }

        if (isAvailable(jSchedule, intervals[index])) {
            jSchedule.add(intervals[index]);
            String schedule = findSchedule(intervals, cSchedule, jSchedule, index + 1, currentSchedule + 'J');
            jSchedule.remove(intervals[index]);
            if (schedule.length() == intervals.length) {
                return schedule;
            }
        }

        return "";
    }

    private static boolean isAvailable(HashSet<int[]> schedule, int[] interval) {
        int start = interval[0];
        int end = interval[1];

        for (int[] scheduledInterval : schedule) {
            if (start < scheduledInterval[1] && end > scheduledInterval[0]) {
                return false;
            }
        }

        return true;
    }
}