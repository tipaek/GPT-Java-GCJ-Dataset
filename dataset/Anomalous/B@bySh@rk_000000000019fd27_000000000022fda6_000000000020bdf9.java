import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
            System.out.println("Case #" + testCase + ": " + getSchedule(intervals, n));
        }
        scanner.close();
    }

    private static String getSchedule(int[][] intervals, int n) {
        StringBuilder schedule = new StringBuilder();
        Map<Integer, Integer> timeline = new TreeMap<>();
        for (int[] interval : intervals) {
            timeline.put(interval[0], timeline.getOrDefault(interval[0], 0) + 1);
            timeline.put(interval[1], timeline.getOrDefault(interval[1], 0) - 1);
        }

        int maxConcurrent = 0, currentConcurrent = 0;
        for (int value : timeline.values()) {
            currentConcurrent += value;
            maxConcurrent = Math.max(maxConcurrent, currentConcurrent);
        }

        if (maxConcurrent > 2) {
            return "IMPOSSIBLE";
        }

        HashSet<Integer> cameronSchedule = new HashSet<>();
        HashSet<Integer> jamieSchedule = new HashSet<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (canSchedule(cameronSchedule, start, end)) {
                addToSchedule(cameronSchedule, start, end);
                schedule.append("C");
            } else {
                addToSchedule(jamieSchedule, start, end);
                schedule.append("J");
            }
        }
        return schedule.toString();
    }

    private static boolean canSchedule(HashSet<Integer> schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private static void addToSchedule(HashSet<Integer> schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule.add(i);
        }
    }
}