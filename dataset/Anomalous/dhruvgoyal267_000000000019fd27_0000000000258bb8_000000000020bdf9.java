import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            HashMap<String, ArrayList<Integer>> scheduleMap = new HashMap<>();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (!canAssignTask(scheduleMap, "C", i, startTimes, endTimes)) {
                    if (!canAssignTask(scheduleMap, "J", i, startTimes, endTimes)) {
                        isPossible = false;
                        break;
                    }
                }
            }

            String result;
            if (isPossible) {
                result = buildScheduleResult(scheduleMap, n);
            } else {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    private static boolean canAssignTask(HashMap<String, ArrayList<Integer>> scheduleMap, String person, int taskIndex, int[] startTimes, int[] endTimes) {
        if (!scheduleMap.containsKey(person)) {
            scheduleMap.put(person, new ArrayList<>());
        }

        ArrayList<Integer> tasks = scheduleMap.get(person);
        for (int assignedTask : tasks) {
            if (startTimes[taskIndex] < endTimes[assignedTask] && endTimes[taskIndex] > startTimes[assignedTask]) {
                return false;
            }
        }

        tasks.add(taskIndex);
        return true;
    }

    private static String buildScheduleResult(HashMap<String, ArrayList<Integer>> scheduleMap, int n) {
        String[] resultArray = new String[n];

        for (Map.Entry<String, ArrayList<Integer>> entry : scheduleMap.entrySet()) {
            String person = entry.getKey();
            ArrayList<Integer> tasks = entry.getValue();
            for (int task : tasks) {
                resultArray[task] = person;
            }
        }

        StringBuilder result = new StringBuilder();
        for (String assignment : resultArray) {
            if (assignment == null) {
                return "IMPOSSIBLE";
            }
            result.append(assignment);
        }

        return result.toString();
    }
}