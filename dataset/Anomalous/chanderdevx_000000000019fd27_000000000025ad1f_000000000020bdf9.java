import java.util.*;

class Task {
    int id;
    int start;
    int end;
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfTasks = Integer.parseInt(scanner.nextLine());

            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < numberOfTasks; i++) {
                String[] input = scanner.nextLine().split(" ");
                Task task = new Task();
                task.id = i;
                task.start = Integer.parseInt(input[0]);
                task.end = Integer.parseInt(input[1]);

                tasks.add(task);
            }

            List<Task> cameronTasks = new ArrayList<>();
            List<Task> jamieTasks = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (Task currentTask : tasks) {
                if (isTaskAssignable(currentTask, cameronTasks)) {
                    cameronTasks.add(currentTask);
                    result.append("C");
                } else if (isTaskAssignable(currentTask, jamieTasks)) {
                    jamieTasks.add(currentTask);
                    result.append("J");
                } else {
                    isPossible = false;
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
    }

    private static boolean isTaskAssignable(Task currentTask, List<Task> assignedTasks) {
        for (Task task : assignedTasks) {
            if ((currentTask.start >= task.start && currentTask.start < task.end) ||
                (currentTask.end > task.start && currentTask.end <= task.end)) {
                return false;
            }
        }
        return true;
    }
}