import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] parts = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(parts[0]);
                intervals[i][1] = Integer.parseInt(parts[1]);
            }

            int[][] sortedIntervals = sortIntervals(intervals, n);
            String scheduleResult = generateSchedule(sortedIntervals, n);
            System.out.println("Case #" + testCase + ": " + scheduleResult);
        }
    }

    private static int[][] sortIntervals(int[][] intervals, int n) {
        int[][] sortedIntervals = Arrays.copyOf(intervals, n);
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        return sortedIntervals;
    }

    private static String generateSchedule(int[][] intervals, int n) {
        int cEnd = 0;
        int jEnd = 0;
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= cEnd) {
                cEnd = intervals[i][1];
                schedule.append("C");
            } else if (intervals[i][0] >= jEnd) {
                jEnd = intervals[i][1];
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}