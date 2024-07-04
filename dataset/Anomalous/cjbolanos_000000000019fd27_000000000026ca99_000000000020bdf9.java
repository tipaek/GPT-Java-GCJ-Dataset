import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            handleCase(caseNumber, scanner);
        }
    }

    private static void handleCase(int caseNumber, Scanner scanner) {
        int numberOfTasks = scanner.nextInt();
        Task[] tasks = new Task[numberOfTasks];
        
        for (int i = 0; i < numberOfTasks; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            tasks[i] = new Task(i, start, end);
        }

        SortedSet<Task> sortedTasks = new TreeSet<>(Arrays.asList(tasks));
        Task[] sortedTasksArray = sortedTasks.toArray(new Task[0]);

        Stack<Task> cameron = new Stack<>();
        Stack<Task> jamie = new Stack<>();

        if (assignTasks(sortedTasksArray, 0, cameron, jamie)) {
            System.out.printf("Case #%d: ", caseNumber);
            for (Task task : tasks) {
                System.out.print(task.assignee);
            }
            System.out.println();
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", caseNumber);
        }
    }

    private static boolean assignTasks(Task[] tasks, int index, Stack<Task> cameron, Stack<Task> jamie) {
        if (index >= tasks.length) return true;

        Task currentTask = tasks[index];

        if (canAssignTask(cameron, currentTask)) {
            currentTask.assignee = "C";
            cameron.push(currentTask);
            if (assignTasks(tasks, index + 1, cameron, jamie)) return true;
            cameron.pop();
        }

        if (canAssignTask(jamie, currentTask)) {
            currentTask.assignee = "J";
            jamie.push(currentTask);
            if (assignTasks(tasks, index + 1, cameron, jamie)) return true;
            jamie.pop();
        }

        return false;
    }

    private static boolean canAssignTask(Stack<Task> stack, Task task) {
        return stack.isEmpty() || !task.overlaps(stack.peek());
    }

    static class Task implements Comparable<Task> {
        int id, start, end;
        String assignee;

        Task(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        boolean overlaps(Task other) {
            return !(other.end <= start || other.start >= end);
        }

        @Override
        public int compareTo(Task other) {
            if (start != other.start) {
                return Integer.compare(start, other.start);
            }
            return Integer.compare(end, other.end);
        }
    }
}