import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

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

            String[] memo = new String[n];
            Arrays.fill(memo, "");
            String result = scheduleTasks(intervals, new ArrayList<>(), new ArrayList<>(), 0, "", memo);

            if (result.length() != n) {
                result = "IMPOSSIBLE";
            }

            System.out.format("Case #%d: %s", t, result);
            if (t < T) System.out.println();
        }
        br.close();
    }

    public static String scheduleTasks(Integer[][] intervals, ArrayList<Integer[]> cTasks, ArrayList<Integer[]> jTasks, int index, String schedule, String[] memo) {
        if (index == intervals.length) {
            return schedule;
        }

        if (!memo[index].isEmpty()) {
            return memo[index];
        }

        if (isValid(cTasks, intervals[index])) {
            ArrayList<Integer[]> newCTasks = new ArrayList<>(cTasks);
            newCTasks.add(intervals[index]);
            String result = scheduleTasks(intervals, newCTasks, jTasks, index + 1, schedule + 'C', memo);
            if (result.length() == intervals.length) {
                memo[index] = result;
                return result;
            }
        }

        if (isValid(jTasks, intervals[index])) {
            ArrayList<Integer[]> newJTasks = new ArrayList<>(jTasks);
            newJTasks.add(intervals[index]);
            String result = scheduleTasks(intervals, cTasks, newJTasks, index + 1, schedule + 'J', memo);
            if (result.length() == intervals.length) {
                memo[index] = result;
                return result;
            }
        }

        return "";
    }

    public static boolean isValid(ArrayList<Integer[]> tasks, Integer[] interval) {
        int start = interval[0];
        int end = interval[1];

        for (Integer[] task : tasks) {
            if (start < task[1] && end > task[0]) {
                return false;
            }
        }
        return true;
    }
}