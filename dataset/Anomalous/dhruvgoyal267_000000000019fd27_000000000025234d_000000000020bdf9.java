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
                if (!assignTask(scheduleMap, "C", startTimes, endTimes, i) &&
                    !assignTask(scheduleMap, "J", startTimes, endTimes, i)) {
                    possible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (!possible) {
                result.append("IMPOSSIBLE");
            } else {
                String[] assignedTasks = new String[n];
                for (Map.Entry<String, ArrayList<Integer>> entry : scheduleMap.entrySet()) {
                    String person = entry.getKey();
                    for (int index : entry.getValue()) {
                        assignedTasks[index] = person;
                    }
                }
                for (String task : assignedTasks) {
                    result.append(task);
                }
            }

            System.out.println("Case #" + (originalTestCases - testCases) + ": " + result);
        }
        scanner.close();
    }

    private static boolean assignTask(HashMap<String, ArrayList<Integer>> map, String person, int[] startTimes, int[] endTimes, int index) {
        if (!map.containsKey(person)) {
            map.put(person, new ArrayList<>(Collections.singletonList(index)));
            return true;
        }

        ArrayList<Integer> taskList = map.get(person);
        for (int taskIndex : taskList) {
            if (startTimes[index] < endTimes[taskIndex] && endTimes[index] > startTimes[taskIndex]) {
                return false;
            }
        }

        taskList.add(index);
        map.put(person, taskList);
        return true;
    }
}