import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            handleTestCase(i, scanner);
        }
    }

    private static void handleTestCase(int testCaseNumber, Scanner scanner) {
        int taskCount = scanner.nextInt();
        Task[] tasks = new Task[taskCount];
        for (int i = 0; i < taskCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            tasks[i] = new Task(i, start, end);
        }

        SortedSet<Task> sortedTasks = new TreeSet<>(Arrays.asList(tasks));

        Task[] sortedTaskArray = sortedTasks.toArray(new Task[0]);

        Stack<Task> camStack = new Stack<>();
        Stack<Task> julStack = new Stack<>();
        if (assignTasks(sortedTaskArray, 0, camStack, julStack)) {
            System.out.printf("Case #%d: ", testCaseNumber);
            for (Task task : tasks) {
                System.out.print(task.assignee);
            }
            System.out.println();
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", testCaseNumber);
        }
    }

    private static boolean assignTasks(Task[] tasks, int index, Stack<Task> camStack, Stack<Task> julStack) {
        if (index >= tasks.length) return true;
        Task currentTask = tasks[index];

        if (canAssignToStack(currentTask, camStack)) {
            currentTask.assignee = "C";
            camStack.push(currentTask);
            if (assignTasks(tasks, index + 1, camStack, julStack)) return true;
            camStack.pop();
        }

        if (canAssignToStack(currentTask, julStack)) {
            currentTask.assignee = "J";
            julStack.push(currentTask);
            if (assignTasks(tasks, index + 1, camStack, julStack)) return true;
            julStack.pop();
        }

        return false;
    }

    private static boolean canAssignToStack(Task task, Stack<Task> stack) {
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
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }
}