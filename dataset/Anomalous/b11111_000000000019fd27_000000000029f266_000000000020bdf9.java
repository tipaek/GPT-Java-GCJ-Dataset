import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(in.nextLine());
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                String[] input = in.nextLine().split(" ");
                intervals[j][0] = Integer.parseInt(input[0]);
                intervals[j][1] = Integer.parseInt(input[1]);
            }
            int[][] sortedIntervals = sortIntervals(intervals, n);
            String result = findSchedule(sortedIntervals, n);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static int[][] sortIntervals(int[][] intervals, int n) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        return intervals;
    }

    private static String findSchedule(int[][] intervals, int n) {
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