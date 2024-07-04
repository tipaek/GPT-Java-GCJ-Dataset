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
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }
            System.out.println(determineSchedule(intervals, n));
        }
        scanner.close();
    }

    private static String determineSchedule(int[][] intervals, int n) {
        StringBuilder schedule = new StringBuilder();
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
        
        HashSet<Integer> cTimes = new HashSet<>();
        HashSet<Integer> jTimes = new HashSet<>();
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            boolean assigned = false;
            
            if (canAssignTime(cTimes, start, end)) {
                assignTime(cTimes, start, end);
                schedule.append("C");
                assigned = true;
            }
            
            if (!assigned && canAssignTime(jTimes, start, end)) {
                assignTime(jTimes, start, end);
                schedule.append("J");
            }
        }
        
        return schedule.toString();
    }

    private static boolean canAssignTime(HashSet<Integer> times, int start, int end) {
        for (int t = start; t < end; t++) {
            if (times.contains(t)) {
                return false;
            }
        }
        return true;
    }

    private static void assignTime(HashSet<Integer> times, int start, int end) {
        for (int t = start; t < end; t++) {
            times.add(t);
        }
    }
}