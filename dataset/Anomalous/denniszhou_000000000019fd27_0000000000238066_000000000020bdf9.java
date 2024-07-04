import java.util.*;
import java.io.*;

public class Solution {

    private static List<String> results = new ArrayList<>();
    private static Map<Integer, Integer> cSchedule = new HashMap<>();
    private static Map<Integer, Integer> jSchedule = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }

            results = new ArrayList<>();
            cSchedule = new HashMap<>();
            jSchedule = new HashMap<>();

            if (isSchedulingPossible(intervals)) {
                findSchedules(intervals, new StringBuilder(), 0);
                System.out.println("Case #" + caseNumber + ": " + results.get(0));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isSchedulingPossible(int[][] intervals) {
        int[] timeCounts = new int[1441];
        
        for (int[] interval : intervals) {
            for (int time = interval[0] + 1; time <= interval[1]; time++) {
                timeCounts[time]++;
                if (timeCounts[time] > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void findSchedules(int[][] intervals, StringBuilder currentSchedule, int index) {
        if (index == intervals.length) {
            results.add(currentSchedule.toString());
        } else {
            for (int i = index; i < intervals.length && results.isEmpty(); i++) {
                if (!doesOverlap(intervals[i], cSchedule)) {
                    cSchedule.put(intervals[i][0], intervals[i][1]);
                    currentSchedule.append("C");
                    findSchedules(intervals, currentSchedule, index + 1);
                    cSchedule.remove(intervals[i][0]);
                    currentSchedule.deleteCharAt(currentSchedule.length() - 1);
                }
                if (!doesOverlap(intervals[i], jSchedule)) {
                    jSchedule.put(intervals[i][0], intervals[i][1]);
                    currentSchedule.append("J");
                    findSchedules(intervals, currentSchedule, index + 1);
                    jSchedule.remove(intervals[i][0]);
                    currentSchedule.deleteCharAt(currentSchedule.length() - 1);
                }
            }
        }
    }

    private static boolean doesOverlap(int[] interval, Map<Integer, Integer> schedule) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            if (Math.max(entry.getKey(), interval[0]) < Math.min(entry.getValue(), interval[1])) {
                return true;
            }
        }
        return false;
    }
}