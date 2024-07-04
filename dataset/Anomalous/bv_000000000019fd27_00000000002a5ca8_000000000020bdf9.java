import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Scheduler {
    private Map<String, List<List<Integer>>> taskMap = new HashMap<>();

    public Scheduler() {
        taskMap.put("C", new ArrayList<>());
        taskMap.put("J", new ArrayList<>());
    }

    public String scheduleTasks(List<List<Integer>> input) {
        StringBuilder result = new StringBuilder();

        for (List<Integer> task : input) {
            String assignedTo = assignTask(task);
            if (assignedTo.equals("IMPOSSIBLE")) {
                return "IMPOSSIBLE";
            }
            result.append(assignedTo);
        }
        return result.toString();
    }

    private String assignTask(List<Integer> task) {
        if (canAssignTaskTo("C", task)) {
            taskMap.get("C").add(task);
            return "C";
        } else if (canAssignTaskTo("J", task)) {
            taskMap.get("J").add(task);
            return "J";
        }
        return "IMPOSSIBLE";
    }

    private boolean canAssignTaskTo(String person, List<Integer> task) {
        List<List<Integer>> tasks = taskMap.get(person);

        for (List<Integer> t : tasks) {
            if ((task.get(0) < t.get(1) && task.get(1) > t.get(0))) {
                return false;
            }
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        Scheduler scheduler = new Scheduler();

        for (int i = 1; i <= t; i++) {
            int numTasks = scanner.nextInt();
            List<List<Integer>> tasks = new ArrayList<>();

            for (int j = 0; j < numTasks; j++) {
                List<Integer> task = Arrays.asList(scanner.nextInt(), scanner.nextInt());
                tasks.add(task);
            }

            String result = scheduler.scheduleTasks(tasks);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}