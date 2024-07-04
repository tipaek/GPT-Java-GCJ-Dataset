import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            Integer[][] intervals = new Integer[n][2];
            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }
            String result = assignActivities(intervals);
            System.out.printf("Case #%d: %s", t, result);
            if (t < testCases) {
                System.out.println();
            }
        }
        reader.close();
    }

    public static String assignActivities(Integer[][] intervals) {
        StringBuilder schedule = new StringBuilder();
        ArrayList<Integer[]> cActivities = new ArrayList<>();
        ArrayList<Integer[]> jActivities = new ArrayList<>();

        for (Integer[] interval : intervals) {
            if (canSchedule(cActivities, interval[0], interval[1])) {
                schedule.append('C');
            } else if (canSchedule(jActivities, interval[0], interval[1])) {
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    public static boolean canSchedule(ArrayList<Integer[]> activities, int start, int end) {
        for (int i = 0; i < activities.size(); i++) {
            Integer[] currentActivity = activities.get(i);
            if (end <= currentActivity[0]) {
                activities.add(i, new Integer[]{start, end});
                return true;
            } else if (start >= currentActivity[1]) {
                continue;
            } else {
                return false;
            }
        }
        activities.add(new Integer[]{start, end});
        return true;
    }
}