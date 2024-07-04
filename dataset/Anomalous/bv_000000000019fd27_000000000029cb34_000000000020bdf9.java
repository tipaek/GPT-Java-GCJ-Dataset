import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Scheduler {
    private Map<String, List<List<Integer>>> taskMap;

    public Scheduler() {
        taskMap = new HashMap<>();
        taskMap.put("C", new ArrayList<>());
        taskMap.put("J", new ArrayList<>());
    }

    public String scheduleTasks(List<List<Integer>> inputTasks) {
        StringBuilder result = new StringBuilder();
        for (List<Integer> task : inputTasks) {
            String assigned = assignTask(task);
            if (assigned.equals("IMPOSSIBLE")) {
                return "IMPOSSIBLE";
            }
            result.append(assigned);
        }
        return result.toString();
    }

    private String assignTask(List<Integer> task) {
        if (canAssignTask(task, "C")) {
            taskMap.get("C").add(task);
            return "C";
        }
        if (canAssignTask(task, "J")) {
            taskMap.get("J").add(task);
            return "J";
        }
        return "IMPOSSIBLE";
    }

    private boolean canAssignTask(List<Integer> task, String person) {
        for (List<Integer> existingTask : taskMap.get(person)) {
            if (task.get(0) < existingTask.get(1) && task.get(1) > existingTask.get(0)) {
                return false;
            }
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        Scheduler scheduler = new Scheduler();
        for (int i = 1; i <= testCases; i++) {
            int taskCount = scanner.nextInt();
            List<List<Integer>> tasks = new ArrayList<>();

            for (int j = 0; j < taskCount; j++) {
                List<Integer> task = new ArrayList<>();
                task.add(scanner.nextInt());
                task.add(scanner.nextInt());
                tasks.add(task);
            }

            String result = scheduler.scheduleTasks(tasks);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}