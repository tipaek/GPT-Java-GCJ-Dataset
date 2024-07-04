import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Parenting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }

            String result = findSchedule(intervals, new ArrayList<>(), new ArrayList<>(), 0, "");
            if (result.length() != n) {
                result = "IMPOSSIBLE";
            }
            System.out.printf("Case #%d: %s%n", t, result);
        }
        br.close();
    }

    public static String findSchedule(int[][] intervals, ArrayList<int[]> cSchedule, ArrayList<int[]> jSchedule, int index, String currentResult) {
        if (index == intervals.length) {
            return currentResult;
        }

        if (isValid(cSchedule, intervals[index])) {
            ArrayList<int[]> newCSchedule = new ArrayList<>(cSchedule);
            newCSchedule.add(intervals[index]);
            String result = findSchedule(intervals, newCSchedule, jSchedule, index + 1, currentResult + 'C');
            if (result.length() == intervals.length) {
                return result;
            }
        }

        if (isValid(jSchedule, intervals[index])) {
            ArrayList<int[]> newJSchedule = new ArrayList<>(jSchedule);
            newJSchedule.add(intervals[index]);
            String result = findSchedule(intervals, cSchedule, newJSchedule, index + 1, currentResult + 'J');
            if (result.length() == intervals.length) {
                return result;
            }
        }

        return "";
    }

    public static boolean isValid(ArrayList<int[]> schedule, int[] interval) {
        for (int[] scheduledInterval : schedule) {
            if (!(interval[1] <= scheduledInterval[0] || interval[0] >= scheduledInterval[1])) {
                return false;
            }
        }
        return true;
    }
}