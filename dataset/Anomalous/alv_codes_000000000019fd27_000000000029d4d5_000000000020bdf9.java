import java.util.*;
import java.io.*;

public class Solution {

    public static String assignSchedule(int[][] intervals) {
        Integer[] startTimes = new Integer[intervals.length];
        Integer[] endTimes = new Integer[intervals.length];
        
        Map<Integer, Integer> intervalMap = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
            intervalMap.put(startTimes[i], endTimes[i]);
        }

        Arrays.sort(endTimes, Comparator.naturalOrder());
        Arrays.sort(startTimes, Comparator.naturalOrder());

        int startPointer = 0, endPointer = 0;

        Map<Character, Integer> activeTasks = new HashMap<>();    
        Map<Integer, String> assignedSchedule = new HashMap<>();

        while (startPointer < intervals.length) {
            if (startTimes[startPointer] >= endTimes[endPointer]) {
                if (activeTasks.get('C') != null && activeTasks.get('C').equals(endTimes[endPointer])) {
                    activeTasks.remove('C');
                } else {
                    activeTasks.remove('J');
                }
                endPointer++;
            }

            if (!activeTasks.containsKey('C')) {
                activeTasks.put('C', intervalMap.get(startTimes[startPointer]));
                assignedSchedule.put(startTimes[startPointer], "C");
            } else if (!activeTasks.containsKey('J')) {
                activeTasks.put('J', intervalMap.get(startTimes[startPointer]));
                assignedSchedule.put(startTimes[startPointer], "J");
            } else {
                return "IMPOSSIBLE";
            }
            startPointer++;
        }

        StringBuilder scheduleBuilder = new StringBuilder();
        for (int[] interval : intervals) {
            scheduleBuilder.append(assignedSchedule.get(interval[0]));
        }

        return scheduleBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt(); 
        for (int i = 1; i <= testCaseCount; ++i) {
            int intervalCount = scanner.nextInt();
            int[][] intervals = new int[intervalCount][2];
            for (int j = 0; j < intervalCount; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            String schedule = assignSchedule(intervals);
            System.out.println("Case #" + i + ": " + schedule);
        }
        scanner.close();
    }
}