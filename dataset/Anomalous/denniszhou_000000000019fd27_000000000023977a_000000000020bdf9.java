import java.util.*;
import java.io.*;

public class Solution {

    private static List<String> results = new ArrayList<>();
    private static Map<Integer, Integer> cMap = new HashMap<>();
    private static Map<Integer, Integer> jMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= testCases; ++i) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[j][0] = Integer.parseInt(input[0]);
                intervals[j][1] = Integer.parseInt(input[1]);
            }

            results.clear();
            cMap.clear();
            jMap.clear();

            if (isPossible(intervals)) {
                findSchedules(intervals, new StringBuilder(), 0);
                System.out.println("Case #" + i + ": " + results.get(0));
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossible(int[][] intervals) {
        int[] counts = new int[1441];
        
        for (int[] interval : intervals) {
            for (int time = interval[0] + 1; time <= interval[1]; time++) {
                counts[time]++;
                if (counts[time] > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void findSchedules(int[][] intervals, StringBuilder schedule, int index) {
        if (index == intervals.length) {
            results.add(schedule.toString());
        } else {
            for (int i = index; i < intervals.length && results.isEmpty(); i++) {
                if (tryAssign(intervals[i], schedule, 'C', cMap)) {
                    findSchedules(intervals, schedule, index + 1);
                    unassign(intervals[i], schedule, cMap);
                }
                if (tryAssign(intervals[i], schedule, 'J', jMap)) {
                    findSchedules(intervals, schedule, index + 1);
                    unassign(intervals[i], schedule, jMap);
                }
            }
        }
    }

    private static boolean tryAssign(int[] interval, StringBuilder schedule, char person, Map<Integer, Integer> map) {
        if (!hasOverlap(interval, map)) {
            map.put(interval[0], interval[1]);
            schedule.append(person);
            return true;
        }
        return false;
    }

    private static void unassign(int[] interval, StringBuilder schedule, Map<Integer, Integer> map) {
        map.remove(interval[0]);
        schedule.deleteCharAt(schedule.length() - 1);
    }

    private static boolean hasOverlap(int[] interval, Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (Math.max(entry.getKey(), interval[0]) < Math.min(entry.getValue(), interval[1])) {
                return true;
            }
        }
        return false;
    }
}