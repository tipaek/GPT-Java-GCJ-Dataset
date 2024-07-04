import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static String checkSchedule(Map<Integer, Integer> map) {
        Map<Integer, Integer> cSchedule = new HashMap<>();
        Map<Integer, Integer> jSchedule = new HashMap<>();
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(map);
        StringBuilder result = new StringBuilder();

        int cEndTime = 0;
        int jEndTime = 0;

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            int startTime = entry.getKey();
            int endTime = entry.getValue();

            if (cSchedule.isEmpty() || startTime >= cEndTime) {
                cSchedule.put(startTime, endTime);
                cEndTime = endTime;
            } else if (jSchedule.isEmpty() || startTime >= jEndTime) {
                jSchedule.put(startTime, endTime);
                jEndTime = endTime;
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (cSchedule.containsKey(entry.getKey()) && cSchedule.get(entry.getKey()).equals(entry.getValue())) {
                result.append("C");
            } else if (jSchedule.containsKey(entry.getKey()) && jSchedule.get(entry.getKey()).equals(entry.getValue())) {
                result.append("J");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            scanner.nextLine();
            Map<Integer, Integer> scheduleMap = new LinkedHashMap<>();

            for (int i = 0; i < n; ++i) {
                String[] timeRange = scanner.nextLine().split(" ");
                int start = Integer.parseInt(timeRange[0]);
                int end = Integer.parseInt(timeRange[1]);
                scheduleMap.put(start, end);
            }

            String result = checkSchedule(scheduleMap);
            System.out.println("Case #" + t + ": " + result);
        }
    }
}