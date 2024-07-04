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

            String[] dp = new String[n];
            Arrays.fill(dp, "");
            String result = findSchedule(intervals, new ArrayList<>(), new ArrayList<>(), 0, "", dp);

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

    public static String findSchedule(Integer[][] intervals, ArrayList<Integer[]> cameron, ArrayList<Integer[]> jamie, int index, String schedule, String[] dp) {
        if (index == intervals.length) {
            return schedule;
        }

        if (!dp[index].isEmpty()) {
            return dp[index];
        }

        ArrayList<Integer[]> cameronCopy = new ArrayList<>(cameron);
        if (isValid(cameronCopy, intervals[index])) {
            String result = findSchedule(intervals, cameronCopy, jamie, index + 1, schedule + 'C', dp);
            if (result.length() == intervals.length) {
                dp[index] = result;
                return dp[index];
            }
        }

        ArrayList<Integer[]> jamieCopy = new ArrayList<>(jamie);
        if (isValid(jamieCopy, intervals[index])) {
            String result = findSchedule(intervals, cameron, jamieCopy, index + 1, schedule + 'J', dp);
            if (result.length() == intervals.length) {
                dp[index] = result;
                return dp[index];
            }
        }

        return "";
    }

    public static boolean isValid(ArrayList<Integer[]> list, Integer[] interval) {
        int start = interval[0];
        int end = interval[1];

        if (list.isEmpty() || list.get(list.size() - 1)[1] <= start) {
            list.add(new Integer[]{start, end});
            return true;
        }

        for (int i = 0; i < list.size(); i++) {
            Integer[] current = list.get(i);
            if (end <= current[0]) {
                list.add(i, new Integer[]{start, end});
                return true;
            } else if (start >= current[1]) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}