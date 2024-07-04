import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int originalTestCases = testCases;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            HashMap<String, ArrayList<Integer>> scheduleMap = new HashMap<>();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (!assignTask(scheduleMap, "C", startTimes[i], endTimes[i], i)) {
                    if (!assignTask(scheduleMap, "J", startTimes[i], endTimes[i], i)) {
                        possible = false;
                        break;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            if (possible) {
                String[] assignments = new String[n];
                if (scheduleMap.get("C") != null) {
                    for (int index : scheduleMap.get("C")) {
                        assignments[index] = "C";
                    }
                }
                if (scheduleMap.get("J") != null) {
                    for (int index : scheduleMap.get("J")) {
                        assignments[index] = "J";
                    }
                }
                for (String assignment : assignments) {
                    if (assignment == null) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                    result.append(assignment);
                }
            } else {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + (originalTestCases - testCases) + ": " + result);
        }
    }

    private static boolean assignTask(HashMap<String, ArrayList<Integer>> scheduleMap, String person, int startTime, int endTime, int index) {
        ArrayList<Integer> tasks = scheduleMap.get(person);
        if (tasks == null) {
            tasks = new ArrayList<>();
            tasks.add(index);
            scheduleMap.put(person, tasks);
            return true;
        }

        for (int taskIndex : tasks) {
            if (startTime < endTimes[taskIndex] && endTime > startTimes[taskIndex]) {
                return false;
            }
        }

        tasks.add(index);
        return true;
    }

    private static int[] startTimes;
    private static int[] endTimes;
}