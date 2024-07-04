import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            HashMap<String, ArrayList<Integer>> scheduleMap = new HashMap<>();
            String result = assignTasks(startTimes, endTimes, scheduleMap, n);

            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignTasks(int[] startTimes, int[] endTimes, HashMap<String, ArrayList<Integer>> scheduleMap, int n) {
        for (int i = 0; i < n; i++) {
            if (!assignTaskToPerson("J", startTimes, endTimes, scheduleMap, i)) {
                if (!assignTaskToPerson("C", startTimes, endTimes, scheduleMap, i)) {
                    return "IMPOSSIBLE";
                }
            }
        }
        return buildResult(scheduleMap, n);
    }

    private static boolean assignTaskToPerson(String person, int[] startTimes, int[] endTimes, HashMap<String, ArrayList<Integer>> scheduleMap, int taskIndex) {
        ArrayList<Integer> tasks = scheduleMap.getOrDefault(person, new ArrayList<>());

        for (int assignedTask : tasks) {
            if (startTimes[taskIndex] < endTimes[assignedTask] && endTimes[taskIndex] > startTimes[assignedTask]) {
                return false;
            }
        }

        tasks.add(taskIndex);
        scheduleMap.put(person, tasks);
        return true;
    }

    private static String buildResult(HashMap<String, ArrayList<Integer>> scheduleMap, int n) {
        String[] results = new String[n];

        for (Map.Entry<String, ArrayList<Integer>> entry : scheduleMap.entrySet()) {
            String person = entry.getKey();
            for (int taskIndex : entry.getValue()) {
                results[taskIndex] = person;
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (String res : results) {
            resultBuilder.append(res);
        }

        return resultBuilder.toString();
    }
}