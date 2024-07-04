import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int originalTestCases = testCases;
        boolean printNewLine = false;

        while (testCases-- > 0) {
            if (printNewLine) {
                System.out.println();
            }
            printNewLine = true;

            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            int[][] sortedIntervals = intervals.clone();
            Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

            Map<String, List<Integer>> scheduleMap = new HashMap<>();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (!assignTask(scheduleMap, "J", sortedIntervals, i) && !assignTask(scheduleMap, "C", sortedIntervals, i)) {
                    possible = false;
                    break;
                }
            }

            String[] result = new String[n];
            if (possible) {
                fillResult(scheduleMap, result, "J");
                fillResult(scheduleMap, result, "C");

                for (int i = 0; i < n; i++) {
                    int startTime = intervals[i][0];
                    int endTime = intervals[i][1];
                    for (int j = 0; j < n; j++) {
                        if (sortedIntervals[j][0] == startTime && sortedIntervals[j][1] == endTime) {
                            String temp = result[i];
                            result[i] = result[j];
                            result[j] = temp;
                            break;
                        }
                    }
                }
            }

            String output = possible ? String.join("", result).trim() : "IMPOSSIBLE";
            System.out.println("Case #" + (originalTestCases - testCases) + ": " + output);
        }
    }

    private static boolean assignTask(Map<String, List<Integer>> scheduleMap, String person, int[][] intervals, int index) {
        List<Integer> tasks = scheduleMap.getOrDefault(person, new ArrayList<>());
        for (int taskIndex : tasks) {
            if ((intervals[index][0] < intervals[taskIndex][1]) && (intervals[index][1] > intervals[taskIndex][0])) {
                return false;
            }
        }
        tasks.add(index);
        scheduleMap.put(person, tasks);
        return true;
    }

    private static void fillResult(Map<String, List<Integer>> scheduleMap, String[] result, String person) {
        List<Integer> tasks = scheduleMap.get(person);
        if (tasks != null) {
            for (int taskIndex : tasks) {
                result[taskIndex] = person;
            }
        }
    }
}