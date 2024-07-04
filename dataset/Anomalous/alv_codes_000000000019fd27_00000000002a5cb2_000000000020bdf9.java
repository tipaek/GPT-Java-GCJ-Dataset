import java.util.*;
import java.io.*;

public class Solution {

    public static String assignSchedule(int[][] intervals) {
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        HashMap<Integer, ArrayList<Integer>> schedule = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            ArrayList<Integer> times = schedule.getOrDefault(intervals[i][0], new ArrayList<>());
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
            times.add(end[i]);
            schedule.put(start[i], times);
        }

        Arrays.sort(end, Comparator.comparingInt(a -> a));
        Arrays.sort(start, Comparator.comparingInt(a -> a));

        int startPointer = 0, endPointer = 0;
        HashMap<Character, Integer> currentTask = new HashMap<>();
        HashMap<Integer, String> finalSchedule = new HashMap<>();

        while (startPointer < intervals.length) {
            if (start[startPointer] >= end[endPointer]) {
                if (currentTask.get('C') != null && currentTask.get('C').equals(end[endPointer])) {
                    currentTask.remove('C');
                } else {
                    currentTask.remove('J');
                }
                endPointer++;
            }

            if (!currentTask.containsKey('C')) {
                currentTask.put('C', schedule.get(start[startPointer]).get(0));
                schedule.get(start[startPointer]).remove(0);
                finalSchedule.put(start[startPointer], "C");
            } else if (!currentTask.containsKey('J')) {
                currentTask.put('J', schedule.get(start[startPointer]).get(0));
                schedule.get(start[startPointer]).remove(0);
                finalSchedule.put(start[startPointer] + 'J', "J");
            } else {
                return "IMPOSSIBLE";
            }

            startPointer++;
        }

        StringBuilder parentSchedule = new StringBuilder();
        for (int[] interval : intervals) {
            if (finalSchedule.get(interval[0]) != null) {
                parentSchedule.append('C');
                finalSchedule.remove(interval[0]);
            } else {
                parentSchedule.append('J');
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
                matrix[j][0] = in.nextInt();
                matrix[j][1] = in.nextInt();
            }
            String schedule = assignSchedule(matrix);
            System.out.println("Case #" + i + ": " + schedule);
        }
    }
}