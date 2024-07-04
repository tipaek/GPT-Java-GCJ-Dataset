import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new int[]{start, end});
            }

            String result = assignActivities(intervals);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignActivities(List<int[]> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a[0]));

        int cEndTime = 0;
        int jEndTime = 0;
        StringBuilder schedule = new StringBuilder();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start >= cEndTime) {
                schedule.append("C");
                cEndTime = end;
            } else if (start >= jEndTime) {
                schedule.append("J");
                jEndTime = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}