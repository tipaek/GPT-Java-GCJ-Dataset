import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Scheduler {
    private final Map<String, List<List<Integer>>> taskMap = new HashMap<>();

    public Scheduler() {
        taskMap.put("C", new ArrayList<>());
        taskMap.put("J", new ArrayList<>());
    }

    public String taskScheduler(List<List<Integer>> input) {
        StringBuilder result = new StringBuilder();

        for (List<Integer> interval : input) {
            String assignedTo = assignTask(interval);
            if (assignedTo.equals("IMPOSSIBLE")) {
                return "IMPOSSIBLE";
            }
            result.append(assignedTo);
        }

        return result.toString();
    }

    private String assignTask(List<Integer> interval) {
        if (canAssignTask(interval, "C")) {
            taskMap.get("C").add(interval);
            return "C";
        } else if (canAssignTask(interval, "J")) {
            taskMap.get("J").add(interval);
            return "J";
        } else {
            return "IMPOSSIBLE";
        }
    }

    private boolean canAssignTask(List<Integer> interval, String person) {
        for (List<Integer> task : taskMap.get(person)) {
            if (!(interval.get(0) >= task.get(1) || interval.get(1) <= task.get(0))) {
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
                List<Integer> task = Arrays.asList(scanner.nextInt(), scanner.nextInt());
                tasks.add(task);
            }

            String result = scheduler.taskScheduler(tasks);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}