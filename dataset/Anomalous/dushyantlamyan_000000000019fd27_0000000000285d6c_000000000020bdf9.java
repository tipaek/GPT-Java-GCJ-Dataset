import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        int cEnd = 0, jEnd = 0;
        char[] assignments = new char[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= cEnd) {
                assignments[i] = 'C';
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                assignments[i] = 'J';
                jEnd = intervals[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }
}