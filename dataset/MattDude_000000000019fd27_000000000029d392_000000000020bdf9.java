import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
   public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            for (int ints = 0; ints < n; ints++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals[ints][0] = start;
                intervals[ints][1] = end;
            }
            System.out.println(String.format("Case #%d: %s", i, getSchedule(intervals)));
        }
    }

    private static String getSchedule(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        StringBuilder schedule = new StringBuilder();
        schedule.append("C");
        int maxEnd = intervals[0][1];
        int overlaps = 0;
        String currentParent = "C";
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                overlaps++;
                if (overlaps > 1) return "IMPOSSIBLE";
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
                maxEnd = Math.max(intervals[i][1], maxEnd);
                currentParent = currentParent.equalsIgnoreCase("C") ? "J" : "C";
            } else {
                if (intervals[i][0] >= maxEnd) {
                    overlaps = 0;
                    currentParent = "C";
                    maxEnd = intervals[i][1];
                }
                intervals[i][1] = maxEnd;
            }
            schedule.append(currentParent);
        }
        return schedule.toString();
    }


}