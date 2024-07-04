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
        for (int i = 1; i <= testCases; i++) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][2];

            for (int j = 0; j < numIntervals; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String result = "Case #" + i + ": " + assignTasks(intervals);
            System.out.println(result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        StringBuilder schedule = new StringBuilder();
        int cameronEndTime = 0;
        int jamieEndTime = 0;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        PriorityQueue<Integer> endTimeHeap = new PriorityQueue<>();
        int taskCount = 0;

        for (int[] interval : intervals) {
            if (endTimeHeap.isEmpty()) {
                schedule.append("C");
                cameronEndTime = interval[1];
                taskCount++;
                endTimeHeap.offer(interval[1]);
            } else {
                if (interval[0] >= endTimeHeap.peek()) {
                    if (cameronEndTime <= interval[0]) {
                        schedule.append("C");
                        cameronEndTime = interval[1];
                    } else if (jamieEndTime <= interval[0]) {
                        schedule.append("J");
                        jamieEndTime = interval[1];
                    }
                    endTimeHeap.poll();
                } else {
                    if (jamieEndTime == 0) {
                        schedule.append("J");
                        jamieEndTime = interval[1];
                    } else if (cameronEndTime == 0) {
                        schedule.append("C");
                        cameronEndTime = interval[1];
                    }
                    taskCount++;
                    if (taskCount > 2) {
                        return "IMPOSSIBLE";
                    }
                }
                endTimeHeap.offer(interval[1]);
            }
        }
        return schedule.toString();
    }
}