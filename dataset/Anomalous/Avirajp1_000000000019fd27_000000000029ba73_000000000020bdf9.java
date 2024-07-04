import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ts = 1;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
            }

            String result = assignTasks(intervals);
            System.out.printf("Case #%d: %s\n", ts++, result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        int n = intervals.length;
        int[] cSchedule = new int[1000];
        int[] jSchedule = new int[1000];
        int cIndex = 0, jIndex = 0;
        StringBuilder schedule = new StringBuilder("C");

        // Initialize C's schedule with the first task
        for (int time = intervals[0][0]; time < intervals[0][1]; time++) {
            cSchedule[cIndex++] = time;
        }

        for (int i = 1; i < n; i++) {
            int inc = 0, inj = 0;

            // Check if the current task overlaps with C's schedule
            for (int k = 0; k < cIndex; k++) {
                if (intervals[i][0] == cSchedule[k] || intervals[i][1] - 1 == cSchedule[k]) {
                    inc++;
                }
            }

            // Check if the current task overlaps with J's schedule
            for (int k = 0; k < jIndex; k++) {
                if (intervals[i][0] == jSchedule[k] || intervals[i][1] - 1 == jSchedule[k]) {
                    inj++;
                }
            }

            if (inc > 0 && inj == 0) {
                schedule.append('J');
                for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                    jSchedule[jIndex++] = time;
                }
            } else if (inc == 0 && inj > 0) {
                schedule.append('C');
                for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                    cSchedule[cIndex++] = time;
                }
            } else if (inc == 0 && inj == 0) {
                schedule.append('C');
                for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                    cSchedule[cIndex++] = time;
                }
            } else if (inc > 0 && inj > 0) {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}