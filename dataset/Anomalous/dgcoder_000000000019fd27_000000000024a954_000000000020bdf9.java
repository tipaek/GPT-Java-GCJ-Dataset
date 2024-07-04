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

            String result = determineSchedule(intervals);
            System.out.printf("Case #%d: %s", t, result);
            if (t < T) {
                System.out.println();
            }
        }
        br.close();
    }

    public static String determineSchedule(Integer[][] intervals) {
        StringBuilder schedule = new StringBuilder();
        ArrayList<Integer[]> cSchedule = new ArrayList<>();
        ArrayList<Integer[]> jSchedule = new ArrayList<>();

        for (Integer[] interval : intervals) {
            if (canSchedule(cSchedule, interval[0], interval[1])) {
                schedule.append('C');
            } else if (canSchedule(jSchedule, interval[0], interval[1])) {
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.length() == intervals.length ? schedule.toString() : "IMPOSSIBLE";
    }

    public static boolean canSchedule(ArrayList<Integer[]> schedule, int start, int end) {
        for (int i = 0; i < schedule.size(); i++) {
            Integer[] existingInterval = schedule.get(i);
            if (end <= existingInterval[0]) {
                schedule.add(i, new Integer[]{start, end});
                return true;
            } else if (start >= existingInterval[1]) {
                continue;
            } else {
                return false;
            }
        }
        schedule.add(new Integer[]{start, end});
        return true;
    }
}