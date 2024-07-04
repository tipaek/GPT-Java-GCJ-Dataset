import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }
            String schedule = determineSchedule(intervals, n);
            System.out.println("Case #" + testCase + ": " + schedule);
        }
        scanner.close();
    }

    private static String determineSchedule(int[][] intervals, int n) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int[] interval : intervals) {
            if (!priorityQueue.isEmpty() && priorityQueue.peek()[1] <= interval[0]) {
                priorityQueue.poll();
            }
            priorityQueue.add(interval);
        }

        if (priorityQueue.size() > 2) {
            return "IMPOSSIBLE";
        }

        HashSet<Integer> cIntervals = new HashSet<>();
        HashSet<Integer> jIntervals = new HashSet<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            boolean assigned = false;

            if (!cIntervals.contains(start)) {
                for (int t = start; t < end; t++) {
                    cIntervals.add(t);
                }
                result.append("C");
                assigned = true;
            }

            if (!assigned && !jIntervals.contains(start)) {
                for (int t = start; t < end; t++) {
                    jIntervals.add(t);
                }
                result.append("J");
            }
        }
        return result.toString();
    }
}