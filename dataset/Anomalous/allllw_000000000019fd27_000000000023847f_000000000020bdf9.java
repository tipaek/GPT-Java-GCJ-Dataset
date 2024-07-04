import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int numIntervals = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < numIntervals; i++) {
                intervals.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            }

            results.add(assignTasks(intervals));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String assignTasks(List<int[]> intervals) {
        TreeMap<Integer, Integer> eventMap = new TreeMap<>();
        Map<Integer, Integer> startCount = new HashMap<>();

        for (int[] interval : intervals) {
            eventMap.put(interval[0], eventMap.getOrDefault(interval[0], 0) + 1);
            eventMap.put(interval[1], eventMap.getOrDefault(interval[1], 0) - 1);
            startCount.put(interval[0], startCount.getOrDefault(interval[0], 0) + 1);
        }

        int ongoingTasks = 0;
        StringBuilder schedule = new StringBuilder();
        boolean assignToC = true;

        for (int time : eventMap.keySet()) {
            ongoingTasks += eventMap.get(time);

            if (ongoingTasks > 2) {
                return "IMPOSSIBLE";
            }

            if (startCount.containsKey(time)) {
                int startsAtThisTime = startCount.get(time);
                for (int i = 0; i < startsAtThisTime; i++) {
                    schedule.append(assignToC ? 'C' : 'J');
                    assignToC = !assignToC;
                }
            }
        }

        return schedule.toString();
    }
}