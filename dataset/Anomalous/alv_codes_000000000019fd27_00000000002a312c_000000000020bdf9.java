import java.util.*;
import java.io.*;

public class Solution {

    public static String assignSchedule(int[][] intervals) {
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        
        Map<Integer, List<Integer>> schedule = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            List<Integer> times = schedule.getOrDefault(intervals[i][0], new ArrayList<>());
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
            times.add(end[i]);
            schedule.put(start[i], times);
        }

        Arrays.sort(end, Comparator.naturalOrder());
        Arrays.sort(start, Comparator.naturalOrder());

        int startPointer = 0, endPointer = 0;
        Map<Character, Integer> currentTask = new HashMap<>();
        Map<Integer, String> finalSchedule = new HashMap<>();

        while (startPointer < intervals.length) {
            if (start[startPointer] >= end[endPointer]) {
                if (currentTask.get('C') != null && currentTask.get('C') == end[endPointer]) {
                    currentTask.remove('C');
                } else {
                    currentTask.remove('J');
                }
                endPointer++;
            }

            if (!currentTask.containsKey('C')) {
                currentTask.put('C', schedule.get(start[startPointer]).remove(0));
                finalSchedule.put(start[startPointer], "C");
            } else if (!currentTask.containsKey('J')) {
                currentTask.put('J', schedule.get(start[startPointer]).remove(0));
                finalSchedule.put(start[startPointer], "J");
            } else {
                return "IMPOSSIBLE";
            }
            startPointer++;
        }

        StringBuilder parentSchedule = new StringBuilder();

        for (int[] interval : intervals) {
            if (finalSchedule.containsKey(interval[0])) {
                parentSchedule.append(finalSchedule.get(interval[0]));
                finalSchedule.remove(interval[0]);
            } else {
                parentSchedule.append(finalSchedule.get(interval[0] + 'J'));
                finalSchedule.remove(interval[0] + 'J');
            }
        }

        return parentSchedule.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][2];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            String schedule = assignSchedule(matrix);
            System.out.println("Case #" + i + ": " + schedule);
        }
        in.close();
    }
}