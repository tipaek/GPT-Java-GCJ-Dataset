import java.util.*;

public class Solution {

    public static String assignSchedule(int[][] intervals) {
        Integer[] startTimes = new Integer[intervals.length];
        Integer[] endTimes = new Integer[intervals.length];
        Map<Integer, List<Integer>> scheduleMap = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
            scheduleMap.computeIfAbsent(startTimes[i], k -> new ArrayList<>()).add(endTimes[i]);
        }

        Arrays.sort(endTimes, Comparator.naturalOrder());
        Arrays.sort(startTimes, Comparator.naturalOrder());

        int startPointer = 0, endPointer = 0;
        Map<Character, Integer> currentTask = new HashMap<>();
        Map<Integer, String> finalSchedule = new HashMap<>();

        while (startPointer < intervals.length) {
            if (startTimes[startPointer] >= endTimes[endPointer]) {
                if (currentTask.get('C') != null && currentTask.get('C').equals(endTimes[endPointer])) {
                    currentTask.remove('C');
                } else {
                    currentTask.remove('J');
                }
                endPointer++;
            }

            if (!currentTask.containsKey('C')) {
                currentTask.put('C', scheduleMap.get(startTimes[startPointer]).remove(0));
                finalSchedule.put(startTimes[startPointer], "C");
            } else if (!currentTask.containsKey('J')) {
                currentTask.put('J', scheduleMap.get(startTimes[startPointer]).remove(0));
                finalSchedule.put(startTimes[startPointer], "J");
            } else {
                return "IMPOSSIBLE";
            }

            startPointer++;
        }

        StringBuilder parentSchedule = new StringBuilder();
        for (int[] interval : intervals) {
            int start = interval[0];
            if (finalSchedule.containsKey(start)) {
                parentSchedule.append(finalSchedule.get(start));
                finalSchedule.remove(start);
            } else {
                parentSchedule.append(finalSchedule.get(start + 'J'));
                finalSchedule.remove(start + 'J');
            }
        }

        return parentSchedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            String schedule = assignSchedule(intervals);
            System.out.println("Case #" + i + ": " + schedule);
        }
        scanner.close();
    }
}