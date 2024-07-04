import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int intervalsCount = scanner.nextInt();
            int[][] intervals = new int[intervalsCount][2];
            for (int i = 0; i < intervalsCount; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            assignTasks(intervals, t);
        }
    }

    public static void assignTasks(int[][] intervals, int testCaseNumber) {
        int[][] originalIntervals = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        StringBuilder result = new StringBuilder();
        Map<String, Character> taskAssignment = new HashMap<>();
        taskAssignment.put(intervals[0][0] + "-" + intervals[0][1], 'C');
        int cEnd = intervals[0][1];
        int jEnd = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= cEnd) {
                taskAssignment.put(intervals[i][0] + "-" + intervals[i][1], 'C');
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                taskAssignment.put(intervals[i][0] + "-" + intervals[i][1], 'J');
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        for (int[] interval : originalIntervals) {
            result.append(taskAssignment.get(interval[0] + "-" + interval[1]));
        }
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }
}