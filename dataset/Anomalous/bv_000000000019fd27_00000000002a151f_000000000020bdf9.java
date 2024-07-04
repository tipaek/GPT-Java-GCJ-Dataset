import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Scheduler {
    private Map<String, List<List<Integer>>> scheduleMap = new HashMap<>();

    public String scheduleTasks(List<List<Integer>> tasks) {
        List<List<Integer>> cTasks = new ArrayList<>();
        List<List<Integer>> jTasks = new ArrayList<>();
        scheduleMap.put("C", cTasks);
        scheduleMap.put("J", jTasks);
        StringBuilder result = new StringBuilder();
        
        for (List<Integer> task : tasks) {
            String assigned = assignTask(task);
            if (assigned.equals("IMPOSSIBLE")) {
                return "IMPOSSIBLE";
            } else {
                result.append(assigned);
            }
        }
        return result.toString();
    }

    private String assignTask(List<Integer> task) {
        List<List<Integer>> cTasks = scheduleMap.get("C");
        List<List<Integer>> jTasks = scheduleMap.get("J");

        if (canAssignTask(cTasks, task)) {
            cTasks.add(task);
            return "C";
        }

        if (canAssignTask(jTasks, task)) {
            jTasks.add(task);
            return "J";
        }

        return "IMPOSSIBLE";
    }

    private boolean canAssignTask(List<List<Integer>> tasks, List<Integer> newTask) {
        for (List<Integer> task : tasks) {
            if (!(newTask.get(0) >= task.get(1) || newTask.get(1) <= task.get(0))) {
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