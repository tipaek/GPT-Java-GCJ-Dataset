import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][2];

            for (int i = 0; i < numIntervals; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            String result = "Case #" + caseNum + ": " + assignTasks(intervals);
            System.out.println(result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        StringBuilder sequence = new StringBuilder();
        int cameronEndTime = 0;
        int jamieEndTime = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        int concurrentTasks = 0;

        for (int[] interval : intervals) {
            if (endTimes.isEmpty()) {
                sequence.append("C");
                cameronEndTime = interval[1];
                concurrentTasks++;
                endTimes.offer(interval[1]);
            } else {
                if (interval[0] >= endTimes.peek()) {
                    if (cameronEndTime <= interval[0]) {
                        sequence.append("C");
                        cameronEndTime = interval[1];
                    } else if (jamieEndTime <= interval[0]) {
                        sequence.append("J");
                        jamieEndTime = interval[1];
                    }
                    endTimes.poll();
                } else {
                    if (jamieEndTime == 0) {
                        sequence.append("J");
                        jamieEndTime = interval[1];
                    }
                    concurrentTasks++;
                }
                if (concurrentTasks > 2) {
                    return "IMPOSSIBLE";
                }
                endTimes.offer(interval[1]);
            }
        }
        return sequence.toString();
    }
}