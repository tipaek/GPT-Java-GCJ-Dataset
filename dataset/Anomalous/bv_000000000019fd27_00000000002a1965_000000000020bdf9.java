import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Scheduler {
    private Map<String, List<List<Integer>>> taskMap = new HashMap<>();

    public Scheduler() {
        taskMap.put("C", new ArrayList<>());
        taskMap.put("J", new ArrayList<>());
    }

    public String scheduleTasks(List<List<Integer>> tasks) {
        StringBuilder result = new StringBuilder();

        for (List<Integer> task : tasks) {
            String assignedPerson = assignTask(task);
            if (assignedPerson.equals("IMPOSSIBLE")) {
                return "IMPOSSIBLE";
            }
            result.append(assignedPerson);
        }

        return result.toString();
    }

    private String assignTask(List<Integer> task) {
        if (canAssign(task, "C")) {
            taskMap.get("C").add(task);
            return "C";
        } else if (canAssign(task, "J")) {
            taskMap.get("J").add(task);
            return "J";
        } else {
            return "IMPOSSIBLE";
        }
    }

    private boolean canAssign(List<Integer> newTask, String person) {
        for (List<Integer> existingTask : taskMap.get(person)) {
            if (!(newTask.get(1) <= existingTask.get(0) || newTask.get(0) >= existingTask.get(1))) {
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

        for (int i = 1; i <= testCases; i++) {
            int taskCount = scanner.nextInt();
            List<List<Integer>> tasks = new ArrayList<>();

            for (int j = 0; j < taskCount; j++) {
                List<Integer> task = Arrays.asList(scanner.nextInt(), scanner.nextInt());
                tasks.add(task);
            }

            Scheduler scheduler = new Scheduler();
            String result = scheduler.scheduleTasks(tasks);
            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}