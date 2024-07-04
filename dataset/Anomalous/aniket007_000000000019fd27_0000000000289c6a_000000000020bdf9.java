import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
            }

            String result = assignActivities(intervals, n);

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignActivities(int[][] intervals, int n) {
        int[] cEnd = new int[n];
        int[] jEnd = new int[n];
        StringBuilder schedule = new StringBuilder();
        int cCount = 0, jCount = 0;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (canAssignActivity(cEnd, cCount, start, end)) {
                cEnd[cCount++] = end;
                schedule.append("C");
            } else if (canAssignActivity(jEnd, jCount, start, end)) {
                jEnd[jCount++] = end;
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean canAssignActivity(int[] endTimes, int count, int start, int end) {
        for (int i = 0; i < count; i++) {
            if (start < endTimes[i]) {
                return false;
            }
        }
        return true;
    }
}