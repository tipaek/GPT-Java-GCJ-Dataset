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
                String[] parts = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(parts[0]);
                intervals[i][1] = Integer.parseInt(parts[1]);
            }

            String result = findSchedule(intervals, new ArrayList<>(), new ArrayList<>(), 0, "");
            if (result.length() != intervals.length) {
                result = "IMPOSSIBLE";
            }
            System.out.format("Case #%d: %s", t, result);
            if (t < testCases) {
                System.out.println();
            }
        }
        reader.close();
    }

    private static String findSchedule(Integer[][] intervals, ArrayList<Integer[]> cList, ArrayList<Integer[]> jList, int index, String schedule) {
        if (index == intervals.length) {
            return schedule;
        }

        if (isValid(cList, intervals[index])) {
            ArrayList<Integer[]> newCList = new ArrayList<>(cList);
            newCList.add(new Integer[]{intervals[index][0], intervals[index][1]});
            String result = findSchedule(intervals, newCList, jList, index + 1, schedule + 'C');
            if (result.length() == intervals.length) {
                return result;
            }
        }

        if (isValid(jList, intervals[index])) {
            ArrayList<Integer[]> newJList = new ArrayList<>(jList);
            newJList.add(new Integer[]{intervals[index][0], intervals[index][1]});
            String result = findSchedule(intervals, cList, newJList, index + 1, schedule + 'J');
            if (result.length() == intervals.length) {
                return result;
            }
        }

        return "";
    }

    private static boolean isValid(ArrayList<Integer[]> list, Integer[] interval) {
        int start = interval[0];
        int end = interval[1];

        for (Integer[] existing : list) {
            if (!(start >= existing[1] || end <= existing[0])) {
                return false;
            }
        }

        return true;
    }
}