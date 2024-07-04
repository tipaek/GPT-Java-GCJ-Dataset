import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] timeSlots = new int[n][2];
            for (int i = 0; i < n; i++) {
                timeSlots[i][0] = scanner.nextInt();
                timeSlots[i][1] = scanner.nextInt();
            }

            Arrays.sort(timeSlots, Comparator.comparingInt(a -> a[0]));

            HashMap<String, ArrayList<Integer>> scheduleMap = new HashMap<>();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (!assignTask(scheduleMap, "J", timeSlots, i) && !assignTask(scheduleMap, "C", timeSlots, i)) {
                    possible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (possible) {
                String[] tasks = new String[n];
                fillTasks(scheduleMap, tasks, "C");
                fillTasks(scheduleMap, tasks, "J");
                for (String task : tasks) {
                    if (task == null) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                    result.append(task);
                }
            } else {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseNumber++ + ": " + result);
        }
    }

    private static boolean assignTask(HashMap<String, ArrayList<Integer>> scheduleMap, String person, int[][] timeSlots, int currentIndex) {
        ArrayList<Integer> taskList = scheduleMap.getOrDefault(person, new ArrayList<>());
        for (int taskIndex : taskList) {
            if (overlaps(timeSlots[taskIndex], timeSlots[currentIndex])) {
                return false;
            }
        }
        taskList.add(currentIndex);
        scheduleMap.put(person, taskList);
        return true;
    }

    private static boolean overlaps(int[] task1, int[] task2) {
        return task1[0] < task2[1] && task2[0] < task1[1];
    }

    private static void fillTasks(HashMap<String, ArrayList<Integer>> scheduleMap, String[] tasks, String person) {
        ArrayList<Integer> taskList = scheduleMap.get(person);
        if (taskList != null) {
            for (int taskIndex : taskList) {
                tasks[taskIndex] = person;
            }
        }
    }
}