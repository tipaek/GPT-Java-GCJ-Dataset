import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            Integer[][] intervals = new Integer[n][2];
            
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }

            String result = findSchedule(intervals, new ArrayList<>(), new ArrayList<>(), 0, "");
            if (result.length() != intervals.length) {
                result = "IMPOSSIBLE";
            }
            
            System.out.format("Case #%d: %s", t, result);
            if (t < T) System.out.println();
        }
        br.close();
    }

    public static String findSchedule(Integer[][] intervals, ArrayList<Integer[]> cSchedule, ArrayList<Integer[]> jSchedule, int index, String currentSchedule) {
        if (index == intervals.length) {
            return currentSchedule;
        }

        if (isValid(cSchedule, intervals[index])) {
            Integer[] currentInterval = {intervals[index][0], intervals[index][1]};
            cSchedule.add(currentInterval);
            String schedule = findSchedule(intervals, cSchedule, jSchedule, index + 1, currentSchedule + 'C');
            cSchedule.remove(cSchedule.size() - 1);
            if (schedule.length() == intervals.length) return schedule;
        }

        if (isValid(jSchedule, intervals[index])) {
            Integer[] currentInterval = {intervals[index][0], intervals[index][1]};
            jSchedule.add(currentInterval);
            String schedule = findSchedule(intervals, cSchedule, jSchedule, index + 1, currentSchedule + 'J');
            jSchedule.remove(jSchedule.size() - 1);
            if (schedule.length() == intervals.length) return schedule;
        }

        return "";
    }

    public static boolean isValid(ArrayList<Integer[]> schedule, Integer[] interval) {
        int start = interval[0];
        int end = interval[1];

        for (Integer[] scheduledInterval : schedule) {
            if (start < scheduledInterval[1] && end > scheduledInterval[0]) {
                return false;
            }
        }

        return true;
    }
}