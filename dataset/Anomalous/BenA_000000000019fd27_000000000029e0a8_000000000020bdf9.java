import java.io.*;
import java.util.*;

public class Solution {
    public static boolean isImpossible(int[] activityCounts) {
        for (int count : activityCounts) {
            if (count > 2) {
                return true;
            }
        }
        return false;
    }

    public static int[] calculateActivityTimes(int[][] intervals) {
        int maxTime = Arrays.stream(intervals)
                            .mapToInt(interval -> interval[1])
                            .max()
                            .orElse(0);

        int[] activityTimes = new int[maxTime + 1];
        Arrays.fill(activityTimes, 0);

        for (int[] interval : intervals) {
            for (int time = interval[0]; time < interval[1]; time++) {
                activityTimes[time]++;
            }
        }

        return activityTimes;
    }

    public static String generateSchedule(int[] activityCounts, int[][] intervals) {
        char[] assignments = new char[activityCounts.length];
        char[] taskAssignments = new char[intervals.length];
        Arrays.fill(taskAssignments, 'N');

        boolean hasUnassignedTasks = true;
        boolean changed;

        while (hasUnassignedTasks) {
            changed = false;
            for (int i = 0; i < taskAssignments.length; i++) {
                if (taskAssignments[i] == 'N') {
                    for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                        assignments[time] = 'C';
                    }
                    taskAssignments[i] = 'C';
                    break;
                }
            }

            for (int i = 0; i < intervals.length; i++) {
                if (taskAssignments[i] == 'N') {
                    for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                        if (assignments[time] == 'C') {
                            Arrays.fill(assignments, intervals[i][0], intervals[i][1], 'J');
                            taskAssignments[i] = 'J';
                            changed = true;
                            break;
                        } else if (assignments[time] == 'J') {
                            Arrays.fill(assignments, intervals[i][0], intervals[i][1], 'C');
                            taskAssignments[i] = 'C';
                            changed = true;
                            break;
                        }
                    }
                }
            }

            hasUnassignedTasks = Arrays.stream(taskAssignments).anyMatch(task -> task == 'N');
        }

        return new String(taskAssignments);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numIntervals = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[numIntervals][2];

            for (int i = 0; i < numIntervals; i++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }

            int[] activityCounts = calculateActivityTimes(intervals);

            if (isImpossible(activityCounts)) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + generateSchedule(activityCounts, intervals));
            }
        }
    }
}