import java.util.Scanner;

public class Solution {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        int[][] originalIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            originalIntervals[i][0] = intervals[i][0];
            originalIntervals[i][1] = intervals[i][1];
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] cEnd = new int[n];
        int[] jEnd = new int[n];
        StringBuilder schedule = new StringBuilder();
        int cCount = 0, jCount = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (canAssign(cEnd, cCount, start, end)) {
                cEnd[cCount++] = end;
                schedule.append("J");
            } else if (canAssign(jEnd, jCount, start, end)) {
                jEnd[jCount++] = end;
                schedule.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return reconstructSchedule(originalIntervals, intervals, schedule.toString());
    }

    private static boolean canAssign(int[] endTimes, int count, int start, int end) {
        for (int i = 0; i < count; i++) {
            if (start < endTimes[i] && end > endTimes[i]) {
                return false;
            }
        }
        return true;
    }

    private static String reconstructSchedule(int[][] originalIntervals, int[][] sortedIntervals, String schedule) {
        StringBuilder result = new StringBuilder();

        for (int[] original : originalIntervals) {
            for (int j = 0; j < n; j++) {
                if (original[0] == sortedIntervals[j][0] && original[1] == sortedIntervals[j][1]) {
                    result.append(schedule.charAt(j));
                    break;
                }
            }
        }

        return result.toString();
    }
}