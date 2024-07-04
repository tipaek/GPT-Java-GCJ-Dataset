import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int intervalCount = scanner.nextInt();
            int[][] intervals = new int[intervalCount][2];

            for (int i = 0; i < intervalCount; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            String result = "Case #" + caseNum + ": " + assignTasks(intervals);
            System.out.println(result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        if (intervals.length == 0) return "IMPOSSIBLE";
        if (intervals.length == 1) return "C";

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        StringBuilder taskSequence = new StringBuilder();
        int cEndTime = 0, jEndTime = 0, taskCount = 0;

        for (int[] interval : intervals) {
            if (endTimes.isEmpty()) {
                taskSequence.append("C");
                cEndTime = interval[1];
                taskCount++;
                endTimes.offer(interval[1]);
            } else {
                if (interval[0] >= endTimes.peek()) {
                    if (cEndTime <= interval[0]) {
                        taskSequence.append("C");
                        cEndTime = interval[1];
                    } else if (jEndTime <= interval[0]) {
                        taskSequence.append("J");
                        jEndTime = interval[1];
                    }
                    endTimes.poll();
                } else {
                    if (jEndTime == 0) {
                        taskSequence.append("J");
                        jEndTime = interval[1];
                    } else if (cEndTime == 0) {
                        taskSequence.append("C");
                        cEndTime = interval[1];
                    }
                    taskCount++;
                    if (taskCount > 2) return "IMPOSSIBLE";
                }
                endTimes.offer(interval[1]);
            }
        }
        return taskSequence.toString();
    }
}