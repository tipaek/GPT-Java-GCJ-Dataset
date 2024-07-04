import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numActivities = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                tasks.add(new Task(scanner.nextInt(), scanner.nextInt()));
            }

            String result = scheduleTasks(tasks);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String scheduleTasks(List<Task> tasks) {
        List<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort(Comparator.comparingInt(task -> task.start));

        int cEndTime = 0;
        int jEndTime = 0;
        Map<Task, String> assignment = new HashMap<>();

        for (Task task : sortedTasks) {
            if (cEndTime <= task.start) {
                assignment.put(task, "C");
                cEndTime = task.end;
            } else if (jEndTime <= task.start) {
                assignment.put(task, "J");
                jEndTime = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder order = new StringBuilder();
        for (Task task : tasks) {
            order.append(assignment.get(task));
        }

        return order.toString();
    }
}

class Task {
    public int start;
    public int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }
}