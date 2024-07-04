import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                intervals[j][2] = j;
            }

            System.out.println("Case #" + testCase + ": " + assignTasks(intervals, n));
        }
    }

    private static void sortIntervalsByStartTime(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
    }

    private static String assignTasks(int[][] intervals, int n) {
        int cEnd = 0, jEnd = 0;
        sortIntervalsByStartTime(intervals);

        StringBuilder taskAssignment = new StringBuilder();
        taskAssignment.append('C');
        cEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= cEnd) {
                taskAssignment.append('C');
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                taskAssignment.append('J');
                jEnd = intervals[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[intervals[i][2]] = taskAssignment.charAt(i);
        }

        return new String(result);
    }
}