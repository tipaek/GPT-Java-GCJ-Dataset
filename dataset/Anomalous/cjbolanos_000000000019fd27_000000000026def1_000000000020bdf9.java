import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 1; i <= cases; i++) {
            processCase(i, scanner);
        }
    }

    static void processCase(int caseNo, Scanner scanner) {
        int taskCount = scanner.nextInt();
        Task[] tasks = new Task[taskCount];
        for (int i = 0; i < taskCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            tasks[i] = new Task(i, start, end);
        }

        SortedSet<Task> sortedTasks = new TreeSet<>(Arrays.asList(tasks));
        Task[] taskArray = sortedTasks.toArray(new Task[0]);

        Stack<Task> cam = new Stack<>();
        Stack<Task> jul = new Stack<>();
        if (assignTasks(taskArray, 0, cam, jul)) {
            System.out.printf("Case #%d: ", caseNo);
            for (Task task : tasks) {
                System.out.print(task.assignee);
            }
            System.out.println();
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", caseNo);
        }
    }

    static boolean assignTasks(Task[] tasks, int index, Stack<Task> cam, Stack<Task> jul) {
        if (index >= tasks.length) return true;

        Task task = tasks[index];
        if (canAssign(task, cam)) {
            task.assignee = "C";
            cam.push(task);
            if (assignTasks(tasks, index + 1, cam, jul)) return true;
            cam.pop();
        }

        if (canAssign(task, jul)) {
            task.assignee = "J";
            jul.push(task);
            if (assignTasks(tasks, index + 1, cam, jul)) return true;
            jul.pop();
        }

        return false;
    }

    static boolean canAssign(Task task, Stack<Task> stack) {
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
            return !(other.end <= this.start || other.start >= this.end);
        }

        @Override
        public int compareTo(Task other) {
            if (this.start != other.start) return this.start - other.start;
            if (this.end != other.end) return this.end - other.end;
            return this.id - other.id;
        }
    }
}