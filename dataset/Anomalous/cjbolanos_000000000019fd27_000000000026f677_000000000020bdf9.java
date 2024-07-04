import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            processCase(i, in);
        }
    }

    static void processCase(int caseNo, Scanner in) {
        int taskCount = in.nextInt();
        Task[] tasks = new Task[taskCount];
        
        for (int i = 0; i < taskCount; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            tasks[i] = new Task(i, start, end);
        }

        SortedSet<Task> sortedTasks = new TreeSet<>(Arrays.asList(tasks));
        Task[] sortedTaskArray = sortedTasks.toArray(new Task[0]);

        Stack<Task> camStack = new Stack<>();
        Stack<Task> julStack = new Stack<>();
        
        if (assignTasks(sortedTaskArray, 0, camStack, julStack)) {
            System.out.printf("Case #%d: ", caseNo);
            for (Task task : tasks) {
                System.out.print(task.assignee);
            }
            System.out.println();
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", caseNo);
        }
    }

    static boolean assignTasks(Task[] tasks, int index, Stack<Task> camStack, Stack<Task> julStack) {
        if (index >= tasks.length) return true;

        Task currentTask = tasks[index];

        if (canAssignTask(camStack, currentTask, "C")) {
            camStack.push(currentTask);
            if (assignTasks(tasks, index + 1, camStack, julStack)) return true;
            camStack.pop();
        }

        if (canAssignTask(julStack, currentTask, "J")) {
            julStack.push(currentTask);
            if (assignTasks(tasks, index + 1, camStack, julStack)) return true;
            julStack.pop();
        }

        return false;
    }

    static boolean canAssignTask(Stack<Task> stack, Task task, String assignee) {
        if (stack.isEmpty() || !task.overlaps(stack.peek())) {
            task.assignee = assignee;
            return true;
        }
        return false;
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
            return !(this.end <= other.start || this.start >= other.end);
        }

        @Override
        public int compareTo(Task other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            if (this.end != other.end) {
                return Integer.compare(other.end, this.end);
            }
            return Integer.compare(this.id, other.id);
        }
    }
}