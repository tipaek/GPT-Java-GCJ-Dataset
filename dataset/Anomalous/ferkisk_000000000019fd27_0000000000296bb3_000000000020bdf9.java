import java.util.Scanner;

public class Solution {

    private Scanner scanner;

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i);
        }
        System.out.println("Done 123");
    }

    private void processTestCase(int testCaseNumber) {
        int taskCount = scanner.nextInt();
        Task[] tasks = new Task[taskCount];

        for (int i = 0; i < taskCount; i++) {
            tasks[i] = new Task(scanner.nextInt(), scanner.nextInt());
        }

        boolean assignmentPossible = assignTasks(tasks, 0);

        System.out.print("Case #" + testCaseNumber + ": ");
        if (assignmentPossible) {
            for (Task task : tasks) {
                System.out.print(task.assignedPerson);
            }
        } else {
            System.out.print("IMPOSSIBLE");
        }
        System.out.println();
    }

    private boolean assignTasks(Task[] tasks, int startIndex) {
        if (startIndex >= tasks.length) {
            return false;
        }

        for (int i = startIndex; i < tasks.length; i++) {
            if (canAssign(tasks, i, 'C')) {
                tasks[i].assignedPerson = 'C';
            } else if (canAssign(tasks, i, 'J')) {
                tasks[i].assignedPerson = 'J';
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean canAssign(Task[] tasks, int taskIndex, char person) {
        Task currentTask = tasks[taskIndex];

        for (int i = 0; i < tasks.length; i++) {
            if (i == taskIndex) continue;

            Task otherTask = tasks[i];

            if (otherTask.assignedPerson == person) {
                if ((currentTask.start < otherTask.end && currentTask.start >= otherTask.start) ||
                    (currentTask.end > otherTask.start && currentTask.end <= otherTask.end) ||
                    (currentTask.start <= otherTask.start && currentTask.end > otherTask.start)) {
                    return false;
                }
            }
        }
        return true;
    }

    class Task {
        int start;
        int end;
        char assignedPerson;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}