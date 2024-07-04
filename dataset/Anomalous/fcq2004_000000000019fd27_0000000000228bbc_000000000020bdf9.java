import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activities = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();
            for (int a = 0; a < activities; a++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new int[]{start, end});
            }
            System.out.println("Case #" + (t + 1) + ": " + assignActivities(intervals));
        }
    }

    private static String assignActivities(List<int[]> intervals) {
        StringBuilder schedule = new StringBuilder("J");
        int cEnd = 0, jEnd = intervals.get(0)[1];
        int lastEnd = jEnd;

        for (int i = 1; i < intervals.size(); i++) {
            int curStart = intervals.get(i)[0];
            int curEnd = intervals.get(i)[1];
            if (curEnd < cEnd) {
                schedule.append("C");
            } else if (curEnd < jEnd) {
                schedule.append("J");
            } else if (curStart < lastEnd) {
                if (cEnd <= curStart) {
                    cEnd = curEnd;
                    schedule.append("C");
                } else if (jEnd <= curStart) {
                    jEnd = curEnd;
                    schedule.append("J");
                } else {
                    return "IMPOSSIBLE";
                }
                lastEnd = Math.max(curEnd, lastEnd);
            } else {
                schedule.append("C");
                cEnd = curEnd;
                lastEnd = curEnd;
            }
        }
        return schedule.toString();
    }
}